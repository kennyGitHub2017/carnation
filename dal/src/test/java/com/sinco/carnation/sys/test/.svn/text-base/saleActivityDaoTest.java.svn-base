package com.sinco.carnation.sys.test;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.market.bo.ActivityHotSaleBO;
import com.sinco.carnation.market.bo.ActivityHotSaleGoodsInfoBO;
import com.sinco.carnation.market.dao.ActivityHotSaleDao;
import com.sinco.dal.common.MyPage;

@SuppressWarnings("deprecation")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
@TransactionConfiguration(defaultRollback = true)
@Transactional(readOnly = false)
public class saleActivityDaoTest {

	@Autowired
	private ActivityHotSaleDao dao;

	/*@Test
	public void insert(){
		UserAccount model=new UserAccount();
		int result=dao.insert(model);
		Assert.assertEquals(1, result);
	}*/

	/*@Test
	public void findAll(){
		List<ActivityHotSaleBO> list = dao.findAllByStartTime();
		Assert.assertEquals(1, list.size());
	}*/

	@Test
	public void findList() {
		Long actHotSaleId = new Long(1);
		String vcode = "APP_HOT_SALE";
		List<ActivityHotSaleGoodsInfoBO> list = dao.findActHotSaleGoodsList(actHotSaleId, vcode);
		Assert.assertEquals(1, list.size());
	}

	@SuppressWarnings("unused")
	@Test
	public void findListByPage() {
		Long actHotSaleId = new Long(1);
		String vcode = "APP_HOT_SALE";

		int pageNum = 2, pageSize = 1;

		MyPage<ActivityHotSaleGoodsInfoBO> page = new MyPage<ActivityHotSaleGoodsInfoBO>();
		page.setPageNumber(pageNum);
		page.setPageSize(pageSize);

		// List<ActivityHotSaleGoodsInfoBO> list = dao.findActHotSaleGoodsList(actHotSaleId,vcode);

		List<ActivityHotSaleGoodsInfoBO> listPage = dao.findActHotSaleGoodsListByPage(actHotSaleId, vcode,
				page);
		// Assert.assertEquals(1, listPage.size());
	}

	@Test
	public void findByCode() {
		String code = "APP_INTEGER_GOODS";
		List<ActivityHotSaleBO> list = dao.findByCode(code);
		Assert.assertEquals(1, list.size());
	}

}