package vc.thinker.b2b2c.core.tools.database;

import java.sql.Connection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 
 * <p>
 * Title: DbConnection.java
 * </p>
 * 
 * <p>
 * Description: 数据库的连接,使用线程安全管理，确保数据库链接只存在一个，维护系统性能正常
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
@Repository
public class DbConnection {
	@Autowired
	private javax.sql.DataSource dataSource;
	// 线程安全
	public static final ThreadLocal<Connection> thread = new ThreadLocal<Connection>();

	public Connection getConnection() {
		Connection conn = thread.get();
		if (conn == null) {
			try {
				conn = this.dataSource.getConnection();
				thread.set(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return conn;
	}

	/**
	 * 关闭链接
	 * 
	 * @throws Exception
	 */
	public void closeAll() {
		try {
			Connection conn = thread.get();
			if (conn != null) {
				conn.close();
				thread.set(null);
			}
		} catch (Exception e) {
			try {
				throw e;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
