package com.sinco.carnation.resource.web.actions.share;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sinco.api.annotation.ApiMapping;
import com.sinco.api.annotation.MethodMapping;
import com.sinco.api.annotation.Param;
import com.sinco.api.web.BasicApiController;
import com.sinco.carnation.resource.vo.chare.ChareInfoVO;
import com.sinco.carnation.resource.web.actions.ApiConstants;
import com.sinco.carnation.resource.web.response.share.ShareInfoResponse;
import com.sun.jersey.core.util.Base64;

@Controller
@RequestMapping(ApiConstants.API)
@ApiMapping(desc = "分享", namespace = "share")
public class ShareController extends BasicApiController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 商品分享到微信
	 * 
	 * @param request
	 * @param response
	 * @param mobilePath
	 *            微商城域名
	 * @param url
	 *            分享请求地址
	 * @return
	 */
	@RequestMapping(value = "/share/productToWeChat", method = RequestMethod.GET)
	@MethodMapping(desc = "商品分享到微信")
	public @ResponseBody
	ShareInfoResponse shareProductToWeChat(HttpServletRequest request, HttpServletResponse response,
			@Valid @ModelAttribute @Param ChareInfoVO vo) {
		logger.info("===================== share product to WeChat ==================");
		String mobilePath = vo.getMobilePath();
		String url = vo.getUrl();
		logger.info("<<<<<<<<< params -> " + mobilePath + "->" + url);

		String urlEncode = new String(Base64.encode(url));
		logger.info("<<<<<<<<< encode url -> " + urlEncode);

		String weChatLogin = mobilePath + "/user/loginUrl.htm?url=" + urlEncode + "&login=true";

		logger.info(">>>>>>> result=" + weChatLogin);

		ShareInfoResponse result = new ShareInfoResponse();
		result.setShareReqURL(weChatLogin);
		return result;
	}

	/**
	 * 分享商品
	 * 
	 * @param request
	 * @param response
	 * @param vo
	 * @return
	 */
	@RequestMapping(value = "/share/shareProduct", method = RequestMethod.GET)
	@MethodMapping(desc = "分享商品")
	public ModelAndView shareProduct(HttpServletRequest request, HttpServletResponse response,
			@Valid @ModelAttribute @Param ChareInfoVO vo) {
		logger.info("===================== share product ==================");
		ModelAndView mv = new ModelAndView("share/sharel.html");
		String mobilePath = vo.getMobilePath();
		String url = vo.getUrl();
		logger.info("<<<<<<<<< params -> " + mobilePath + "->" + url);
		String urlEncode = new String(Base64.encode(url));
		logger.info("<<<<<<<<< encode url -> " + urlEncode);
		String weChatLogin = mobilePath + "/user/loginUrl.htm?url=" + urlEncode + "&login=0";
		logger.info(">>>>>>> result -> weChatLogin=" + weChatLogin + " -> url=" + url);
		mv.addObject("url", url);
		mv.addObject("weChatLogin", weChatLogin);
		return mv;
	}
}
