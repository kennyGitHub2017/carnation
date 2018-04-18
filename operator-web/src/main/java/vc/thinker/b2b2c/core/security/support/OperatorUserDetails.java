package vc.thinker.b2b2c.core.security.support;

import com.sinco.carnation.user.bo.OperatorBO;

public class OperatorUserDetails extends BasicUserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2567038825306107862L;

	private OperatorBO operatorBO;

	public OperatorBO getOperatorBO() {
		return operatorBO;
	}

	public void setOperatorBO(OperatorBO operatorBO) {
		this.operatorBO = operatorBO;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String getName() {
		return operatorBO.getUserName();
	}

}
