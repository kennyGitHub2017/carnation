package com.sinco.carnation.aio.dao;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinco.carnation.aio.bo.AioDataBO;
import com.sinco.carnation.aio.bo.CholBO;
import com.sinco.carnation.aio.bo.EcgBO;
import com.sinco.carnation.aio.bo.GluBO;
import com.sinco.carnation.aio.bo.SpoBO;
import com.sinco.carnation.aio.bo.SysDiaBO;
import com.sinco.carnation.aio.bo.TpBO;
import com.sinco.carnation.aio.bo.UaBO;
import com.sinco.carnation.aio.mapper.AioDataMapper;
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

@Repository
public class AioDataDao {

	@Autowired
	private AioDataMapper mapper;

	/**
	 * 根据身份证号获取胆固醇列表(时间段过滤)
	 * 
	 * @param idCard身份证号码
	 * @return
	 */
	public List<Chol> getCholList(MyPage<Chol> page, String idCard, Date startDate, Date endDate) {
		return mapper.queryCholToTimePeriod(page, idCard, startDate, endDate);
	}

	/**
	 * 根据身份证号获取心率列表(时间段过滤)
	 * 
	 * @param idCard身份证号码
	 * @return
	 */
	public List<Ecg> getEcgList(MyPage<Ecg> page, String idCard, Date startDate, Date endDate) {
		return mapper.queryEcgToTimePeriod(page, idCard, startDate, endDate);
	}

	/**
	 * 根据身份证号获取血糖列表(时间段过滤)
	 * 
	 * @param idCard身份证号码
	 * @return
	 */
	public List<Glu> getGluList(MyPage<Glu> page, String idCard, Date startDate, Date endDate) {
		return mapper.queryGluToTimePeriod(page, idCard, startDate, endDate);
	}

	/**
	 * 根据身份证号获取血氧列表(时间段过滤)
	 * 
	 * @param idCard身份证号码
	 * @return
	 */
	public List<Spo> getSpoList(MyPage<Spo> page, String idCard, Date startDate, Date endDate) {
		return mapper.querySpoToTimePeriod(page, idCard, startDate, endDate);
	}

	/**
	 * 根据身份证号获取血氧列表(时间段过滤)
	 * 
	 * @param idCard身份证号码
	 * @return
	 */
	public List<SysDia> getSysDiaList(MyPage<SysDia> page, String idCard, Date startDate, Date endDate) {
		return mapper.querySysDiaToTimePeriod(page, idCard, startDate, endDate);
	}

	/**
	 * 根据身份证号获取体温列表(时间段过滤)
	 * 
	 * @param idCard身份证号码
	 * @return
	 */
	public List<Tp> getTpList(MyPage<Tp> page, String idCard, Date startDate, Date endDate) {
		return mapper.queryTpToTimePeriod(page, idCard, startDate, endDate);
	}

	/**
	 * 根据身份证号获取尿酸列表(时间段过滤)
	 * 
	 * @param idCard身份证号码
	 * @return
	 */
	public List<Ua> getUaList(MyPage<Ua> page, String idCard, Date startDate, Date endDate) {
		return mapper.queryUaToTimePeriod(page, idCard, startDate, endDate);
	}

	/**
	 * 获取一体机最后一条数据
	 * 
	 * @param idCard身份证号码
	 * @return
	 */
	public AioUserLog getLatestDataByUserLog(String idCard) {
		return mapper.getLatestDataByUserLog(idCard);
	}

	/**
	 * 获取一体机健康数据列表
	 * 
	 * @param page
	 * @param aioDataVO
	 * @return
	 */
	public List<AioDataBO> getAioDataList(MyPage<AioDataBO> page, AioDataVO aioDataVO) {
		return this.mapper.getAioDataList(page, aioDataVO);
	}

	/**
	 * 根据身份证号获取胆固醇列表
	 * 
	 * @param idCard身份证号码
	 * @return
	 */
	public List<Chol> getCholList(MyPage<Chol> page, String idCard, Date time) {
		return mapper.queryChol(page, idCard, time);
	}

	/**
	 * 根据身份证号获取心率列表(时间段过滤)
	 * 
	 * @param idCard身份证号码
	 * @return
	 */
	public List<Ecg> getEcgList(MyPage<Ecg> page, String idCard, Date time) {
		return mapper.queryEcg(page, idCard, time);
	}

	/**
	 * 根据身份证号获取血糖列表(时间段过滤)
	 * 
	 * @param idCard身份证号码
	 * @return
	 */
	public List<Glu> getGluList(MyPage<Glu> page, String idCard, Date time) {
		return mapper.queryGlu(page, idCard, time);
	}

	/**
	 * 根据身份证号获取血氧列表(时间段过滤)
	 * 
	 * @param idCard身份证号码
	 * @return
	 */
	public List<Spo> getSpoList(MyPage<Spo> page, String idCard, Date time) {
		return mapper.querySpo(page, idCard, time);
	}

	/**
	 * 根据身份证号获取血氧列表(时间段过滤)
	 * 
	 * @param idCard身份证号码
	 * @return
	 */
	public List<SysDia> getSysDiaList(MyPage<SysDia> page, String idCard, Date time) {
		return mapper.querySysDia(page, idCard, time);
	}

	/**
	 * 根据身份证号获取体温列表(时间段过滤)
	 * 
	 * @param idCard身份证号码
	 * @return
	 */
	public List<Tp> getTpList(MyPage<Tp> page, String idCard, Date time) {
		return mapper.queryTp(page, idCard, time);
	}

	/**
	 * 根据身份证号获取尿酸列表(时间段过滤)
	 * 
	 * @param idCard身份证号码
	 * @return
	 */
	public List<Ua> getUaList(MyPage<Ua> page, String idCard, Date time) {
		return mapper.queryUa(page, idCard, time);
	}

	/**
	 * 后台体温数据列表
	 * 
	 * @param page
	 * @param aioDataVO
	 * @return
	 */
	public List<TpBO> getTpListToPc(MyPage<TpBO> page, AioDataVO aioDataVO) {
		return mapper.getTpListToPc(page, aioDataVO);
	}

	/**
	 * 后台血氧数据列表
	 * 
	 * @param page
	 * @param aioDataVO
	 * @return
	 */
	public List<SpoBO> getSpoListToPc(MyPage<SpoBO> page, AioDataVO aioDataVO) {
		return mapper.getSpoListToPc(page, aioDataVO);
	}

	/**
	 * 后台总胆固醇数据列表
	 * 
	 * @param page
	 * @param aioDataVO
	 * @return
	 */
	public List<CholBO> getCholListToPc(MyPage<CholBO> page, AioDataVO aioDataVO) {
		return mapper.getCholListToPc(page, aioDataVO);
	}

	/**
	 * 后台心电图数据列表
	 * 
	 * @param page
	 * @param aioDataVO
	 * @return
	 */
	public List<EcgBO> getEcgListToPc(MyPage<EcgBO> page, AioDataVO aioDataVO) {
		return mapper.getEcgListToPc(page, aioDataVO);
	}

	/**
	 * 后台血糖数据列表
	 * 
	 * @param page
	 * @param aioDataVO
	 * @return
	 */
	public List<GluBO> getGluListToPc(MyPage<GluBO> page, AioDataVO aioDataVO) {
		return mapper.getGluListToPc(page, aioDataVO);
	}

	/**
	 * 后台血压数据列表
	 * 
	 * @param page
	 * @param aioDataVO
	 * @return
	 */
	public List<SysDiaBO> getSysDiaListToPc(MyPage<SysDiaBO> page, AioDataVO aioDataVO) {
		return mapper.getSysDiaListToPc(page, aioDataVO);
	}

	/**
	 * 后台尿酸数据列表
	 * 
	 * @param page
	 * @param aioDataVO
	 * @return
	 */
	public List<UaBO> getUaListToPc(MyPage<UaBO> page, AioDataVO aioDataVO) {
		return mapper.getUaListToPc(page, aioDataVO);
	}
}
