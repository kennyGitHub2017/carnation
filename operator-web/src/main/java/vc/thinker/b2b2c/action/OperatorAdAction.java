package vc.thinker.b2b2c.action;

import java.util.Date;
import java.util.List;

import net.weedfs.client.WeedFSClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.constant.UploadConstants;
import vc.thinker.b2b2c.core.security.support.OperatorUserDetails;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.core.tools.FileUploadTools;

import com.sinco.carnation.o2o.bo.GroupClassBO;
import com.sinco.carnation.o2o.bo.GroupGoodsBO;
import com.sinco.carnation.o2o.service.GroupClassService;
import com.sinco.carnation.o2o.service.GroupGoodsService;
import com.sinco.carnation.o2o.vo.GroupGoodsVO;
import com.sinco.carnation.recommend.service.AdvertPositionService;
import com.sinco.carnation.recommend.service.AdvertService;
import com.sinco.carnation.sns.SNSConstants;
import com.sinco.carnation.sns.bo.AdvertBO;
import com.sinco.carnation.sns.model.Advert;
import com.sinco.carnation.sns.model.AdvertPosition;
import com.sinco.carnation.sns.vo.AdvertVO;
import com.sinco.carnation.store.bo.StoreBO;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.user.UserContants;
import com.sinco.dal.common.MyPage;

/**
 * 
 * @ClassName: OperatorManageAction
 * @Description: TODO(运营商广告，PS:只有市级运营商才有此功能权限)
 * @author Tang
 * @date 2015年9月6日 下午3:06:17
 * 
 */
@Controller
public class OperatorAdAction {
	@Autowired
	private GroupGoodsService goodsService;
	@Autowired
	private GroupClassService groupClassService;
	@Autowired
	private WeedFSClient fsClient;
	@Autowired
	private AdvertService advertService;
	@Autowired
	private StoreService storeService;
	@Autowired
	private AdvertPositionService advertPositionService;

	@SecurityMapping(title = "运营商广告列表", value = "/operator/operator_ad_list.htm*", rtype = "operator", rname = "运营商广告列表", rcode = "operator_ad_list", rgroup = "运营商管理")
	@RequestMapping("/operator/operator_ad_list.html")
	public String operatorAdList(Model model, MyPage<AdvertBO> page, AdvertVO vo) {
		OperatorUserDetails user = (OperatorUserDetails) SecurityUserHolder.getCurrentUserDetails();
		if (!UserContants.OPERATOR_LEVEL_SHI.equals(user.getOperatorBO().getLevel())) {
			model.addAttribute("op_title", "没有操作权限！");
			return "tips.html";
		}
		vo.setAdUserId(user.getOperatorBO().getUserId());
		advertService.findPageByVO(vo, page);
		CommUtil.saveIPageList2Model("", "", "", page, model);
		model.addAttribute("vo", vo);
		return "operator_ad_list.html";
	}

	@SecurityMapping(title = "运营商广告添加", value = "/operator/operator_ad_add.htm*", rtype = "operator", rname = "运营商广告添加", rcode = "operator_ad_add", rgroup = "运营商管理")
	@RequestMapping("/operator/operator_ad_add.html")
	public String operatorAdAdd(Model model, Long goodsId, String adType, Long storeId) {
		OperatorUserDetails user = (OperatorUserDetails) SecurityUserHolder.getCurrentUserDetails();
		if (goodsId == null && storeId == null
				&& !UserContants.OPERATOR_LEVEL_SHI.equals(user.getOperatorBO().getLevel())) {
			model.addAttribute("op_title", "没有操作权限！");
			return "tips.html";
		}
		if (goodsId != null && SNSConstants.AD_TYPE_6.equals(adType)) {
			GroupGoodsBO goodsBO = goodsService.findOperatorGoodsById(goodsId, user.getOperatorBO().getId());
			if (goodsBO == null) {
				model.addAttribute("op_title", "没有操作权限！");
				return "tips.html";
			}
			model.addAttribute("goodsBO", goodsBO);
		}
		if (storeId != null && SNSConstants.AD_TYPE_5.equals(adType)) {
			StoreBO store = storeService.selectOwnStoreByOperatorId(user.getOperatorBO().getOperatorAreaId(),
					storeId, user.getOperatorBO().getLevel());
			if (store == null) {
				model.addAttribute("op_title", "没有操作权限！");
				return "tips.html";
			}
			model.addAttribute("store", store);
		}
		model.addAttribute("adType", adType);
		return "operator_ad_add.html";
	}

	@SecurityMapping(title = "运营商广告编辑", value = "/operator/operator_ad_edit.htm*", rtype = "operator", rname = "运营商广告编辑", rcode = "operator_ad_edit", rgroup = "运营商管理")
	@RequestMapping("/operator/operator_ad_edit.htm")
	public String operatorAdEdit(Model model, Long adId) {
		OperatorUserDetails user = (OperatorUserDetails) SecurityUserHolder.getCurrentUserDetails();
		if (!UserContants.OPERATOR_LEVEL_SHI.equals(user.getOperatorBO().getLevel())) {
			model.addAttribute("op_title", "没有操作权限！");
			return "tips.html";
		}
		AdvertBO advertBO = advertService.getBoById(adId);
		if (!advertBO.getAdUserId().equals(user.getOperatorBO().getUserId())) {
			model.addAttribute("op_title", "没有操作权限！");
			return "tips.html";
		}

		if (SNSConstants.AD_TYPE_6.equals(advertBO.getAdType())) {
			GroupGoodsBO goodsBO = goodsService.findOperatorGoodsById(Long.parseLong(advertBO.getAdUrl()),
					user.getOperatorBO().getId());
			if (goodsBO == null) {
				model.addAttribute("op_title", "没有操作权限！");
				return "tips.html";
			}
			model.addAttribute("goodsBO", goodsBO);
		} else if (SNSConstants.AD_TYPE_5.equals(advertBO.getAdType())) {
			StoreBO store = storeService.selectOwnStoreByOperatorId(user.getOperatorBO().getOperatorAreaId(),
					Long.parseLong(advertBO.getAdUrl()), user.getOperatorBO().getLevel());
			if (store == null) {
				model.addAttribute("op_title", "没有操作权限！");
				return "tips.html";
			}
			model.addAttribute("store", store);
		} else {
			model.addAttribute("op_title", "没有操作权限！");
			return "tips.html";
		}

		model.addAttribute("advertBO", advertBO);
		return "operator_ad_add.html";
	}

	@SecurityMapping(title = "运营商广告保存", value = "/operator/operator_ad_save.htm*", rtype = "operator", rname = "运营商广告保存", rcode = "operator_ad_save", rgroup = "运营商管理")
	@RequestMapping("/operator/operator_ad_save.htm")
	public String advert_save(Model model, AdvertVO advertVo, @RequestParam("advertImg") MultipartFile file) {
		Long areaId = null;
		OperatorUserDetails user = (OperatorUserDetails) SecurityUserHolder.getCurrentUserDetails();
		if ((!"APP_GROUP_INDEX".equals(String.valueOf(advertVo.getAdApCode())) && !"GROUP_HOME_SLIDE"
				.equals(String.valueOf(advertVo.getAdApCode())))
				|| !UserContants.OPERATOR_LEVEL_SHI.equals(user.getOperatorBO().getLevel())) {
			model.addAttribute("op_title", "没有操作权限！");
			return "tips.html";
		}
		if (advertVo.getId() == null) {
			if (SNSConstants.AD_TYPE_6.equals(advertVo.getAdType())) {
				GroupGoodsBO goodsBO = goodsService.findOperatorGoodsById(
						Long.parseLong(advertVo.getAdUrl()), user.getOperatorBO().getId());
				if (goodsBO == null) {
					model.addAttribute("op_title", "没有操作权限！");
					return "tips.html";
				}
				areaId = goodsBO.getGgGaId();
			} else if (SNSConstants.AD_TYPE_5.equals(advertVo.getAdType())) {
				StoreBO store = storeService.selectOwnStoreByOperatorId(user.getOperatorBO()
						.getOperatorAreaId(), Long.parseLong(advertVo.getAdUrl()), user.getOperatorBO()
						.getLevel());
				if (store == null) {
					model.addAttribute("op_title", "没有操作权限！");
					return "tips.html";
				}
				areaId = Long.parseLong(user.getOperatorBO().getOperatorAreaId());
			} else {
				model.addAttribute("op_title", "没有操作权限！");
				return "tips.html";
			}
		}

		if (advertVo != null) {
			AdvertPosition advertPosition = advertPositionService.findByCode(advertVo.getAdApCode());
			advertVo.setAdApId(advertPosition.getId());
			Date beginDate = null;
			Date endDate = null;
			if (advertVo.getStrAdBeginDate() != null && advertVo.getStrAdBeginDate() != "") {
				beginDate = CommUtil.formatDate(advertVo.getStrAdBeginDate());
			}
			if (advertVo.getStrAdEndDate() != null && advertVo.getStrAdEndDate() != "") {
				endDate = CommUtil.formatDate(advertVo.getStrAdEndDate());
			}
			Advert advert = advertVo;
			advert.setAdBeginTime(beginDate);
			advert.setAreaId(areaId);
			advert.setAdEndTime(endDate);
			if (file != null && file.getSize() != 0) {
				try {
					String fileUrl=FileUploadTools.fileUpload(file, UploadConstants.EDITOR);
					advert.setAdImgPath(fileUrl);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (advertVo.getId() != null && advertVo.getId() > 0) { // udapte
				advert.setAdStatus(0);
				advert.setAdUrl(null);
				advert.setAdUserId(null);
				advert.setAdType(null);
				advertService.update(advert);
			} else { // insert
				// 先把各种默认值设置为0
				advert.setAdClickNum(0);
				advert.setAdGold(0);
				advert.setAdStatus(0);
				advert.setAddTime(new Date());
				advert.setAdUserId(SecurityUserHolder.getCurrentUser().getId());
				if (advert.getAdSlideSequence() == null) {
					advert.setAdSlideSequence(0);
				}
				advertService.save(advert);
			}
		}
		model.addAttribute("url", "/operator/operator_ad_list.html");
		model.addAttribute("op_title", "保存广告成功");
		return "tips.html";
	}

	/**
	 * 广告删除
	 * 
	 * @param request
	 * @param mulitId
	 * @return
	 */
	@SecurityMapping(title = "运营商广告删除", value = "/operator/operator_ad_del.htm*", rtype = "operator", rname = "运营商广告删除", rcode = "operator_ad_del", rgroup = "运营商管理")
	@RequestMapping("/operator/operator_ad_del.htm")
	public String operatorAdDel(Model model, Long adId) {

		OperatorUserDetails user = (OperatorUserDetails) SecurityUserHolder.getCurrentUserDetails();
		AdvertBO advertBO = advertService.getBoById(adId);
		if (advertBO == null
				|| (!"APP_GROUP_INDEX".equals(String.valueOf(advertBO.getApCode())) && !"GROUP_HOME_SLIDE"
						.equals(String.valueOf(advertBO.getApCode())))
				|| !UserContants.OPERATOR_LEVEL_SHI.equals(user.getOperatorBO().getLevel())) {
			model.addAttribute("op_title", "没有操作权限！");
			return "tips.html";
		}
		if (SNSConstants.AD_TYPE_6.equals(advertBO.getAdType())) {
			GroupGoodsBO goodsBO = goodsService.findOperatorGoodsById(Long.parseLong(advertBO.getAdUrl()),
					user.getOperatorBO().getId());
			if (goodsBO == null) {
				model.addAttribute("op_title", "没有操作权限！");
				return "tips.html";
			}
		} else if (SNSConstants.AD_TYPE_5.equals(advertBO.getAdType())) {
			StoreBO store = storeService.selectOwnStoreByOperatorId(user.getOperatorBO().getOperatorAreaId(),
					Long.parseLong(advertBO.getAdUrl()), user.getOperatorBO().getLevel());
			if (store == null) {
				model.addAttribute("op_title", "没有操作权限！");
				return "tips.html";
			}
		} else {
			model.addAttribute("op_title", "没有操作权限！");
			return "tips.html";
		}
		advertService.delete(adId);
		model.addAttribute("op_title", "删除成功！");
		model.addAttribute("url", "/operator/operator_ad_list.html");
		return "tips.html";
	}

	@SecurityMapping(title = "运营商所属服务列表", value = "/operator/operator_group_list.htm*", rtype = "operator", rname = "运营商所属服务列表", rcode = "operator_group_list", rgroup = "运营商管理")
	@RequestMapping("/operator/operator_group_list.htm")
	public String operatorGroupList(Model model, MyPage<GroupGoodsBO> page, GroupGoodsVO vo) {
		OperatorUserDetails user = (OperatorUserDetails) SecurityUserHolder.getCurrentUserDetails();
		if (!UserContants.OPERATOR_LEVEL_SHI.equals(user.getOperatorBO().getLevel())) {
			model.addAttribute("op_title", "没有操作权限！");
			return "tips.html";
		}
		vo.setOperatorId(user.getOperatorBO().getId());
		page.setPageSize(10);
		goodsService.findOperatorGoodsListByVO(page, vo);
		CommUtil.saveIPageList2Model("", "", "", page, model);
		model.addAttribute("vo", vo);
		List<GroupClassBO> gcList = groupClassService.findAllParents();
		model.addAttribute("gcList", gcList);
		return "operator_group_list.html";
	}
}
