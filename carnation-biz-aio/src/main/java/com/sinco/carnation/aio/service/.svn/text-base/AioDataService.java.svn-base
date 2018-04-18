package com.sinco.carnation.aio.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.biz.common.service.ServiceException;
import com.sinco.carnation.aio.bo.AioDataBO;
import com.sinco.carnation.aio.bo.CholBO;
import com.sinco.carnation.aio.bo.EcgBO;
import com.sinco.carnation.aio.bo.GluBO;
import com.sinco.carnation.aio.bo.SpoBO;
import com.sinco.carnation.aio.bo.SysDiaBO;
import com.sinco.carnation.aio.bo.TpBO;
import com.sinco.carnation.aio.bo.UaBO;
import com.sinco.carnation.aio.dao.AioDataDao;
import com.sinco.carnation.aio.model.AioUserLog;
import com.sinco.carnation.aio.model.Chol;
import com.sinco.carnation.aio.model.Ecg;
import com.sinco.carnation.aio.model.Glu;
import com.sinco.carnation.aio.model.Spo;
import com.sinco.carnation.aio.model.SysDia;
import com.sinco.carnation.aio.model.Tp;
import com.sinco.carnation.aio.model.Ua;
import com.sinco.carnation.aio.vo.AioDataVO;
import com.sinco.dal.common.MyPage;

@Service
@Transactional(rollbackFor = {ServiceException.class})
public class AioDataService {
	@Autowired
	private AioDataDao aioDataDao;

	public List<Chol> getCholList(MyPage<Chol> page, String idCard, Date startDate, Date endDate) {
		// 根据身份证号码获取胆固醇列表
		List<Chol> result = aioDataDao.getCholList(page, idCard, startDate, endDate);
		return result;
	}

	public List<Ecg> getEcgList(MyPage<Ecg> page, String idCard, Date startDate, Date endDate) {
		// 根据身份证号码获取心率列表
		List<Ecg> result = aioDataDao.getEcgList(page, idCard, startDate, endDate);
		return result;
	}

	public List<Glu> getGluList(MyPage<Glu> page, String idCard, Date startDate, Date endDate) {
		// 根据身份证号码获取血糖列表
		List<Glu> result = aioDataDao.getGluList(page, idCard, startDate, endDate);
		return result;
	}

	public List<Spo> getSpoList(MyPage<Spo> page, String idCard, Date startDate, Date endDate) {
		// 根据身份证号码获取血氧列表
		List<Spo> result = aioDataDao.getSpoList(page, idCard, startDate, endDate);
		return result;
	}

	public List<SysDia> getSysDiaList(MyPage<SysDia> page, String idCard, Date startDate, Date endDate) {
		// 根据身份证号码获取血压列表
		List<SysDia> result = aioDataDao.getSysDiaList(page, idCard, startDate, endDate);
		return result;
	}

	public List<Tp> getTpList(MyPage<Tp> page, String idCard, Date startDate, Date endDate) {
		// 根据身份证号码获取体温列表
		List<Tp> result = aioDataDao.getTpList(page, idCard, startDate, endDate);
		return result;
	}

	public List<Ua> getUaList(MyPage<Ua> page, String idCard, Date startDate, Date endDate) {
		// 根据身份证号码获取尿酸列表
		List<Ua> result = aioDataDao.getUaList(page, idCard, startDate, endDate);
		return result;
	}

	public AioUserLog getLatestDataByUserLog(String idCard) {
		// 获取一体机最后一条数据
		return aioDataDao.getLatestDataByUserLog(idCard);
	}

	public List<AioDataBO> getAioDataList(MyPage<AioDataBO> page, AioDataVO aioDataVO) {
		// 获取一体机健康数据列表
		return aioDataDao.getAioDataList(page, aioDataVO);
	}

	public List<Chol> getCholList(MyPage<Chol> page, String idCard, Date time) {
		// 根据身份证号码获取胆固醇列表
		List<Chol> result = aioDataDao.getCholList(page, idCard, time);
		return result;
	}

	public List<Ecg> getEcgList(MyPage<Ecg> page, String idCard, Date time) {
		// 根据身份证号码获取心率列表
		List<Ecg> result = aioDataDao.getEcgList(page, idCard, time);
		return result;
	}

	public List<Glu> getGluList(MyPage<Glu> page, String idCard, Date time) {
		// 根据身份证号码获取血糖列表
		List<Glu> result = aioDataDao.getGluList(page, idCard, time);
		return result;
	}

	public List<Spo> getSpoList(MyPage<Spo> page, String idCard, Date time) {
		// 根据身份证号码获取血氧列表
		List<Spo> result = aioDataDao.getSpoList(page, idCard, time);
		return result;
	}

	public List<SysDia> getSysDiaList(MyPage<SysDia> page, String idCard, Date time) {
		// 根据身份证号码获取血压列表
		List<SysDia> result = aioDataDao.getSysDiaList(page, idCard, time);
		return result;
	}

	public List<Tp> getTpList(MyPage<Tp> page, String idCard, Date time) {
		// 根据身份证号码获取体温列表
		List<Tp> result = aioDataDao.getTpList(page, idCard, time);
		return result;
	}

	public List<Ua> getUaList(MyPage<Ua> page, String idCard, Date time) {
		// 根据身份证号码获取尿酸列表
		List<Ua> result = aioDataDao.getUaList(page, idCard, time);
		return result;
	}

	public List<TpBO> getTpListToPc(MyPage<TpBO> page, AioDataVO aioDataVO) {
		// 获取日志对应的体温数据
		return aioDataDao.getTpListToPc(page, aioDataVO);
	}

	public List<SpoBO> getSpoListToPc(MyPage<SpoBO> page, AioDataVO aioDataVO) {
		// 获取日志对应的血氧数据
		return aioDataDao.getSpoListToPc(page, aioDataVO);
	}

	public List<CholBO> getCholListToPc(MyPage<CholBO> page, AioDataVO aioDataVO) {
		// 获取日志对应的总胆固醇数据
		return aioDataDao.getCholListToPc(page, aioDataVO);
	}

	public List<EcgBO> getEcgListToPc(MyPage<EcgBO> page, AioDataVO aioDataVO) {
		// 获取日志对应的心电图数据
		return aioDataDao.getEcgListToPc(page, aioDataVO);
	}

	public List<GluBO> getGluListToPc(MyPage<GluBO> page, AioDataVO aioDataVO) {
		// 获取日志对应的血糖数据
		return aioDataDao.getGluListToPc(page, aioDataVO);
	}

	public List<SysDiaBO> getSysDiaListToPc(MyPage<SysDiaBO> page, AioDataVO aioDataVO) {
		// 获取日志对应的血压数据
		return aioDataDao.getSysDiaListToPc(page, aioDataVO);
	}

	public List<UaBO> getUaListToPc(MyPage<UaBO> page, AioDataVO aioDataVO) {
		// 获取日志对应的尿酸数据
		return aioDataDao.getUaListToPc(page, aioDataVO);
	}

}
