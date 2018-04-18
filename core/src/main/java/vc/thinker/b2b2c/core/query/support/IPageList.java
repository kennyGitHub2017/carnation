package vc.thinker.b2b2c.core.query.support;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 
 * <p>
 * Title: IPageList.java
 * </p>
 * 
 * <p>
 * Description: 分页业务引擎
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
public interface IPageList extends Serializable {
	/**
	 * 得到查询结果集
	 * 
	 * @return 查询结果集
	 */
	@SuppressWarnings("rawtypes")
	public List getResult();

	/**
	 * 设置分页查询处理器
	 * 
	 * @param q
	 */
	public void setQuery(IQuery q);

	/**
	 * 返回总页数
	 * 
	 * @return 查询结果总页数
	 */

	public int getPages();

	/**
	 * 返回查询总记录数
	 * 
	 * @return 查询结果总记录数
	 */
	public int getRowCount();

	/**
	 * 返回有效的当前页
	 * 
	 * @return 有效的当前页
	 */
	public int getCurrentPage();

	/**
	 * 获取查询结果总页数
	 * 
	 * @return 每页记录数
	 */
	public int getPageSize();

	/**
	 * 执行查询操作
	 * 
	 * @param pageSize
	 *            每页记录数
	 * @param pageNo
	 *            页码
	 * @param totalSQL
	 *            统计sql
	 * @param construct
	 *            查询构造函数
	 * @param queryHQL
	 *            查询sql
	 */
	public void doList(int pageSize, int pageNo, String totalSQL, String construct, String queryHQL);

	/**
	 * 执行查询操作
	 * 
	 * @param pageSize
	 *            每页记录数
	 * @param pageNo
	 *            页码
	 * @param totalSQL
	 *            统计sql
	 * @param 查询构造函数
	 * @param queryHQL
	 *            查询sql
	 * @param params
	 *            查询参数
	 */
	@SuppressWarnings("rawtypes")
	public void doList(int pageSize, int pageNo, String totalSQL, String construct, String queryHQL,
			Map params);
}
