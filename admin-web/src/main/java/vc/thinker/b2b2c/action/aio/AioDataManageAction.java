package vc.thinker.b2b2c.action.aio;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.mo.aio.AioDataMO;
import vc.thinker.b2b2c.util.AnalysisCodeUtil;
import vc.thinker.b2b2c.util.IdcardValidator;

import com.sinco.carnation.aio.bo.CholBO;
import com.sinco.carnation.aio.bo.EcgBO;
import com.sinco.carnation.aio.bo.GluBO;
import com.sinco.carnation.aio.bo.SpoBO;
import com.sinco.carnation.aio.bo.SysDiaBO;
import com.sinco.carnation.aio.bo.TpBO;
import com.sinco.carnation.aio.bo.UaBO;
import com.sinco.carnation.aio.constants.AioDataConstants;
import com.sinco.carnation.aio.service.AioBindingService;
import com.sinco.carnation.aio.service.AioDataService;
import com.sinco.carnation.aio.vo.AioDataVO;
import com.sinco.carnation.sys.contants.UserContant;
import com.sinco.carnation.sys.model.UserAccount;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.UserAccountService;
import com.sinco.dal.common.MyPage;

/**
 * 一体机健康数据管理
 * 
 * @author yuanmin.feng
 */
@Controller
public class AioDataManageAction {

	@Autowired
	private AioDataService aioDataService;

	@Autowired
	private AioBindingService aioBindingService;

	@Autowired
	private SysConfigService configService;

	@Autowired
	private UserAccountService accountService;

	@Autowired
	private Mapper mapper;

	/**
	 * 获取健康一体机数据
	 * 
	 * @param request
	 * @return
	 */
	@SecurityMapping(title = "一体机健康数据列表", value = "/admin/aio_data_list.htm*", rtype = "admin", rname = "一体机健康数据管理", rcode = "check_admin", rgroup = "内容管理")
	@RequestMapping(value = "/admin/aio_data_list.htm")
	public ModelAndView getAioDataList(HttpServletRequest request, HttpServletResponse response,
			AioDataVO aioDataVO) {

		ModelAndView mv = new JModelAndView("admin/blue/aio/data_list.html", configService.getSysConfig(), 0,
				request, response);
		// 返回值
		List<AioDataMO> aioDatas = new ArrayList<AioDataMO>();

		// 根据UID获取手机号
		String uid = aioDataVO.getUid();
		if (CommUtil.isNotNull(uid)) {
			UserAccount userAccount = accountService.findUserAccount(CommUtil.null2Long(uid),
					UserContant.ACCOUNT_TYPE_2);
			aioDataVO.setMobile(null != userAccount ? userAccount.getLoginName() : null);
		}

		// 获取项目类型
		String subject = null != aioDataVO.getSubject() ? aioDataVO.getSubject()
				: AioDataConstants.AIO_DATA_TYPE_ECG;
		aioDataVO.setSubject(subject);
		switch (subject) {
			case AioDataConstants.AIO_DATA_TYPE_CHOL:
				// 获取总胆固醇列表数据
				cholDataList(aioDataVO, mv, aioDatas);
				break;
			case AioDataConstants.AIO_DATA_TYPE_TP:
				// 获取体温列表数据
				tpDataList(aioDataVO, mv, aioDatas);
				break;
			case AioDataConstants.AIO_DATA_TYPE_SPO:
				// 获取血氧列表数据
				spoDataList(aioDataVO, mv, aioDatas);
				break;
			case AioDataConstants.AIO_DATA_TYPE_ECG:
				// 获取心电图列表数据
				ecgDataList(aioDataVO, mv, aioDatas);
				break;
			case AioDataConstants.AIO_DATA_TYPE_GLU:
				// 获取血糖列表数据
				gluDataList(aioDataVO, mv, aioDatas);
				break;
			case AioDataConstants.AIO_DATA_TYPE_SYS_DIA:
				// 获取血压列表数据
				sysDiaDataList(aioDataVO, mv, aioDatas);
				break;
			case AioDataConstants.AIO_DATA_TYPE_UA:
				// 获取尿酸列表数据
				uaDataList(aioDataVO, mv, aioDatas);
				break;
		}
		mv.addObject("aioDataList", aioDatas);
		mv.addObject("vo", aioDataVO);
		return mv;
	}

	private void uaDataList(AioDataVO aioDataVO, ModelAndView mv, List<AioDataMO> aioDatas) {
		// 分页信息
		MyPage<UaBO> page = new MyPage<UaBO>();
		page.setPageNumber(aioDataVO.getCurrentPage());
		page.setPageSize(aioDataVO.getPageSize());
		// 获取尿酸列表数据
		aioDataService.getUaListToPc(page, aioDataVO);
		for (UaBO uaBO : page.getContent()) {
			AioDataMO aioDataMO = new AioDataMO();
			// 根据身份证号获取年龄
			int age = IdcardValidator.IdNOToAge(uaBO.getIdCard());
			aioDataMO.setAge(age);
			StringBuffer sb = new StringBuffer();
			String resultMessage = sb.append(uaBO.getUa()).append("mmol/L").toString();
			aioDataMO.setResultMessage(resultMessage);
			aioDataMO.setId(uaBO.getId());
			aioDataMO.setIdCard(uaBO.getIdCard());
			aioDataMO.setMobile(uaBO.getMobile());
			aioDataMO.setTime(uaBO.getTime());
			aioDataMO.setSubject("尿酸");
			aioDatas.add(aioDataMO);
		}
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
	}

	private void sysDiaDataList(AioDataVO aioDataVO, ModelAndView mv, List<AioDataMO> aioDatas) {
		// 分页信息
		MyPage<SysDiaBO> page = new MyPage<SysDiaBO>();
		page.setPageNumber(aioDataVO.getCurrentPage());
		page.setPageSize(aioDataVO.getPageSize());
		// 获取血压列表数据
		aioDataService.getSysDiaListToPc(page, aioDataVO);
		for (SysDiaBO sysDiaBO : page.getContent()) {
			AioDataMO aioDataMO = new AioDataMO();
			// 根据身份证号获取年龄
			int age = IdcardValidator.IdNOToAge(sysDiaBO.getIdCard());
			aioDataMO.setAge(age);
			StringBuffer sb = new StringBuffer();
			String resultMessage = sb.append("血压：").append(sysDiaBO.getSysDia()).append("mmHg")
					.append("        脉率：").append(sysDiaBO.getPr()).append("次/分").toString();
			aioDataMO.setResultMessage(resultMessage);
			aioDataMO.setId(sysDiaBO.getId());
			aioDataMO.setIdCard(sysDiaBO.getIdCard());
			aioDataMO.setMobile(sysDiaBO.getMobile());
			aioDataMO.setTime(sysDiaBO.getTime());
			aioDataMO.setSubject("血压");
			aioDatas.add(aioDataMO);
		}
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
	}

	private void gluDataList(AioDataVO aioDataVO, ModelAndView mv, List<AioDataMO> aioDatas) {
		// 分页信息
		MyPage<GluBO> page = new MyPage<GluBO>();
		page.setPageNumber(aioDataVO.getCurrentPage());
		page.setPageSize(aioDataVO.getPageSize());
		// 获取血糖列表数据
		aioDataService.getGluListToPc(page, aioDataVO);
		for (GluBO gluBO : page.getContent()) {
			AioDataMO aioDataMO = new AioDataMO();
			// 根据身份证号获取年龄
			int age = IdcardValidator.IdNOToAge(gluBO.getIdCard());
			aioDataMO.setAge(age);
			StringBuffer sb = new StringBuffer();
			String resultMessage = sb.append(gluBO.getGlu()).append("mmol/L(")
					.append(getFlagMessage(gluBO.getFlag())).append(")").toString();
			aioDataMO.setResultMessage(resultMessage);
			aioDataMO.setId(gluBO.getId());
			aioDataMO.setIdCard(gluBO.getIdCard());
			aioDataMO.setMobile(gluBO.getMobile());
			aioDataMO.setTime(gluBO.getTime());
			aioDataMO.setSubject("血糖");
			aioDatas.add(aioDataMO);
		}
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
	}

	private void ecgDataList(AioDataVO aioDataVO, ModelAndView mv, List<AioDataMO> aioDatas) {
		// 分页信息
		MyPage<EcgBO> page = new MyPage<EcgBO>();
		page.setPageNumber(aioDataVO.getCurrentPage());
		page.setPageSize(aioDataVO.getPageSize());
		// 获取心电图列表数据
		aioDataService.getEcgListToPc(page, aioDataVO);
		for (EcgBO ecgBO : page.getContent()) {
			AioDataMO aioDataMO = new AioDataMO();
			// 根据身份证号获取年龄
			int age = IdcardValidator.IdNOToAge(ecgBO.getIdCard());
			aioDataMO.setAge(age);
			StringBuffer sb = new StringBuffer();
			String resultMessage = sb.append("RR间期=").append(ecgBO.getRr()).append(" ms;").append("P-R值=")
					.append(ecgBO.getpR()).append(" ms;").append("QRS=").append(ecgBO.getQrs())
					.append(" ms;").append("QT = ").append(ecgBO.getQt()).append(" ms;").append("QTC=")
					.append(ecgBO.getQtc()).append(" ms;").append("p轴=").append(ecgBO.getpAxis())
					.append("°;").append("QRS轴=").append(ecgBO.getQrsAxis()).append("°;").append("T轴=")
					.append(ecgBO.gettAxis()).append("°;").append("RV5=").append(ecgBO.getRv5())
					.append(" μV;").append("SV1=").append(ecgBO.getSvl()).append(" μV;").append("RV5+SV1=")
					.append(ecgBO.gettAxis()).append(" μV;").append("HR=").append(ecgBO.gettAxis())
					.append("次").append("<br/>").append("结论：")
					.append(AnalysisCodeUtil.analysisMessage(ecgBO.getAnalysisCode())).toString();
			aioDataMO.setResultMessage(resultMessage);
			aioDataMO.setId(ecgBO.getId());
			aioDataMO.setIdCard(ecgBO.getIdCard());
			aioDataMO.setMobile(ecgBO.getMobile());
			aioDataMO.setTime(ecgBO.getTime());
			aioDataMO.setSubject("心电图");
			aioDatas.add(aioDataMO);
		}
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
	}

	private void cholDataList(AioDataVO aioDataVO, ModelAndView mv, List<AioDataMO> aioDatas) {
		// 分页信息
		MyPage<CholBO> page = new MyPage<CholBO>();
		page.setPageNumber(aioDataVO.getCurrentPage());
		page.setPageSize(aioDataVO.getPageSize());
		// 获取总胆固醇列表数据
		aioDataService.getCholListToPc(page, aioDataVO);
		for (CholBO cholBO : page.getContent()) {
			AioDataMO aioDataMO = new AioDataMO();
			// 根据身份证号获取年龄
			int age = IdcardValidator.IdNOToAge(cholBO.getIdCard());
			aioDataMO.setAge(age);
			StringBuffer sb = new StringBuffer();
			String resultMessage = sb.append(cholBO.getChol()).append("mmol/L").toString();
			aioDataMO.setResultMessage(resultMessage);
			aioDataMO.setId(cholBO.getId());
			aioDataMO.setIdCard(cholBO.getIdCard());
			aioDataMO.setMobile(cholBO.getMobile());
			aioDataMO.setTime(cholBO.getTime());
			aioDataMO.setSubject("总胆固醇");
			aioDatas.add(aioDataMO);
		}
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
	}

	private void spoDataList(AioDataVO aioDataVO, ModelAndView mv, List<AioDataMO> aioDatas) {
		// 分页信息
		MyPage<SpoBO> page = new MyPage<SpoBO>();
		page.setPageNumber(aioDataVO.getCurrentPage());
		page.setPageSize(aioDataVO.getPageSize());
		// 获取血氧列表数据
		aioDataService.getSpoListToPc(page, aioDataVO);
		for (SpoBO spoBO : page.getContent()) {
			AioDataMO aioDataMO = new AioDataMO();
			// 根据身份证号获取年龄
			int age = IdcardValidator.IdNOToAge(spoBO.getIdCard());
			aioDataMO.setAge(age);
			StringBuffer sb = new StringBuffer();
			String resultMessage = sb.append("血氧饱和度：").append(spoBO.getSpo()).append("%    ")
					.append("      脉率：").append(spoBO.getPr()).append("次/分").toString();
			aioDataMO.setResultMessage(resultMessage);
			aioDataMO.setId(spoBO.getId());
			aioDataMO.setIdCard(spoBO.getIdCard());
			aioDataMO.setMobile(spoBO.getMobile());
			aioDataMO.setTime(spoBO.getTime());
			aioDataMO.setSubject("血氧");
			aioDatas.add(aioDataMO);
		}
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
	}

	private void tpDataList(AioDataVO aioDataVO, ModelAndView mv, List<AioDataMO> aioDatas) {
		// 分页信息
		MyPage<TpBO> page = new MyPage<TpBO>();
		page.setPageNumber(aioDataVO.getCurrentPage());
		page.setPageSize(aioDataVO.getPageSize());
		// 获取体温列表数据
		aioDataService.getTpListToPc(page, aioDataVO);
		List<TpBO> tps = page.getContent();
		for (TpBO tpBO : tps) {
			AioDataMO aioDataMO = new AioDataMO();
			// 根据身份证号获取年龄
			int age = IdcardValidator.IdNOToAge(tpBO.getIdCard());
			aioDataMO.setAge(age);
			String resultMessage = tpBO.getTp() + "℃ ";
			aioDataMO.setResultMessage(resultMessage);
			aioDataMO.setId(tpBO.getId());
			aioDataMO.setIdCard(tpBO.getIdCard());
			aioDataMO.setMobile(tpBO.getMobile());
			aioDataMO.setTime(tpBO.getTime());
			aioDataMO.setSubject("体温");
			aioDatas.add(aioDataMO);
		}
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
	}

	private String getFlagMessage(String flag) {
		String flagMessage;
		if ("0".equals(flag)) {
			flagMessage = "餐后2小时";
		} else if ("1".equals(flag)) {
			flagMessage = "空腹";
		} else {
			flagMessage = "随机";
		}
		return flagMessage;
	}
}
