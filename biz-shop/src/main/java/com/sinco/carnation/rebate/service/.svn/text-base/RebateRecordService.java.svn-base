package com.sinco.carnation.rebate.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.user.bo.RebateRecordBO;
import com.sinco.carnation.user.dao.RebateRecordDao;
import com.sinco.carnation.user.model.RebateRecord;
import com.sinco.carnation.user.vo.RebateRecordVO;
import com.sinco.dal.common.MyPage;

@Service
public class RebateRecordService {
	private static Logger logger = LoggerFactory.getLogger(RebateRecordService.class);

	@Autowired
	private RebateRecordDao rebateRecordDao;

	public List<RebateRecordBO> selectOperatorRebateRecordList(Long operatorUserId, String status,
			RebateRecordVO vo, MyPage<RebateRecordBO> page) {
		return rebateRecordDao.selectOperatorRebateRecordList(operatorUserId, status, vo, page);
	}

	public List<RebateRecordBO> queryByUser(RebateRecordVO vo, MyPage<RebateRecordBO> page) {
		return rebateRecordDao.queryByUser(vo, page);
	}

	public void queryOperatorProfitList(Long uid, Boolean group, Boolean shop, MyPage<RebateRecordBO> page) {
		page.setContent(rebateRecordDao.queryOperatorProfitList(uid, group, shop, page));
	}

	public List<RebateRecordBO> selectOperatorRebateCode(RebateRecordVO vo, MyPage<RebateRecordBO> page) {
		return rebateRecordDao.selectOperatorRebateCode(vo, page);
	}

	public BigDecimal selectOperatorRebateRecordTotal(Long operatorUserId, String status) {
		return rebateRecordDao.selectOperatorRebateRecordTotal(operatorUserId, status);
	}

	public RebateRecord findOneRecordByCodeAndType(String code, String rebateType) {
		return rebateRecordDao.selectOneRecordByCodeAndType(code, rebateType);
	}

	public List<RebateRecord> findOneRecordeByCode(String code) {
		return rebateRecordDao.selectOneRecordeByCode(code);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public RebateRecord preSave(RebateRecord record) {
		RebateRecord rebateRecord = rebateRecordDao.selectOneRecordByCodeAndType(record.getRebateCode(),
				record.getRebateType());
		if (null != rebateRecord) {
			logger.warn("add rebate_record.is already add db, order_no=" + record.getRebateCode() + ",type="
					+ record.getRebateType());
			return record;
		}
		return rebateRecordDao.save(record);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public RebateRecord saveAlreadyRecord(RebateRecord record) {
		try {
			RebateRecord rebateRecord = rebateRecordDao.selectOneRecordByCodeAndType(record.getRebateCode(),
					record.getRebateType());
			if (null != rebateRecord) {
				logger.warn("modify rebate_record.is already add db, order_no=" + record.getRebateCode()
						+ ",type=" + record.getRebateType());
				boolean modifyResult = rebateRecordDao.updatePreRecordToAlready(rebateRecord.getId());
				if (modifyResult) {
					return rebateRecord;
				}
				logger.error("add or modify rebate_record  error. order_no=" + record.getRebateCode());
				throw new RuntimeException(
						"add or modify rebate_record  error. order_no=" + record.getRebateCode());
			}
			return rebateRecordDao.save(record);
		} catch (Exception e) {
			logger.error("add or modify rebate_record  error. order_no=" + record.getRebateCode());
			throw new RuntimeException();
		}
	}

	public List<RebateRecordBO> findAllByUidAndTime(Long uid, Date bgTime, Date edTime) {
		return rebateRecordDao.findAllByUidAndTime(uid, bgTime, edTime);
	}
}
