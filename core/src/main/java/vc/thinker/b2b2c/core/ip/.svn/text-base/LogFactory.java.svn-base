package vc.thinker.b2b2c.core.ip;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * <p>
 * Title: LogFactory.java
 * </p>
 * 
 * <p>
 * Description:纯真ip查询日志记录
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
public class LogFactory {

	private static final Logger logger;
	static {
		logger = Logger.getLogger("stdout");
		logger.setLevel(Level.INFO);
	}

	public static void log(String info, Level level, Throwable ex) {
		logger.log(level, info, ex);
	}

	public static Level getLogLevel() {
		return logger.getLevel();
	}

}