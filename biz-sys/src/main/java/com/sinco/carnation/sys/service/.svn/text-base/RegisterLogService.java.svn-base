package com.sinco.carnation.sys.service;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.nutz.json.Json;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.sys.dao.RegisterLogDao;
import com.sinco.carnation.sys.enums.EmRegisterFromType;
import com.sinco.carnation.sys.model.RegisterLog;
import com.sinco.common.utils.IPUtil;

import vc.thinker.b2b2c.core.tools.CommUtil;

@Service
public class RegisterLogService {

	private static final Logger logger = LoggerFactory.getLogger(RegisterLogService.class);

	@Autowired
	private RegisterLogDao registerLogDao;

	/**
	 * 创建登录日志
	 * 
	 * @param request
	 * @param mobile
	 * @param invitationCode
	 * @param type
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public RegisterLog createRegisterLog(HttpServletRequest request, String mobile, String invitationCode,
			EmRegisterFromType type) {
		try {
			RegisterLog log = new RegisterLog();
			log.setInvitationCode(invitationCode);
			log.setPhone(mobile);
			log.setIp(IPUtil.getIpAddr(request));
			log.setRegisterFrom((byte) type.getValue());
			log.setContent(Json.toJson(CommUtil.getRequestHeadsMap(request)));
			log.setCreateTime(new Date());
			return this.save(log);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("创建注册日志异常 ：{}", CommUtil.getStackTrace(e));
		}
		return null;
	}

	/**
	 * 
	 * @param record
	 * @return
	 */
	public RegisterLog save(RegisterLog record) {
		return this.registerLogDao.save(record);
	}
}
