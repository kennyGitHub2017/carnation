package com.sinco.carnation.shop.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.nutz.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.shop.bo.ConsultBO;
import com.sinco.carnation.shop.dao.ConsultDao;
import com.sinco.carnation.shop.model.Consult;
import com.sinco.carnation.shop.vo.ConsultVO;
import com.sinco.carnation.sys.model.User;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.tools.MsgTools;
import com.sinco.carnation.user.service.UserCustomerService;
import com.sinco.dal.common.MyPage;

@Service
@Transactional(readOnly = true)
public class ConsultService {

	@Autowired
	private ConsultDao consultDao;
	@Autowired
	private SysConfigService configService;
	@Autowired
	private MsgTools msgTools;
	@Autowired
	private UserCustomerService userCustomerService;

	public int selectCountByRepayAndStoreId(Boolean reply, Long storeId) {
		return consultDao.selectCountByRepayAndStoreId(reply, storeId);
	}

	public void queryConsultList(String consultUserName, MyPage<ConsultBO> page) {
		page.setContent(consultDao.queryConsultList(consultUserName, page));
	}

	public void queryConsultSelfList(String consultUserName, Boolean reply, MyPage<ConsultBO> page) {
		page.setContent(consultDao.queryConsultSelfList(consultUserName, reply, page));
	}

	public void selectConsultListByVO(ConsultVO vo, MyPage<ConsultBO> page) {
		consultDao.selectConsultListByVO(vo, page);
	}

	@Transactional(readOnly = false)
	public void save(Consult record) {
		consultDao.save(record);
	}

	@Transactional(readOnly = false)
	public void deleteConsultByIds(String mulitId) {
		if (StringUtils.isNotBlank(mulitId)) {
			String[] ids = mulitId.split(",");
			Long[] longIds = new Long[ids.length];
			for (int i = 0; i < ids.length; i++) {
				longIds[i] = CommUtil.null2Long(ids[i]);
			}
			consultDao.deleteConsultById(longIds);
		}
	}

	@Transactional(readOnly = false)
	public void deleteConsults(String[] ids, Long storeId) {
		for (String id : ids) {
			if (!id.equals("")) {
				Consult obj = this.getObjById(CommUtil.null2Long(id));
				if (obj.getStoreId().equals(storeId)) {
					consultDao.delete(CommUtil.null2Long(id));
				}
			}
		}
	}

	public Consult queryConsultById(Long id) {
		return consultDao.queryConsultById(id);
	}

	@Transactional(readOnly = false)
	public void updateConsult(User user, String consultReply, String id) {
		Consult obj = consultDao.queryConsultById(CommUtil.null2Long(id));
		obj.setConsultReply(consultReply);
		obj.setReplyTime(new Date());
		obj.setReplyUserId(user.getId());
		obj.setReplyUserName("平台运营商");
		obj.setReply(true);
		consultDao.update(obj);
	}

	public void findListByVO(MyPage<ConsultBO> page, ConsultVO vo) {
		this.consultDao.findListByVO(page, vo);
	}

	public Consult getObjById(Long id) {
		Consult consult = this.consultDao.get(id);
		if (consult != null) {
			return consult;
		}
		return null;
	}

	@Transactional(readOnly = false)
	public void update(Consult consult) {
		consultDao.update(consult);
	}

	@SuppressWarnings({"unchecked", "rawtypes"})
	@Transactional(readOnly = false)
	public void consultReplySave(String id, String consultReply, String userName, Long uid, Long storeId,
			String url) throws Exception {
		Consult obj = this.getObjById(CommUtil.null2Long(id));
		obj.setConsultReply(consultReply);
		obj.setReplyTime(new Date());
		obj.setReplyUserId(uid);
		obj.setReplyUserName(userName);
		obj.setReply(true);
		this.update(obj);
		if (this.configService.getSysConfig().getEmailEnable() && obj.getConsultUserId() != null) {
			Map map = new HashMap();
			map.put("buyer_id", CommUtil.null2String(obj.getConsultUserId()));
			List<Map> maps = CommUtil.Json2List(obj.getGoodsInfo());
			for (Map m : maps) {
				map.put("goods_id", m.get("goods_id").toString());
			}
			String json = Json.toJson(map);
			this.msgTools.sendEmailCharge(url, "email_tobuyer_cousult_reply_notify", this.userCustomerService
					.findById(obj.getConsultUserId()).getEmail(), json, null, CommUtil.null2String(storeId));
		}

	}

}
