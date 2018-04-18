package com.sinco.carnation.aio.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sinco.carnation.aio.bo.AioDataBO;
import com.sinco.carnation.aio.bo.CholBO;
import com.sinco.carnation.aio.bo.EcgBO;
import com.sinco.carnation.aio.bo.GluBO;
import com.sinco.carnation.aio.bo.SpoBO;
import com.sinco.carnation.aio.bo.SysDiaBO;
import com.sinco.carnation.aio.bo.TpBO;
import com.sinco.carnation.aio.bo.UaBO;
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

public interface AioDataMapper {

	List<Chol> queryCholToTimePeriod(MyPage<Chol> page, @Param("idCard") String idCard,
			@Param("startDate") Date startDate, @Param("endDate") Date endDate);

	List<Ecg> queryEcgToTimePeriod(MyPage<Ecg> page, @Param("idCard") String idCard,
			@Param("startDate") Date startDate, @Param("endDate") Date endDate);

	List<Glu> queryGluToTimePeriod(MyPage<Glu> page, @Param("idCard") String idCard,
			@Param("startDate") Date startDate, @Param("endDate") Date endDate);

	List<Spo> querySpoToTimePeriod(MyPage<Spo> page, @Param("idCard") String idCard,
			@Param("startDate") Date startDate, @Param("endDate") Date endDate);

	List<SysDia> querySysDiaToTimePeriod(MyPage<SysDia> page, @Param("idCard") String idCard,
			@Param("startDate") Date startDate, @Param("endDate") Date endDate);

	List<Tp> queryTpToTimePeriod(MyPage<Tp> page, @Param("idCard") String idCard,
			@Param("startDate") Date startDate, @Param("endDate") Date endDate);

	List<Ua> queryUaToTimePeriod(MyPage<Ua> page, @Param("idCard") String idCard,
			@Param("startDate") Date startDate, @Param("endDate") Date endDate);

	AioUserLog getLatestDataByUserLog(String idCard);

	List<AioDataBO> getAioDataList(MyPage<AioDataBO> page, @Param("vo") AioDataVO vo);

	List<Chol> queryChol(MyPage<Chol> page, @Param("idCard") String idCard, @Param("time") Date time);

	List<Ecg> queryEcg(MyPage<Ecg> page, @Param("idCard") String idCard, @Param("time") Date time);

	List<Glu> queryGlu(MyPage<Glu> page, @Param("idCard") String idCard, @Param("time") Date time);

	List<Spo> querySpo(MyPage<Spo> page, @Param("idCard") String idCard, @Param("time") Date time);

	List<SysDia> querySysDia(MyPage<SysDia> page, @Param("idCard") String idCard, @Param("time") Date time);

	List<Tp> queryTp(MyPage<Tp> page, @Param("idCard") String idCard, @Param("time") Date time);

	List<Ua> queryUa(MyPage<Ua> page, @Param("idCard") String idCard, @Param("time") Date time);

	List<TpBO> getTpListToPc(MyPage<TpBO> page, @Param("vo") AioDataVO aioDataVO);

	List<SpoBO> getSpoListToPc(MyPage<SpoBO> page, @Param("vo") AioDataVO aioDataVO);

	List<CholBO> getCholListToPc(MyPage<CholBO> page, @Param("vo") AioDataVO aioDataVO);

	List<EcgBO> getEcgListToPc(MyPage<EcgBO> page, @Param("vo") AioDataVO aioDataVO);

	List<GluBO> getGluListToPc(MyPage<GluBO> page, @Param("vo") AioDataVO aioDataVO);

	List<SysDiaBO> getSysDiaListToPc(MyPage<SysDiaBO> page, @Param("vo") AioDataVO aioDataVO);

	List<UaBO> getUaListToPc(MyPage<UaBO> page, @Param("vo") AioDataVO aioDataVO);

}