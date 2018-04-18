package com.sinco.carnation.market.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.elasticsearch.common.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.market.bo.ActRedPackageBO;
import com.sinco.carnation.market.bo.RedPackageGetRecordBO;
import com.sinco.carnation.market.dao.ActRedPackageDao;
import com.sinco.carnation.market.dao.RedPackageGetRecordDao;
import com.sinco.carnation.market.enums.EmFixType;
import com.sinco.carnation.market.model.ActRedPackage;
import com.sinco.carnation.market.model.RedPackageGetRecord;
import com.sinco.carnation.market.vo.ActRedPackageVO;
import com.sinco.carnation.market.vo.RedPackageGetRecordVO;
import com.sinco.carnation.sys.service.AccessoryServiceImpl;
import com.sinco.dal.common.MyPage;

/**
 * 红包活动相关Service
 * 
 * @author 陈舟
 * 
 */
@Service
public class ActRedPackageService {

	@Autowired
	ActRedPackageDao actRedPackageDao;
	@Autowired
	RedPackageGetRecordDao redPackageGetRecordDao;
	@Autowired
	private AccessoryServiceImpl accessoryService;

	/**
	 * 所有红包列表
	 * 
	 */
	public List<ActRedPackageBO> findAll() {

		return this.actRedPackageDao.findAll();
	}

	/**
	 * 统计抢红包金额
	 * 
	 * @param id
	 * @return
	 */
	public Float getSumMoney(Long id) {
		return this.redPackageGetRecordDao.getSumMoney(id);
	}

	/**
	 * 红包分页查询
	 * 
	 * @param vo
	 * @param page
	 * @return
	 */
	public List<ActRedPackageBO> findAllByPage(ActRedPackageVO vo, MyPage<ActRedPackageBO> page) {
		/*
		 * if (vo.getStatus() != null) {
		 * 
		 * if (vo.getStatus() == EmRedPackageStatus.UnStart.ordinal()) {
		 * vo.setStartTime(new Date()); } else if (vo.getStatus() ==
		 * EmRedPackageStatus.Doing.ordinal()) { vo.setIsOver(false);
		 * 
		 * 
		 * } else if (vo.getStatus() == EmRedPackageStatus.End.ordinal()) {
		 * 
		 * } }
		 */
		return this.actRedPackageDao.findAllByPage(vo, page);
	}

	/**
	 * 保存红包
	 * 
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@Transactional(readOnly = false)
	public ActRedPackage save(HttpServletRequest request, ActRedPackageVO vo) throws Exception {
		if (vo.getId() <= 0) {
			vo.setId(null);

		} else {

			if (this.redPackageGetRecordDao.existsOpenRedPackageRecord(vo.getId())) {
				throw new Exception("红包已被人领取，无法重新保存！");
			}

			this.redPackageGetRecordDao.deleteByPackageId(vo.getId());
		}

		// 生成红包
		StringBuilder errMsg = new StringBuilder();

		List<BigDecimal> list = this.generateRedPackage(vo.getMinMoney(), vo.getMaxMoney(),
				EmFixType.fromInt(vo.getFixType()), vo.getTotalMoney(), vo.getTotalCount(), errMsg);

		if (StringUtils.isNotBlank(errMsg)) {
			throw new Exception(errMsg.toString());
		}
		// 上传文件处理
		String logoPath = accessoryService.upload(request, "logoPathStr", vo.getLogoPath());
		if (StringUtils.isNotEmpty(logoPath)) {
			vo.setLogoPath(logoPath);
		}

		// 保存红包
		ActRedPackage actRedPackage = this.actRedPackageDao.save(vo);
		RedPackageGetRecord model;
		for (BigDecimal item : list) {
			model = new RedPackageGetRecord();
			model.setCreatedTime(new Date());
			model.setDeleteStatus((byte) 0);
			model.setPackageId(actRedPackage.getId());
			model.setStatus((byte) 0);
			model.setMoney(item);
			model.setOffTime(actRedPackage.getEndTime());
			this.redPackageGetRecordDao.save(model);
		}
		return actRedPackage;
	}

	/**
	 * 根据id查询红包
	 * 
	 * @param id
	 * @return
	 */
	public ActRedPackageBO findRedPackageById(Long id) {
		return this.actRedPackageDao.findOne(id);
	}

	/**
	 * 根据id删除
	 * 
	 * @param id
	 */
	@Transactional(readOnly = false)
	public void deleteRedPackage(String strIds) {
		String[] idArray = strIds.split(",");
		for (String string : idArray) {
			ActRedPackage model = new ActRedPackage();
			model.setId(CommUtil.null2Long(string));
			model.setDeleteStatus((byte) 1);
			if (model.getId() > 0L) {
				this.actRedPackageDao.update(model);
			}
		}

	}

	/**
	 * 开启操作
	 * 
	 * @param id
	 * @param isEnabled
	 */
	@Transactional(readOnly = false)
	public void handleRedPackage(Long id, byte isEnabled) {
		ActRedPackage record = new ActRedPackage();
		record.setId(id);
		record.setIsEnabled(isEnabled);
		this.actRedPackageDao.update(record);

	}

	public Integer random(int max, int min) {
		return (int) (min + Math.random() * (max - min + 1));
	}

	public BigDecimal random(BigDecimal max, BigDecimal min) {
		Integer r = random(min.multiply(BigDecimal.valueOf(100)).intValue(),
				max.multiply(BigDecimal.valueOf(100)).intValue());

		return BigDecimal.valueOf(r).divide(BigDecimal.valueOf(100));
	}

	/**
	 * 生成红包
	 * 
	 * @param min
	 * @param max
	 * @param fixType
	 * @param totalMoney
	 * @param totalNum
	 * @param errMsg
	 * @return
	 */
	public List<BigDecimal> generateRedPackage(BigDecimal min, BigDecimal max, EmFixType fixType,
			BigDecimal totalMoney, Long totalNum, StringBuilder errMsg) {

		List<BigDecimal> list = new ArrayList<BigDecimal>();

		// 红包固定，仅返回一个
		if (fixType == EmFixType.Fixed) {
			for (int i = 0; i < totalNum; i++) {
				list.add(min);
			}
			return list;
		}
		// 随机产生红包

		// 红包 红包平均金额 = 发行金额 /发行量
		BigDecimal avgMoney = totalMoney.divide(BigDecimal.valueOf(totalNum));
		BigDecimal avgMoneyDouble = avgMoney.multiply(BigDecimal.valueOf(2));

		BigDecimal minAbs = min.subtract(avgMoney).abs();
		BigDecimal maxAbs = max.subtract(avgMoney).abs();
		if (minAbs.compareTo(maxAbs) > 0) {
			min = avgMoney.subtract(maxAbs);
			max = avgMoney.add(maxAbs);
		} else {
			min = avgMoney.subtract(minAbs);
			max = avgMoney.add(minAbs);
		}

		if (avgMoney.compareTo(min) <= 0 || avgMoney.compareTo(max) >= 0) {
			errMsg.append("红包面额范围设置必须包含红包平均金额（发行金额 /发行量）！");
		} else if (max.compareTo(avgMoneyDouble) >= 0) {
			errMsg.append("红包面额最大值不能大于红包平均金额（发行金额 /发行量）的两倍！");
		} else if (totalNum < 1) {
			errMsg.append("红包发行量必须大于0！");
		} else {
			BigDecimal hasOpenMoney = BigDecimal.ZERO;

			while (totalNum > 0) {
				if (totalNum == 1) {
					list.add(totalMoney.subtract(hasOpenMoney));
					totalNum -= 1;
				} else {
					BigDecimal i = random(min, max);
					list.add(i);
					list.add(avgMoneyDouble.subtract(i));
					hasOpenMoney = hasOpenMoney.add(avgMoneyDouble);
					totalNum -= 2;
				}
			}
			return list;
		}

		return list;
	}

	// 获取有效的红包信息
	public List<ActRedPackageBO> getActRedPackageBO() {
		return actRedPackageDao.getActRedPackageBO();

	}

	// 用户领取红包（更新红包记录表信息）
	public int getActRedPacketRecord(RedPackageGetRecordVO vo) {
		return redPackageGetRecordDao.updateActRedPacketRecord(vo);
	}

	// 领取红包--更新红包记录表
	public int updateByCookieIdandPacketId(RedPackageGetRecord vo) {
		return redPackageGetRecordDao.updateByCookieIdandPacketId(vo);

	}

	// 根据phone,红包id 查询红包记录信息
	public RedPackageGetRecordBO findRedPackageByPhone(String phone, Long packageId) {
		return redPackageGetRecordDao.findRedPackageByPhone(phone, packageId);
	}

	// 查询已经存入云豆的用户列表
	public List<RedPackageGetRecordBO> getActRedPacketRecordUserList(RedPackageGetRecordVO vo) {
		return redPackageGetRecordDao.getActRedPacketRecordUserList(vo);
	}

	// 更新红包表（已领取数）
	public void updateActRedPackageRecordById(Long packageId) {
		actRedPackageDao.updateActRedPackageRecordById(packageId);

	}

	public List<RedPackageGetRecordBO> findAllByPage(RedPackageGetRecordVO vo,
			MyPage<RedPackageGetRecordBO> page) {
		return this.redPackageGetRecordDao.findAllByPage(vo, page);
	}

	public RedPackageGetRecordBO findRedPackageGetRecordById(Long id) {
		return this.redPackageGetRecordDao.findOne(id);
	}

	public ActRedPackageBO findOneByVcode(String vcode) {
		return this.actRedPackageDao.findOneByVcode(vcode);
	}

}
