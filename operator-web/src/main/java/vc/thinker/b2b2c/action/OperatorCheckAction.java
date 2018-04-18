package vc.thinker.b2b2c.action;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.security.support.OperatorUserDetails;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.store.bo.StoreApplyInfoBO;
import com.sinco.carnation.store.bo.StoreBO;
import com.sinco.carnation.store.constants.StoreConstants;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.sys.bo.orcl.CnUserLevelBO;
import com.sinco.carnation.sys.contants.OrclUserContants;
import com.sinco.carnation.sys.contants.UserContant;
import com.sinco.carnation.user.UserContants;
import com.sinco.carnation.user.bo.OperatorBO;
import com.sinco.carnation.user.bo.UserOwnsBO;
import com.sinco.carnation.user.service.OperatorService;
import com.sinco.carnation.user.service.OrclUserBaseService;
import com.sinco.carnation.user.service.UserOwnService;
import com.sinco.dal.common.MyPage;

/**
 * 
 * @ClassName: OperatorCheckAction
 * @Description: TODO(运营商审核列表)
 * @author Tang
 * @date 2015年9月11日 下午8:45:47
 * 
 */
@Controller
public class OperatorCheckAction {
	@Autowired
	private StoreService storeService;

	@Autowired
	private OperatorService operatorService;

	@Autowired
	private OrclUserBaseService orclUserBaseService;

	@Autowired
	private UserOwnService userOwnService;

	@SecurityMapping(title = "运营商户审核列表", value = "/operator/operator_check_shop_list.htm*", rtype = "operator", rname = "运营商商户审核列表", rcode = "operator_check_shop_list", rgroup = "运营商管理")
	@RequestMapping("/operator/operator_check_shop_list.htm")
	public String operatorCheckShopList(Model model, MyPage<StoreBO> page, String storeName) {
		OperatorUserDetails detail = (OperatorUserDetails) SecurityUserHolder.getCurrentUserDetails();
		storeService.selectCheckListByOperatorId(page, detail.getOperatorBO().getId(), storeName, detail
				.getOperatorBO().getLevel());
		CommUtil.saveIPageList2Model("", "", "", page, model);
		model.addAttribute("storeName", storeName);
		return "operator_check_shop_list.html";
	}

	@SecurityMapping(title = "运营商查看商户详情", value = "/operator/check_store_detail.htm*", rtype = "operator", rname = "运营商查看商户详情", rcode = "check_store_detail", rgroup = "运营商管理")
	@RequestMapping("/operator/check_store_detail.htm")
	public String checkStoreDetail(Model model, Long storeId) {
		StoreBO store = storeService.getObjById(storeId);
		if (store != null && store.getStoreStatus() == StoreConstants.STORE_STATUS_SHOP_OPREATE_AUDIT) {
			model.addAttribute("store", store);
			StoreApplyInfoBO applyInfo = storeService.findStoreApplyInfoById(store.getId());
			model.addAttribute("applyInfo", applyInfo);
		} else {
			model.addAttribute("op_title", "参数错误！");
			return "tips.html";
		}
		return "check_store_detail.html";
	}

	@SecurityMapping(title = "运营商审核商户", value = "/operator/check_store_form.htm*", rtype = "operator", rname = "运营商审核商户", rcode = "check_store_form", rgroup = "运营商管理")
	@RequestMapping("/operator/check_store_form.htm")
	public String checkStoreForm(Model model, Long storeId) {
		StoreBO store = storeService.getObjById(storeId);
		model.addAttribute("store", store);

		model.addAttribute("storeId", storeId);
		return "check_store_form.html";
	}

	@SecurityMapping(title = "运营商审核商户保存", value = "/operator/check_store_save.htm*", rtype = "operator", rname = "运营商审核商户保存", rcode = "check_store_save", rgroup = "运营商管理")
	@RequestMapping("/operator/check_store_save.htm")
	public String checkStoreSave(Model model, Long storeId, String checkResult, String checkDescribe,
			String implementNumber, Integer posType, String lineNumber) {
		StoreBO store = storeService.getObjById(storeId);
		Integer ownType = 1;
		UserOwnsBO userOwnsBO = userOwnService.findOne(storeId,ownType);
		boolean f = true;
		if (userOwnsBO != null) {
			OperatorBO operatorBO = operatorService.findOne(userOwnsBO.getOwnOperatorId());
			if (operatorBO != null) {
				// 运营商为金卡，银卡级别的运营商不能推荐供应商
				if (UserContants.OPERATOR_LEVEL_SILVER.equals(operatorBO.getLevel())) {
					f = false;
					model.addAttribute("op_title", "隶属运营商级别为银卡，不能注册商户!");
				}
				if (operatorBO.getCn_username() != null
						&& operatorBO.getCn_username().startsWith(UserContant.ACCOUNT_TYPE_CN)) {
					CnUserLevelBO cn = orclUserBaseService.getOrclUserLevel(operatorBO.getCn_username());
					if (cn == null || null == cn.getUserType() || "" == cn.getUserType()) {
						f = false;
						model.addAttribute("op_title", "结算平台查询失败，请稍后再试，或联系管理员!");
					}
					if (cn != null && OrclUserContants.OPERATOR_LEVEL_SILVER.equals(cn.getUserType())) {
						f = false;
						model.addAttribute("op_title", "隶属运营商级别为银卡，不能注册商户!");
					}
				}
			}
		}

		if (f) {
			if ("0".equals(checkResult) && StringUtils.isEmpty(checkDescribe)) {
				model.addAttribute("op_title", "审核不通过必须填写原因！");
			} else if (store != null
					&& store.getIsEepay()
					&& "1".equals(checkResult)
					&& (StringUtils.isEmpty(implementNumber) || posType == null || StringUtils
							.isEmpty(lineNumber))) {
				model.addAttribute("op_title", "参数错误，请重新审核！");
			} else {

				if (store != null && store.getStoreStatus() == StoreConstants.STORE_STATUS_SHOP_OPREATE_AUDIT) {
					storeService.updateCheck(store, checkResult, checkDescribe, implementNumber, posType,
							lineNumber);
					model.addAttribute("op_title", "审核成功！");
					model.addAttribute("url", "/operator/operator_check_shop_list.htm");
				} else {
					model.addAttribute("op_title", "参数错误,审核失败！");
				}
			}
		}

		return "tips.html";
	}
}
