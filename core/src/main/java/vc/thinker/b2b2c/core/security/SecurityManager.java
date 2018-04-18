package vc.thinker.b2b2c.core.security;

import java.util.Map;

/**
 * 
 * <p>
 * Title: SecurityManager.java
 * </p>
 * 
 * <p>
 * Description: 权限管理接口
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * 
 * <p>
 * Company: 深圳市新科聚合网络技术有限公司 www.thinker.vc
 * </p>
 * 
 * @author thinker
 * 
 * @date 2015-5-20
 * 
 * @version 1.0.1
 */
public interface SecurityManager {

	public Map<String, String> loadUrlAuthorities();

}
