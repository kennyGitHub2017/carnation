package com.sinco.carnation.sys.tools;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.sys.dao.IncrementDao;
import com.sinco.carnation.sys.model.Increment;

import vc.thinker.b2b2c.core.tools.CommUtil;

/**
 * 
 * @ClassName: CodeTools
 * @Description: TODO(生成各种码)
 * @author Tang
 * @date 2015年8月31日 下午3:10:40
 * 
 */
@Component
@Transactional
public class CodeTools {
	@Autowired
	IncrementDao incrementDao;

	private final String OPERATOR_CODE_PREFIX = "YY";

	/**
	 * 
	 * @Title: getOperatorCode
	 * @Description: TODO(运营商编码)
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @author Tang
	 * @throws
	 */
	public String getOperatorCode() {
		StringBuffer codeBuffer = new StringBuffer(OPERATOR_CODE_PREFIX);
		Increment increment = new Increment();
		increment = incrementDao.insert(increment);
		codeBuffer.append(increment.getId());
		return codeBuffer.toString();
	}

	/**
	 * 
	 * @Title: getInvitationCode
	 * @Description: TODO(邀请码)
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @author Tang
	 * @throws
	 */
	public String getInvitationCode() {
		Increment increment = new Increment();
		increment = incrementDao.insert(increment);
		return CommUtil.null2String(increment.getId());
	}
}
