package com.sinco.carnation.resource.web.actions.juanpi;

import java.util.List;

import javax.validation.Valid;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sinco.api.annotation.ApiMapping;
import com.sinco.api.annotation.MethodMapping;
import com.sinco.api.annotation.Param;
import com.sinco.api.util.ActionsUtil;
import com.sinco.api.web.BasicApiController;
import com.sinco.carnation.juanpi.bo.JuanpiGoodsBO;
import com.sinco.carnation.juanpi.service.JuanpiGoodsService;
import com.sinco.carnation.resource.bo.juanpi.JuanpiShareBO;
import com.sinco.carnation.resource.constant.ResultCodeConstant;
import com.sinco.carnation.resource.web.actions.ApiConstants;
import com.sinco.carnation.resource.web.response.Juanpi.JuanpiShareResponse;
import com.sinco.carnation.sys.bo.ShareBO;
import com.sinco.carnation.sys.bo.UserBO;
import com.sinco.carnation.sys.contants.ShareContants;
import com.sinco.carnation.sys.service.ShareService;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.carnation.sys.vo.ShareVO;

/***
 * 卷皮商品分享
 * @author Administrator
 * 
 *
 */
@Controller
@RestController
@RequestMapping(ApiConstants.API)
@ApiMapping(desc = "卷皮分享API", namespace = "juanpiShare")
public class JuanpiShareController extends BasicApiController{
	
	@Autowired
	private ShareService ShareService;
	@Autowired
	private JuanpiGoodsService JuanpiGoodsService;
	@Autowired
	private Mapper mapper;
	private static final Logger log = LoggerFactory.getLogger(JuanpiShareController.class);
	@Autowired
	private UserService userService;
	
	/****
	 * 卷皮商品分享内容
	 * @param goodsId
	 * @return
	 */
	@RequestMapping(value = "/shop/juanpiShare", method = RequestMethod.POST)
	@MethodMapping(desc = "卷皮商品分享")
	@ResponseBody
	public JuanpiShareResponse juanpiShare (@Valid @RequestParam(value = "goodsId") @Param(desc = "商品Id") Long goodsId) {
		JuanpiShareResponse response = new JuanpiShareResponse();
		JuanpiGoodsBO juanpiGoodsBO = this.JuanpiGoodsService.findOne(goodsId);
		ShareBO shareBO = null;
	
		if(juanpiGoodsBO != null) {
				shareBO = this.ShareService.findOneByGoodsId(goodsId);
			if (shareBO == null) {
				 ShareVO vo = new ShareVO();
				 
				 if (juanpiGoodsBO.getIsTuangou().intValue() == 1) {
					 vo.setMark(ShareContants.MARK_JUANPI_TUANGOU);
				 } else {
					 vo.setMark(ShareContants.MARK_JUANPI_PUTONG);
				 }
				 
				 List<ShareBO> list = this.ShareService.listByVO(vo);
				 if (list != null && list.size() > 0) {
					 shareBO = list.get(0);
				 }
				//    /** 1.商品标题 2.自定义 3.自定义+商品 **/
				if (shareBO.getTitleClass().intValue() == 1) {
					shareBO.setTitle(juanpiGoodsBO.getGoodsTitle());
				}
				if (shareBO.getTitleClass().intValue() == 3) {
					shareBO.setTitle(shareBO.getTitle()+juanpiGoodsBO.getGoodsTitle());
				}
				if (shareBO.getImgClass().intValue() == 1) {
					shareBO.setImgUrl(juanpiGoodsBO.getImageUrl());
				}
					
			} else {
				if (shareBO.getTitleClass().intValue() == 1) {
					shareBO.setTitle(juanpiGoodsBO.getGoodsTitle());
				}
				if (shareBO.getTitleClass().intValue() == 3) {
					shareBO.setTitle(shareBO.getTitle()+juanpiGoodsBO.getGoodsTitle());
				}
				if (shareBO.getImgClass().intValue() == 1) {
					shareBO.setImgUrl(juanpiGoodsBO.getImageUrl());
				}
			}
			
			UserBO userBO = this.userService.getObjById(ActionsUtil.getOwnerUid());
			
			if (userBO != null && userBO.getInvitationCode() != null) {
				int urlIndex = shareBO.getUrl().indexOf("?");
				if (urlIndex > 0) {
					shareBO.setUrl(shareBO.getUrl()+"&invitationCode="+userBO.getInvitationCode());
				} else {
					shareBO.setUrl(shareBO.getUrl()+"?invitationCode="+userBO.getInvitationCode());
				}
				
			}
			log.info("juanpiShare juanpiShare url {}",shareBO.getUrl());
			
		} else {
			log.info("juanpiShare juanpiShare not found id{}",goodsId);
			response.setM_status(ResultCodeConstant.ERROR_STATUS);
			response.setM_errorMsg("goods is not found");
			response.setM_errorCode(ResultCodeConstant.PARAMETER_ERROR);
		}
		response.setJuanpiShare(mapper.map(shareBO, JuanpiShareBO.class));
		return response;
	}
}
