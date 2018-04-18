package vc.thinker.b2b2c.core.security.support;

import com.sinco.carnation.user.bo.ManagerBO;
import com.sinco.carnation.user.bo.UserExpertsBO;

/**
 * session 保存用户的明细
 * 
 * @author james
 * 
 */
public class AdminUserDetails extends BasicUserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2567038825306107862L;

	/**
	 * 管理员
	 */
	private ManagerBO manager;

	/***
	 * 专家，目前专家和后台在一起
	 */
	private UserExpertsBO experts;

	/**
	 * 得到登陆用户名称
	 * 
	 * @return
	 */
	public String getName() {
		if (manager != null) {
			return manager.getName();
		} else if (experts != null) {
			return experts.getName();
		}
		return null;
	}

	public ManagerBO getManager() {
		return manager;
	}

	public void setManager(ManagerBO manager) {
		this.manager = manager;
	}

	public UserExpertsBO getExperts() {
		return experts;
	}

	public void setExperts(UserExpertsBO experts) {
		this.experts = experts;
	}
}
