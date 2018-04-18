package com.sinco.carnation.resource.web.actions.shop;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import net.sf.json.JSONObject;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sinco.api.annotation.ApiMapping;
import com.sinco.api.annotation.MethodMapping;
import com.sinco.api.annotation.Param;
import com.sinco.api.util.ActionsUtil;
import com.sinco.api.util.MapperUtils;
import com.sinco.carnation.express.service.ExpressCompanyService;
import com.sinco.carnation.kuaidi100.pojo.ResultItem;
import com.sinco.carnation.kuaidi100.post.JacksonHelper;
import com.sinco.carnation.kuaidi100.service.TransInfoService;
import com.sinco.carnation.resource.bo.express.ExpressCompanyBO;
import com.sinco.carnation.resource.bo.express.TransContentBO;
import com.sinco.carnation.resource.bo.express.TransInfoBO;
import com.sinco.carnation.resource.vo.shop.ShopExpressTransViewVO;
import com.sinco.carnation.resource.web.actions.ApiConstants;
import com.sinco.carnation.resource.web.response.shop.ExpressCompanyListResponse;
import com.sinco.carnation.resource.web.response.shop.ExpressTransViewResponse;
import com.sinco.carnation.shop.constants.ExpressCompanyConstants;
import com.sinco.carnation.shop.model.ExpressCompany;
import com.sinco.carnation.shop.model.TransInfo;

@Controller
@RestController
@RequestMapping(ApiConstants.API)
@ApiMapping(desc = "物流信息", namespace = "express")
public class ShopExpressAction {

	@Autowired
	private Mapper mapper;

	@Autowired
	private ExpressCompanyService expressCompayService;

	@Autowired
	private TransInfoService transInfoService;

	@RequestMapping(value = "/shop/express/company/list", method = RequestMethod.POST)
	@MethodMapping(desc = "查找快递公司")
	public @ResponseBody
	ExpressCompanyListResponse companyList(HttpServletRequest request) {
		ExpressCompanyListResponse response = new ExpressCompanyListResponse();

		List<ExpressCompanyBO> list = MapperUtils.map(mapper,
				this.expressCompayService.findListByStatus(ExpressCompanyConstants.COMPANY_STATUS_ENABLE),
				ExpressCompanyBO.class);
		response.setList(list);

		return response;
	}

	// TODO

	// 物流
	@RequestMapping(value = "/shop/express/trans/view", method = RequestMethod.POST)
	@MethodMapping(desc = "查找快递详情")
	public @ResponseBody
	ExpressTransViewResponse expressTransView(@Valid @ModelAttribute @Param ShopExpressTransViewVO vo,
			BindingResult result, HttpServletRequest request) {
		ExpressTransViewResponse response = new ExpressTransViewResponse();

		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}

		TransInfoBO trans = new TransInfoBO();
		ExpressCompany ec = expressCompayService.getObjById(vo.getExpressCompanyId());

		TransInfo info = transInfoService.queryShipInfo(vo.getExpressCompanyId(), vo.getExpressCode());

		trans.setExpressEompanyName(info.getExpress_company_name());

		trans.setExpressShipCode(info.getExpress_ship_code());

		// trans.setData(MapperUtils.map(mapper,info.getData(),TransContentBO.class));

		String jsonObject = this.orderShipInfoJson(ec.getCompanyMark(), vo.getExpressCode());
		String res = this.transInfoService.getOrderExpressInfo(jsonObject);
		JSONObject jsonObj = JSONObject.fromObject(res);
		if (null != jsonObj) {
			String message = (String) jsonObj.get("message");
			if (null != message && message.equals("ok")) {

				List<ResultItem> list = JacksonHelper.fromJSONList(jsonObj.getString("data"),
						TransContentBO.class);
				trans.setData(MapperUtils.map(mapper, list, TransContentBO.class));
			}
		}
		if (ec != null) {
			trans.setExpressName(ec.getCompanyName());
		}
		response.setTrans(trans);
		return response;
	}

	/***
	 * 组装物流查询数据
	 * 
	 * @param oid
	 * @return
	 */
	@SuppressWarnings({"rawtypes", "unchecked"})
	private String orderShipInfoJson(String com, String num) {
		Map map = new HashMap();
		map.put("com", com);
		map.put("num", num);
		String jsonObject = JSONObject.fromObject(map).toString();
		return jsonObject;
	}

}
