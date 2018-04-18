package com.sinco.carnation.sys.test;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.user.dao.UserCustomerDao;
import com.sinco.carnation.user.model.UserCustomer;

@SuppressWarnings("deprecation")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
@TransactionConfiguration(defaultRollback = true)
@Transactional(readOnly = false)
public class UserCustomerDaoTest {

	@Autowired
	private UserCustomerDao dao;

	@Test
	public void insert() {
		UserCustomer model = new UserCustomer();
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
		UserCustomer model = dao.findById(id);
	}

	@Test
	public void updateById() {
		UserCustomer model = new UserCustomer();
		int result = dao.updateById(model);
		Assert.assertEquals(1, result);
	}

}