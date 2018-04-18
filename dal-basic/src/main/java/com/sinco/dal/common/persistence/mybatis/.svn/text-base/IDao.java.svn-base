package com.sinco.dal.common.persistence.mybatis;

import java.io.Serializable;
import java.util.List;

public interface IDao<T> {

	/**
	 * QL 查询所有
	 * 
	 * @return
	 */
	public List<T> findAll();

	/**
	 * 获取实体
	 * 
	 * @param id
	 * @return
	 */
	public T get(Serializable id);

	/**
	 * 保存实体
	 * 
	 * @param entity
	 */
	public void save(T entity);

	/**
	 * 添加实体
	 * 
	 * @param entity
	 */
	public void insert(T entity);

	/**
	 * 修改实体
	 * 
	 * @param entity
	 */
	public void update(T entity);

	/**
	 * 保存实体列表
	 * 
	 * @param entityList
	 */
	public void save(List<T> entityList);

	/**
	 * 逻辑删除
	 * 
	 * @param id
	 * @return
	 */
	public int deleteById(Serializable id);

}
