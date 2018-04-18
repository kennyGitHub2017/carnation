package com.sinco.carnation.market.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.google.common.collect.Maps;
import com.sinco.carnation.market.bo.MsgInfoBO;
import com.sinco.carnation.market.dao.MsgInfoDao;
import com.sinco.carnation.market.vo.MsgInfoVO;
import com.sinco.dal.common.MyPage;
import com.sinco.dal.common.mapper.JsonMapper;
import com.sinco.messager.mobile.MobileMessageHandler;
import com.sinco.messager.mobile.MobileOSType;
import com.sinco.messager.mobile.jpush.AlertMobileMessage;

/**
 * 红包活动相关Service
 * 
 * @author 陈舟
 * 
 */
@Service
public class MsgInfoService {

	private final static Logger LOG = LoggerFactory.getLogger(JsonMapper.class);

	@Autowired
	MsgInfoDao msgInfoDao;

	/**
	 * 查找所有消息
	 * 
	 * @return
	 */
	public List<MsgInfoBO> findListByVo(MsgInfoVO vo, MyPage<MsgInfoBO> myPage) {

		return this.msgInfoDao.findListByVo(vo, myPage);
	}

	/**
	 * 查找消息
	 * 
	 * @return
	 */
	public MsgInfoBO findOne(Long id) {
		MsgInfoBO bo = this.msgInfoDao.findOne(id);
		return bo;
	}

	/**
	 * 保存
	 * 
	 * @param vo
	 */
	public void save(MsgInfoVO vo) {
		vo.setCreateTime(new Date());
		this.msgInfoDao.save(vo);
	}

	/**
	 * 删除
	 */
	@Transactional(readOnly = false)
	public void deleteByIds(String strIds, boolean isTop) {

		String[] idArray = strIds.split(",");
		for (String string : idArray) {
			delete(CommUtil.null2Long(string));
		}
	}

	private void delete(Long id) {
		MsgInfoBO model = new MsgInfoBO();
		model.setId(id);
		model.setDeleteStatus((byte) 1);
		if (model.getId() > 0L) {
			this.msgInfoDao.update(model);
		}
	}

	/**
	 * 置顶
	 * 
	 * @param id
	 * @param isTop
	 */
	@Transactional(readOnly = false)
	public void goTop(String strIds, boolean isTop) {

		String[] idArray = strIds.split(",");
		for (String string : idArray) {
			Long id = CommUtil.null2Long(string);
			goTop(isTop, id);
		}
	}

	private void goTop(boolean isTop, Long id) {
		MsgInfoBO model = new MsgInfoBO();
		model.setId(id);
		model.setTopIndex(isTop ? 1 : 0);
		if (model.getId() > 0L) {
			this.msgInfoDao.update(model);
		}
	}

	/**
	 * 发送消息
	 * 
	 * @param id
	 */
	@Transactional(readOnly = false)
	public String sendMsg(String strIds) {
		String err = "";
		String[] idArray = strIds.split(",");
		for (String temp : idArray) {
			Long id = CommUtil.null2Long(temp);

			MsgInfoBO bo = this.msgInfoDao.findOne(id);
			if (bo == null) {
				err += String.format("发送消息失败，记录未找到，ID：%s", id);
				break;
			}

			if (bo.getSendStatus() == 1) {
				err += String.format("发送消息失败，记录未找到，ID：%s,已发送过", id);
				break;
			}

			Date dt = new Date();
			bo.setModifyTime(dt);
			bo.setSendTime(dt);
			bo.setSendStatus(1L);
			this.msgInfoDao.update(bo);

			pushMessage(bo);
		}

		LOG.error(err);
		return err;
	}

	@Resource(name = "jpushMobileMessageHandler")
	private MobileMessageHandler mobileMessageHandler;

	/**
	 * 推送消息
	 * 
	 * @param bo
	 */
	public void pushMessage(MsgInfoBO bo) {
		// MessageMobileMessage message = new MessageMobileMessage(bo.getTitle());
		AlertMobileMessage message = new AlertMobileMessage(bo.getNoticeTitle());

		// 附加参数，需要什么自己加
		Map<String, String> exts = Maps.newHashMap();
		exts.put("id", String.valueOf(bo.getId()));
		exts.put("title", String.valueOf(bo.getTitle()));
		exts.put("mType", String.valueOf(bo.getReceiveType()));
		// exts.put("content", String.valueOf(bo.getContent()));
		exts.put("linkUrl", bo.getLinkUrl());
		message.setExts(exts);
		mobileMessageHandler.sendMessage(MobileOSType.ALL, message);
		// mobileMessageHandler.sendMessage(new TagMobileChannel(""),MobileOSType.ALL, message);
		// mobileMessageHandler.sendMessage(new AliasMobileChannel(String.valueOf(bo.getId())), message);
	}
}
