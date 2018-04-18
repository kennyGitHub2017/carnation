package com.sinco.carnation.goldEgg.service;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.goldEgg.bo.ActGlodEggBO;
import com.sinco.carnation.goldEgg.bo.GlodEggItemBO;
import com.sinco.carnation.goldEgg.bo.GlodEggRecordBO;
import com.sinco.carnation.goldEgg.dao.ActGlodEggDao;
import com.sinco.carnation.goldEgg.dao.GlodEggItemDao;
import com.sinco.carnation.goldEgg.dao.GlodEggRecordDao;
import com.sinco.carnation.goldEgg.model.ActGlodEgg;
import com.sinco.carnation.goldEgg.model.GlodEggRecord;
import com.sinco.carnation.goldEgg.model.GlodEggRecordExample;
import com.sinco.carnation.market.dao.ActivityHotSaleDao;
import com.sinco.carnation.sys.mapper.UserAccountMapper;
import com.sinco.carnation.sys.model.UserAccount;
import com.sinco.carnation.user.mapper.UserCustomerMapper;
import com.sinco.carnation.user.mapper.UserRelationMapper;
import com.sinco.carnation.user.model.UserCustomer;
import com.sinco.carnation.user.service.UserMoneyService;

@Service
@Transactional
public class ActGlodEggService {
	@Autowired
	private GlodEggRecordDao glodEggRecordDao;
	@Autowired
	private ActivityHotSaleDao activityHotSaleDao;
	@Autowired
	private UserAccountMapper userAccountMapper;
	@Autowired
	private UserCustomerMapper userCustomerMapper;
	@Autowired
	private UserRelationMapper userRelationMapper;
	@Autowired
	private UserMoneyService userMoneyService;

	@Autowired
	private ActGlodEggDao actGlodEggDao;

	@Autowired
	private GlodEggItemDao glodEggItemDao;

	public ActGlodEgg save(ActGlodEgg obj) {
		return this.actGlodEggDao.save(obj);
	}

	public int deleteByActID(Long act_id) {
		ActGlodEgg actGlodEgg = new ActGlodEgg();
		actGlodEgg.setActId(act_id);
		actGlodEgg = this.actGlodEggDao.findByActID(actGlodEgg);
		if (actGlodEgg == null) {
			return 1;
		}
		long actGlodEggID = actGlodEgg.getId();
		this.actGlodEggDao.delete(actGlodEggID);
		this.glodEggItemDao.deleteByGlodEggID(actGlodEggID);

		return 0;
	}

	public List<ActGlodEggBO> findAll() {
		return this.actGlodEggDao.findAll();
	}

	/**
	 * 获取砸金蛋活动
	 * 
	 * @return
	 */
	public ActGlodEggBO getActGlodEgg() {
		List<ActGlodEggBO> vos = actGlodEggDao.findAll();
		if (vos != null && vos.size() > 0) {
			ActGlodEggBO vo = vos.get(0);
			vo.setActivityHotSale(activityHotSaleDao.findOne(vo.getActId()));
			return vo;
		}
		return null;
	}

	/**
	 * 计算中奖率，从奖项中随机抽取一个奖品
	 * 
	 * @param actGlodEggBo
	 *            砸金蛋活动
	 * @param userId
	 *            砸金蛋用户
	 * @param index
	 *            记录是哪一个金蛋0-2
	 * @return
	 */
	public GlodEggItemBO calGlodEggItem(ActGlodEggBO actGlodEggBo, long userId, int index) {
		// 计算中奖率0-100
		if (!isWinner(actGlodEggBo.getPriority())) {
			// 没中奖，保存抽奖记录
			saveActRecord(userId, actGlodEggBo.getId(), index, null);
			return null;
		}
		// 中奖啦，取出所有奖项
		List<GlodEggItemBO> items = glodEggItemDao.findAll();
		// 随机抽取一件
		GlodEggItemBO item = calGlodEggItem(items);
		if (item == null) {
			saveActRecord(userId, actGlodEggBo.getId(), index, null);
			return null;
		}
		// 当前中奖数是否大于奖品发放数量
		if (item.getCurrentGetCount() >= item.getTotalCount()) {
			saveActRecord(userId, actGlodEggBo.getId(), index, null);
			return null;
		}
		// 当前奖品金额+已中奖金额是否大于日限金额
		BigDecimal money = item.getTotalMoney().add(staticsCurrentGrantMoney());
		if (money.compareTo(actGlodEggBo.getDayLimitMoney()) == 1) {
			saveActRecord(userId, actGlodEggBo.getId(), index, null);
			return null;
		}
		// 添加已中奖数量
		glodEggItemDao.addCurrentGetCount(item.getId(), 1);
		// 添加已发放金额
		actGlodEggDao.addCurrentGetMoney(actGlodEggBo.getId(), item.getTotalMoney());
		// 添加记录
		saveActRecord(userId, actGlodEggBo.getId(), index, item);
		// 更新用户云豆
		userMoneyService.addMoney(userId, item.getTotalMoney().doubleValue(), null, "充值", "砸金蛋活动奖励");
		return item;
	}

	/**
	 * 判断当前用户是否有条件砸这个鸡蛋
	 * 
	 * @param userId
	 *            用户ID
	 * @param eggIndex
	 *            鸡蛋ID
	 * @param startTime
	 *            活动开始时间
	 * @return
	 */
	public boolean isAllowGetGlodEgg(long userId, int eggIndex, Date startTime) {
		List<GlodEggRecordBO> records = getGlodEggRecord(userId);
		if (records != null && records.size() > 0) {
			// 最多三次
			if (records.size() >= 3) {
				return false;
			}
			// 当前金蛋是否已经砸过
			for (GlodEggRecordBO record : records) {
				if (record.getEggIndex() == eggIndex) {
					return false;
				}
			}
			// 已经砸过了，计算从活动开始，用户是否有新的被推荐人
			// 如果新推荐人>0增加一次机会>1增加两次机会，共三次
			int count = userRelationMapper.staticsRefereeRegCount(userId, startTime);
			if (count >= records.size()) {
				return true;
			} else {
				return false;
			}
		} else {
			// 默认有一次砸蛋机会
			return true;
		}
	}

	/**
	 * 计算当前用户还能砸几次，根据用户分享注册成功的次数会发生变化，最多三次
	 * 
	 * @param userId
	 *            用户ID
	 * @param startTime
	 *            活动开始时间算起
	 * @return
	 */
	public int allowGetGlodEggCount(long userId, Date startTime) {
		List<GlodEggRecordBO> records = getGlodEggRecord(userId);
		if (records != null && records.size() > 0) {
			// 最多三次
			if (records.size() >= 3) {
				return 0;
			}
			// 已经砸过了，计算从活动开始，用户是否有新的被推荐人
			// 如果新推荐人>0增加一次机会>1增加两次机会，共三次
			int count = userRelationMapper.staticsRefereeRegCount(userId, startTime);
			if (count >= 2) {
				count = 3;
			}
			return count > records.size() ? count - records.size() : 0;
		} else {
			// 默认有一次砸蛋机会
			int count = userRelationMapper.staticsRefereeRegCount(userId, startTime);
			if (count >= 2) {
				count = 2;
			}
			return count + 1;
		}
	}

	/**
	 * 获取用户中奖记录
	 * 
	 * @param userId
	 * @return
	 */
	public List<GlodEggRecordBO> getGlodEggRecord(long userId) {
		GlodEggRecordExample example = new GlodEggRecordExample();
		example.createCriteria().andUidEqualTo(userId);
		List<GlodEggRecordBO> records = glodEggRecordDao.findByExample(example);
		return records;
	}

	/**
	 * 统计当天已中奖金额
	 * 
	 * @return
	 */
	private BigDecimal staticsCurrentGrantMoney() {
		Date now = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		Date startDate = calendar.getTime();
		calendar.add(Calendar.DATE, 1);
		Date endDate = calendar.getTime();
		BigDecimal grantMoney = glodEggRecordDao.staticsCurrentGrantMoney(startDate, endDate);
		return grantMoney == null ? BigDecimal.ZERO : grantMoney;
	}

	/**
	 * 根据算法从奖品列表中随机抽取一个
	 * 
	 * @param items
	 * @return
	 */
	private GlodEggItemBO calGlodEggItem(List<GlodEggItemBO> items) {
		if (items == null || items.size() == 0) {
			return null;
		}
		Random random = new Random(new Date().getTime());
		int index = random.nextInt(items.size());
		return items.get(index);
	}

	/**
	 * 保存活动记录
	 * 
	 * @param userId
	 *            用户ID
	 * @param actGlodEggId
	 *            活动ID
	 * @param eggIndex
	 *            金蛋索引
	 * @param item
	 *            中奖项
	 */
	private void saveActRecord(long userId, Long actGlodEggId, int eggIndex, GlodEggItemBO item) {
		// 获取用户信息
		UserAccount account = userAccountMapper.findUserAccount(userId, 8);
		UserCustomer customer = userCustomerMapper.selectByPrimaryKey(userId);
		// 写入记录
		GlodEggRecord record = new GlodEggRecord();
		record.setUid(userId);
		record.setMoney(item == null ? BigDecimal.ZERO : item.getTotalMoney());
		record.setCreateTime(new Date());
		record.setCnAccount(account == null ? null : account.getLoginName());
		if (customer != null) {
			record.setMobile(customer.getMobile());
			record.setNickName(customer.getNickname());
			record.setAppName(customer.getName());
		}
		record.setEggIndex((byte) eggIndex);
		record.setGlodEggId(actGlodEggId);
		glodEggRecordDao.save(record);
	}

	/**
	 * 根据权重值计算中奖率
	 * 
	 * @param priority
	 * @return
	 */
	private boolean isWinner(Integer priority) {
		if (priority == null || priority <= 0) {
			// 权重值太低，砸不中哈
			return false;
		}
		priority = 1 * 100 / priority;
		Random rand = new Random(new Date().getTime());
		int r = rand.nextInt(priority) + 1;
		return r == priority;
	}

	public List<ActGlodEggBO> findListByActID(long act_id) {
		return this.actGlodEggDao.findListByActID(act_id);
	}

	public void update(ActGlodEgg obj) {
		this.actGlodEggDao.update(obj);
	}
}
