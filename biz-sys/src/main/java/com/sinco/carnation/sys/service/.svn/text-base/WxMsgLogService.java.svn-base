package com.sinco.carnation.sys.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinco.carnation.sys.dao.WxMsgLogDao;
import com.sinco.carnation.sys.model.WxMsgLog;

/**
 * 微信消息
 * 
 */
@Service
public class WxMsgLogService {

	@Autowired
	private WxMsgLogDao wxMsgLogDao;

	/**
	 * 保存
	 * 
	 * @param actApply
	 * @return
	 */
	public boolean save(WxMsgLog record) {
		// TODO Auto-generated method stub
		try {
			record.setAddTime(new Date());
			this.wxMsgLogDao.save(record);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
