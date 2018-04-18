package com.sinco.carnation.sys.test;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.sys.dao.UserAccountDao;
import com.sinco.carnation.sys.model.UserAccount;

@SuppressWarnings("deprecation")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
@TransactionConfiguration(defaultRollback = true)
@Transactional(readOnly = false)
public class UserAccountDaoTest {

	@Autowired
	private UserAccountDao dao;

	@Test
	public void insert() {
		UserAccount model = new UserAccount();
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
		UserAccount model = dao.findById(id);
	}

	@Test
	public void updateById() {
		UserAccount model = new UserAccount();
		int result = dao.updateById(model);
		Assert.assertEquals(1, result);
	}

}