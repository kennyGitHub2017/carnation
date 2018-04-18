package com.sinco.carnation.sys.test;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.user.dao.UserCustomerFavoritesDao;
import com.sinco.carnation.user.model.UserCustomerFavorites;
import com.sinco.carnation.user.vo.UserCustomerFavoritesVO;

@SuppressWarnings("deprecation")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
@TransactionConfiguration(defaultRollback = true)
@Transactional(readOnly = false)
public class UserCustomerFavoritesDaoTest {

	@Autowired
	private UserCustomerFavoritesDao dao;

	@Test
	public void insert() {
		UserCustomerFavorites model = new UserCustomerFavorites();
		int result = dao.insert(model);
		Assert.assertEquals(1, result);
	}

	@Test
	public void deleteById() {
		Long id = 1L;
		int result = dao.deleteById(id);
		Assert.assertEquals(1, result);
	}

	@SuppressWarnings("unused")
	@Test
	public void findById() {
		Long id = 1L;
		UserCustomerFavorites model = dao.findById(id);
	}

	@Test
	public void updateById() {
		UserCustomerFavorites model = new UserCustomerFavorites();
		int result = dao.updateById(model);
		Assert.assertEquals(1, result);
	}

	@SuppressWarnings("unused")
	public void findByVO() {
		UserCustomerFavoritesVO vo = new UserCustomerFavoritesVO();
//		List<UserCustomerFavorites> list=dao.findByVO(vo);
	}
}