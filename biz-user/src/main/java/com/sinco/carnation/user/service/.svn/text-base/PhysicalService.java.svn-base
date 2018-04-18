package com.sinco.carnation.user.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.goods.dao.GoodsDao;
import com.sinco.carnation.goods.model.Goods;
import com.sinco.carnation.o2o.bo.GroupGoodsBO;
import com.sinco.carnation.o2o.dao.GroupGoodsDao;
import com.sinco.carnation.sns.dao.CircleInvitationDao;
import com.sinco.carnation.sns.model.CircleInvitation;
import com.sinco.carnation.sys.bo.SysKeyWordMapBO;
import com.sinco.carnation.sys.bo.SysReminderTaskBO;
import com.sinco.carnation.sys.bo.SysTaskLogBO;
import com.sinco.carnation.sys.dao.SysKeyWordMapDao;
import com.sinco.carnation.sys.dao.SysReminderTaskDao;
import com.sinco.carnation.sys.dao.SysTaskLogDao;
import com.sinco.carnation.sys.enums.EmSysKeyWordMapType;
import com.sinco.carnation.sys.model.SysKeyWordMap;
import com.sinco.carnation.sys.model.SysTaskLog;
import com.sinco.carnation.sys.service.IntegralService;
import com.sinco.carnation.sys.vo.SysKeyWordMapVO;
import com.sinco.carnation.sys.vo.SysTaskLogVO;
import com.sinco.carnation.user.bo.PhysicalKeyWordBO;
import com.sinco.carnation.user.bo.PhysicalKeyWordTypeBO;
import com.sinco.carnation.user.bo.PhysicalResultBO;
import com.sinco.carnation.user.bo.PhysicalSuggestBO;
import com.sinco.carnation.user.bo.PhysicalTypeBO;
import com.sinco.carnation.user.bo.PhysicalValuationBO;
import com.sinco.carnation.user.dao.PhysicalKeyWordDao;
import com.sinco.carnation.user.dao.PhysicalResultDao;
import com.sinco.carnation.user.dao.PhysicalSuggestDao;
import com.sinco.carnation.user.dao.PhysicalTypeDao;
import com.sinco.carnation.user.dao.PhysicalValuationDao;
import com.sinco.carnation.user.enums.EmPhysicalResultType;
import com.sinco.carnation.user.model.PhysicalKeyWord;
import com.sinco.carnation.user.model.PhysicalResult;
import com.sinco.carnation.user.vo.PhysicalKeyWordVO;
import com.sinco.carnation.user.vo.PhysicalResultVO;
import com.sinco.carnation.user.vo.PhysicalSuggestVO;
import com.sinco.carnation.user.vo.PhysicalValuationVO;
import com.sinco.dal.common.MyPage;

@Service
@Transactional(readOnly = true)
public class PhysicalService {

	private static final Logger logger = LoggerFactory.getLogger(PhysicalService.class);
	@Autowired
	private PhysicalResultDao physicalResultDao;
	@Autowired
	private PhysicalValuationDao physicalValuationDao;
	@Autowired
	private PhysicalTypeDao physicalTypeDao;
	@Autowired
	private PhysicalSuggestDao physicalSuggestDao;

	@Autowired
	private SysKeyWordMapDao sysKeyWordMapDao;
	@Autowired
	private CircleInvitationDao invitationDao;
	@Autowired
	private GoodsDao goodsDao;
	@Autowired
	private GroupGoodsDao groupGoodsDao;

	@Autowired
	private SysTaskLogDao sysTaskLogDao;

	@Autowired
	private PhysicalKeyWordDao physicalKeyWordDao;

	@Autowired
	private SysReminderTaskDao sysReminderTaskDao;

	@Autowired
	private IntegralService integralService;

	/**
	 * 保存体检数据
	 * 
	 * @param minValue
	 * @param maxValue
	 * @param type
	 * @param integer
	 */
	@Transactional(readOnly = false)
	public Long savePhysicalInfo(Float minValue, Float maxValue, Float middleValue, Integer type,
			String time, Long userId, Integer terminalType, Long valuationId) {
		PhysicalResult result = physicalResultDao.queryPhysicalResult(CommUtil.null2String(userId),
				CommUtil.null2String(type), time);

		if (null != result) {
			result.setRangeMax(maxValue);
			result.setRangeMin(minValue);
			result.setRangeMiddle(middleValue);
			result.setCreateBy(CommUtil.null2String(userId));
			result.setCreateTime(CommUtil.formatDate(time));
			result.setItemCode(String.valueOf(type));
			result.setTerminalType((byte) terminalType.intValue());
			if (valuationId > 0l) {
				result.setValuationId(valuationId);// 体检结果关联参考值id
			}
			PhysicalResult physical = physicalResultDao.save(result);
			return physical.getId();
		} else {
			PhysicalResult physical = new PhysicalResult();
			physical.setRangeMax(maxValue);
			physical.setRangeMin(minValue);
			physical.setRangeMiddle(middleValue);
			physical.setCreateBy(CommUtil.null2String(userId));
			physical.setCreateTime(new Date());
			physical.setItemCode(String.valueOf(type));
			physical.setTerminalType((byte) terminalType.intValue());
			if (valuationId > 0l) {
				physical.setValuationId(valuationId);// 体检结果关联参考值id
			}
			PhysicalResult physical2 = physicalResultDao.save(physical);
			return physical2.getId();
		}
	}

	public PhysicalResult queryPhysicalResult(Long uid, String code, String time) {
		return physicalResultDao.queryPhysicalResult(CommUtil.null2String(uid), code, time);
	}

	public List<PhysicalResultBO> queryPhysicalResultList(Long uid, String time) {
		return physicalResultDao.queryPhysicalResultList(CommUtil.null2String(uid), time);
	}

	/**
	 * 根据条件查找结果值（体检类型，性别，年龄，范围值）
	 * 
	 * @param minValue
	 * @param maxValue
	 * @param middleValue
	 * @param type
	 * @param sex
	 * @param age
	 * @return
	 */
	public PhysicalValuationBO queryPhysicalResultByCond(Float minValue, Float maxValue, Float middleValue,
			Integer type, int sex/*,int age*/) {

		// 对于特殊的体检类型（血压和听力）相应的判断
		// 根据类型id查询出参考值然后配对范围值
		PhysicalValuationBO minBO = new PhysicalValuationBO();
		PhysicalValuationBO maxBO = new PhysicalValuationBO();
		PhysicalValuationBO valBO = new PhysicalValuationBO();
		Integer maxResultType, minResultType;
		// 如何判断血压找出对应的测试结果值（1.高压和低压范围 2.脉压差范围20-60）
		Float plusePressVal = maxValue - minValue;
		PhysicalValuationVO vo1 = new PhysicalValuationVO();
		vo1.setPhysicalTypeId(type.longValue());
		// List<PhysicalValuationBO> phyValuationBOList = physicalValuationDao.findList(vo1,null);
		List<PhysicalValuationBO> phyValuationBOList = physicalValuationDao.selectCheckResultByVo(vo1, null);
		if (6 == type) {// 血压
			for (PhysicalValuationBO valuationBO : phyValuationBOList) {

				if (valuationBO.getRangeMin() <= maxValue && maxValue <= valuationBO.getRangeMax()
						&& valuationBO.getRangeMax2() <= minValue && minValue <= valuationBO.getRangeMax2()
						&& valuationBO.getRangeMin2() <= plusePressVal
						&& plusePressVal <= valuationBO.getRangeMax3()) {// 同时满足高压，低压，脉压差范围
					// 返回测试结果值
					valBO.setResultType(valuationBO.getResultType());
					valBO.setId(valuationBO.getId());
					valBO.setMemo(valuationBO.getMemo());
					valBO.setPhysicalTypeName(valuationBO.getPhysicalTypeName());
					valBO.setResultDesc(EmPhysicalResultType.getPhysicalResultDesc(valuationBO
							.getResultType()));
					return valBO;

				} else {
					if (valuationBO.getRangeMin() <= maxValue && maxValue <= valuationBO.getRangeMax()) {// 高压值
						maxResultType = valuationBO.getResultType();
						maxBO.setResultType(maxResultType);
						maxBO.setId(valuationBO.getId());
						maxBO.setMemo(valuationBO.getMemo());
						maxBO.setPhysicalTypeName(valuationBO.getPhysicalTypeName());
						maxBO.setResultDesc(EmPhysicalResultType.getPhysicalResultDesc(valuationBO
								.getResultType()));

					}
					if (valuationBO.getRangeMax2() <= minValue && minValue <= valuationBO.getRangeMax2()) {// 低压值
						minResultType = valuationBO.getResultType();
						minBO.setResultType(minResultType);
						minBO.setId(valuationBO.getId());
						minBO.setMemo(valuationBO.getMemo());
						minBO.setPhysicalTypeName(valuationBO.getPhysicalTypeName());
						minBO.setResultDesc(EmPhysicalResultType.getPhysicalResultDesc(valuationBO
								.getResultType()));
					}
				}
			}
			// 比较枚举类型大小
			if (maxBO != null && maxBO.getResultType() != null && minBO != null
					&& minBO.getResultType() != null && maxBO.getResultType() > minBO.getResultType()) {
				return maxBO;
			} else {
				return minBO;
			}
		}/*else if(type == 5){//听力
			
			}*/else {// 肺活量:性别
			PhysicalValuationVO vo = new PhysicalValuationVO();
			if (type == 8) {
				vo.setSex(sex);
			}
			vo.setRangeMin(minValue);
			vo.setRangeMax(maxValue);
			vo.setPhysicalTypeId(type.longValue());
			List<PhysicalValuationBO> list = physicalValuationDao.selectCheckResultByVo(vo, null);
			if (list != null && list.size() > 0) {
				PhysicalValuationBO phyValuationBO = list.get(0);
				phyValuationBO.setResultDesc(EmPhysicalResultType.getPhysicalResultDesc(phyValuationBO
						.getResultType()));
				return phyValuationBO;
			}
			return null;

		}

	}

	/**
	 * 查询体检数据
	 * 
	 * @param userId
	 *            用户id
	 * @param itemCode
	 *            体检项目 1视力表2视力检测3色盲测试4散光测试5听力6血压7心率8肺活量9血氧
	 * @param lmt
	 *            图表需要查询前7次 为空则查询所有
	 * @return
	 */
	public List<PhysicalResultBO> selectPhysicalResultList(Long userId, String itemCode, Integer lmt) {
		Integer itemCodeint = Integer.parseInt(itemCode);
		if (itemCode == null)
			return null;
		return physicalResultDao.selectPhysicalResultList(userId, itemCodeint, lmt);
	}

	public List<PhysicalResultBO> fullPhysicalResultList(Long userId, String itemCode, Integer lmt) {
		Integer itemCodeint = Integer.parseInt(itemCode);
		if (itemCode == null)
			return null;
		List<PhysicalResultBO> dataList = physicalResultDao
				.selectPhysicalResultList(userId, itemCodeint, lmt);
		List<PhysicalResultBO> newList = new ArrayList<PhysicalResultBO>();

		for (int i = 0; i < lmt; i++) {
			PhysicalResultBO resutlBO = new PhysicalResultBO();
			resutlBO.setRangeMax(0F);
			resutlBO.setRangeMin(0F);
			newList.add(resutlBO);
		}

		if (dataList != null && dataList.size() > 0) {

			int j = newList.size();
			for (int i = 0, l = dataList.size(); i < l; i++) {
				PhysicalResultBO dataBO = dataList.get(i);
				PhysicalResultBO newBO = newList.get(j - i - 1);
				if (dataBO != null && dataBO.getRangeMax() != null && dataBO.getRangeMax() > 0F) {
					newBO.setRangeMax(dataBO.getRangeMax());
					if (dataBO.getItemCode() != null && Integer.parseInt(dataBO.getItemCode()) == 6) {// 如果是血压类型（高压和低压）
						newBO.setRangeMin(dataBO.getRangeMin());
					}

				}
			}
		}

		return newList;
	}

	/** kenny 体检参数相关业务 **/

	public MyPage<PhysicalValuationBO> findPageByVO(PhysicalValuationVO vo, MyPage<PhysicalValuationBO> page) {
		List<PhysicalValuationBO> list = this.physicalValuationDao.findList(vo, page);
		page.setContent(list);
		return page;
	}

	public List<PhysicalValuationBO> findAll() {
		return this.physicalValuationDao.findList();
	}

	/**
	 * 修改/删除
	 * 
	 * @param record
	 * @return
	 */
	@Transactional(readOnly = false)
	public boolean editValuation(PhysicalValuationVO record) {
		try {
			this.physicalValuationDao.save(record);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 删除参考参数
	 * 
	 * @param id
	 * @return
	 */
	public boolean deleteValuationById(Long id) {
		try {
			this.physicalValuationDao.delete(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/***
	 * 查询所有体检项目
	 */

	public List<PhysicalTypeBO> findPhysicalTypeAll() {
		return physicalTypeDao.findAll();
	}

	/***
	 * 体检建议管理查询
	 */

	public MyPage<PhysicalSuggestBO> findPageByVo(PhysicalSuggestVO vo, MyPage<PhysicalSuggestBO> page) {
		List<PhysicalSuggestBO> list = this.physicalSuggestDao.selectByVo(vo, page);
		page.setContent(list);
		return page;

	}

	/**
	 * 体检建议添加
	 * 
	 * @param record
	 * @return
	 */
	@Transactional(readOnly = false)
	public boolean editPhysicalSuggest(PhysicalSuggestVO record) {
		try {
			this.physicalSuggestDao.insertSuggest(record);
			String[] StrArray = record.getKeyWordIdStr().split(",");
			SysKeyWordMap skm = new SysKeyWordMap();

			for (int i = 0; i < StrArray.length; i++) {
				skm.setKeyWordId(Long.parseLong(StrArray[i]));
				skm.setTypeCode(CommUtil.null2Long(EmSysKeyWordMapType.PhysicalSuugestType.getDesc()));
				skm.setTypeId(record.getId());
				this.sysKeyWordMapDao.insertKeyWordMap(skm);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Map<Integer, List<PhysicalSuggestBO>> queryPhysicalSuggestByCond(PhysicalSuggestVO suggestVO) {
		// 对每一条建议记录做分组排序
		List<PhysicalSuggestBO> list = physicalSuggestDao.queryPhysicalSuggestByCond(suggestVO);

		Map<Integer, List<PhysicalSuggestBO>> map = new HashMap<Integer, List<PhysicalSuggestBO>>();
		List<PhysicalSuggestBO> dietList = new ArrayList<PhysicalSuggestBO>();
		List<PhysicalSuggestBO> exeList = new ArrayList<PhysicalSuggestBO>();
		List<PhysicalSuggestBO> liftList = new ArrayList<PhysicalSuggestBO>();
		List<PhysicalSuggestBO> machList = new ArrayList<PhysicalSuggestBO>();
		List<PhysicalSuggestBO> othersList = new ArrayList<PhysicalSuggestBO>();

		// 建议关联任务id
		for (PhysicalSuggestBO suggestBO : list) {
			// 找到关联表ids
			Map<Integer, List<PhysicalSuggestBO>> suggestMap = new HashMap<Integer, List<PhysicalSuggestBO>>();
			List<PhysicalSuggestBO> suggestBOList = new ArrayList<PhysicalSuggestBO>();
			suggestBOList.add(suggestBO);
			suggestMap.put(0, suggestBOList);
			List<Long> taskIdsList = this.queryRecommendService(suggestMap,
					EmSysKeyWordMapType.PhysicalTaskType.getValue(),
					EmSysKeyWordMapType.PhysicalSuugestType.getValue());
			if (taskIdsList != null && taskIdsList.size() > 0) {
				suggestBO.setTaskId(taskIdsList.get(0));
			} else {
				suggestBO.setTaskId(0L);// 建议没有对应的taskid
			}

			if (suggestBO != null) {
				if (suggestBO.getSuggestType() == 1) {
					dietList.add(suggestBO);
				} else if (suggestBO.getSuggestType() == 2) {
					exeList.add(suggestBO);
				} else if (suggestBO.getSuggestType() == 3) {
					liftList.add(suggestBO);
				} else if (suggestBO.getSuggestType() == 4) {
					machList.add(suggestBO);
				} else if (suggestBO.getSuggestType() == 5) {
					othersList.add(suggestBO);
				}
			}
		}
		map.put(0, dietList);
		map.put(1, exeList);
		map.put(2, liftList);
		map.put(3, machList);
		map.put(4, othersList);

		return map;

	}

	/***
	 * 体检记录根据vo查询体检记录并分页
	 */
	public List<PhysicalResultBO> selectPhysicalResultByVO(PhysicalResultVO vo, MyPage<PhysicalResultBO> page) {
		return physicalResultDao.selectPhysicalResultByVO(vo, page);
	}

	/**
	 * 体检记录根据ID逻辑删除
	 */
	@Transactional(readOnly = false)
	public boolean updateResultByIdForIsDel(Integer id, boolean isdel) {
		if (physicalResultDao.updateByIdForIsDel(id, isdel) > 0)
			return true;
		else
			return false;
	}

	/*
	 * 精华推荐
	 */
	public List<Long> queryRecommendService(Map<Integer, List<PhysicalSuggestBO>> suggestMap, long typeCode,
			long suggestTypeCode) {

		// 找出建议的id数据
		List<Long> idsList = new ArrayList<Long>();
		List<Long> relationIds = new ArrayList<Long>();
		if (suggestMap != null) {

			for (List<PhysicalSuggestBO> list : suggestMap.values()) {
				// 遍历该list的值
				for (PhysicalSuggestBO bo : list) {
					if (bo != null) {
						idsList.add(bo.getId());
					}
				}

			}
			// 先查询出改建议对应的关键字
			// 根据建议对应的关键字id查找关联表的信息（帖子|商品|服务）
			List<SysKeyWordMapBO> keyList = new ArrayList<SysKeyWordMapBO>();
			if (idsList != null && idsList.size() > 0) {
				keyList = sysKeyWordMapDao.findListByCond4Recommed(idsList, typeCode, suggestTypeCode);
			}

			for (SysKeyWordMapBO keyBO : keyList) {
				if (keyBO != null) {
					relationIds.add(keyBO.getTypeId());
				}
			}

			return relationIds;

		}
		return relationIds;

	}

	public List<CircleInvitation> queryCircleBySuggest(Map<Integer, List<PhysicalSuggestBO>> suggestMap,
			long typeCode, long suggestTypeCode) {
		List<Long> relationIds = this.queryRecommendService(suggestMap, typeCode, suggestTypeCode);
		if (relationIds != null && !relationIds.isEmpty()) {
			return invitationDao.findAllByIds(relationIds);
		}
		return null;

		// 查询对应的关联表信息
		/*if(EmSysKeyWordMapType.SnsArticleType.getValue() == 3){//（帖子）
			
			return articleList;
		}else if(EmSysKeyWordMapType.GoodsType.getValue() == 4){//商品
			List<Goods> goodsList = goodsDao.findAllByIds(relationIds);
		}else if(EmSysKeyWordMapType.O2oServiceType.getValue() == 5){//服务
			
		}
		return relationIds;*/
	}

	public List<Goods> queryGoodsBySuggest(Map<Integer, List<PhysicalSuggestBO>> suggestMap, long typeCode,
			long suggestTypeCode) {
		List<Long> relationIds = this.queryRecommendService(suggestMap, typeCode, suggestTypeCode);
		if (relationIds != null && !relationIds.isEmpty()) {
			return goodsDao.findAllByIds(relationIds);
		}
		return null;

	}

	public List<GroupGoodsBO> queryO2oGoodsBySuggest(Map<Integer, List<PhysicalSuggestBO>> suggestMap,
			long typeCode, long suggestTypeCode) {
		List<Long> relationIds = this.queryRecommendService(suggestMap, typeCode, suggestTypeCode);
		if (relationIds != null && !relationIds.isEmpty()) {
			return groupGoodsDao.findAllByIds(relationIds);
		}
		return null;

	}

	/***
	 * 关键字查询机列表
	 */
	public MyPage<PhysicalKeyWordBO> findPageKeyWord(PhysicalKeyWordVO vo, MyPage<PhysicalKeyWordBO> page) {
		List<PhysicalKeyWordBO> list = this.physicalKeyWordDao.selectByVo(vo, page);
		page.setContent(list);
		return page;
	}

	/***
	 * 编辑关键字
	 * 
	 * @param vo
	 * @return
	 */
	@Transactional(readOnly = false)
	public boolean editKeyWord(PhysicalKeyWordVO vo) {
		try {
			this.physicalKeyWordDao.save(vo);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/***
	 * 所有体检关键字查询
	 * 
	 * @return
	 */
	public List<PhysicalKeyWordBO> findKeyWordAll() {
		return this.physicalKeyWordDao.selectAll();
	}

	/***
	 * 关键字类型列表
	 * 
	 * @return
	 */
	public List<PhysicalKeyWordTypeBO> selectKeyWordTypeList() {
		return this.physicalKeyWordDao.selectKeyWordTypeList();
	}

	/***
	 * 根据ID删除建议
	 * 
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = false)
	public boolean deleteSuggest(Long id) {
		try {
			this.physicalSuggestDao.delete(id);
			// TODO
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/***
	 * 根据ID删除关键字
	 * 
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = false)
	public boolean deleteKeyWord(Long id) {
		try {
			this.physicalKeyWordDao.delete(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 用户任务记录根据vo分页查询
	 */
	public List<SysTaskLogBO> selectByVO(SysTaskLogVO vo, MyPage<SysTaskLogBO> page) {
		return sysTaskLogDao.selectByVO(vo, page);
	}

	/**
	 * 用户任务记录逻辑删除
	 */
	@Transactional(readOnly = false)
	public boolean updateTaskLogByIdForIsDel(SysTaskLog record) {
		if (sysTaskLogDao.save(record) != null)
			return true;
		else
			return false;
	}

	/**
	 * 保存用户记任务录数据
	 */
	@Transactional(readOnly = false)
	public SysTaskLog saveUserTaskData(SysTaskLog record) {
		return this.sysTaskLogDao.save(record);
	}

	/**
	 * 根据ID查看一条体检建议
	 * 
	 * @param id
	 * @return
	 */
	public PhysicalSuggestBO getSuggestById(Long id) {
		return this.physicalSuggestDao.findOne(id);
	}

	public PhysicalTypeBO queryPhysicalTypeById(Long phySicalTypeId) {
		return physicalTypeDao.findOne(phySicalTypeId);
	}

	/**
	 * 根据关键字类型加载这个类型对应的所有关键字
	 * 
	 * @param type
	 *            关键字类型
	 * @return
	 */
	public List<PhysicalKeyWord> findKeyWordByType(Integer type) {
		return physicalKeyWordDao.findKeyWordByType(type);
	}

	/***
	 * 根据vo对象查询关键字
	 * 
	 * @param vo
	 * @return
	 */
	public List<PhysicalKeyWordBO> selectKeyWordByVo(PhysicalKeyWordVO vo) {
		return this.physicalKeyWordDao.selectByVo(vo, null);
	}

	/***
	 * 根据id查看一条体检参考值对象
	 * 
	 * @param id
	 * @return
	 */
	public PhysicalValuationBO getValuationById(Long id) {
		return this.physicalValuationDao.findOne(id);
	}

	/***
	 * 根据关键字关联表Id查询
	 * 
	 * @return
	 */
	public List<SysKeyWordMapBO> getKeyWordMapByVo(SysKeyWordMapVO vo) {
		return this.sysKeyWordMapDao.selectListByVo(vo);
	}

	/***
	 * 修改体检建议
	 * 
	 * @param vo
	 * @return
	 */
	@Transactional(readOnly = false)
	public boolean modifySuggest(PhysicalSuggestVO vo) {
		try {
			this.physicalSuggestDao.update(vo);
			// 删除关联表

			this.sysKeyWordMapDao.deleteByTypeIdAdTypeCode(vo.getId(),
					CommUtil.null2Long(EmSysKeyWordMapType.PhysicalSuugestType.getDesc()));

			String[] StrArray = vo.getKeyWordIdStr().trim().split(",");

			SysKeyWordMap skm = new SysKeyWordMap();
			for (int i = 0; i < StrArray.length; i++) {
				skm.setKeyWordId(Long.parseLong(StrArray[i].trim()));
				skm.setTypeCode(CommUtil.null2Long(EmSysKeyWordMapType.PhysicalSuugestType.getDesc()));
				skm.setTypeId(vo.getId());
				this.sysKeyWordMapDao.insertKeyWordMap(skm);
			}

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 根据taskId获取任务信息
	 */
	@Transactional(readOnly = true)
	public SysReminderTaskBO getPhysicalTaskInfoById(Long taskId) {
		return this.sysReminderTaskDao.findOne(taskId);
	}

	/**
	 * 根据ID查看查看六项体检最近七次记录
	 */
	public List<PhysicalResultBO> selectPhysicalResultByIdSix(Long userId) {
		return physicalResultDao.selectPhysicalResultByUserIdSix(userId);
	}

	/** 查询未加分记录 **/
	public List<PhysicalResultBO> listByisAddIntegral(){
		return physicalResultDao.listByisAddIntegral();
	}
	/** 更新加分状态 **/
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int updateIsAddIntegralByid(Long id){
		return physicalResultDao.updateIsAddIntegralByid(id);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void addIntegralByid (Long id ,Long uid , String type ,Date time){
		if(this.updateIsAddIntegralByid(id)>0){
			//加积分
			try {
				integralService.addIntegral(type, uid, null, null, null, null);
			} catch (Exception e) {
				logger.error("[addIntegralByid] error uid = "+uid + e);
				e.printStackTrace();
			}
		}
	}
}
