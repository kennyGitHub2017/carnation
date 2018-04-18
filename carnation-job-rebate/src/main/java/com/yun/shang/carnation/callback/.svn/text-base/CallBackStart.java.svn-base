package com.yun.shang.carnation.callback;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sinco.carnation.rebate.service.RebateRecordService;
import com.sinco.carnation.shop.dao.PredepositLogDao;
import com.sinco.carnation.user.dao.UserMoneyDao;

public class CallBackStart {
	@SuppressWarnings("resource")
	public static void main(String args[]) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-context-job.xml");
		CallBack callBack = new CallBack();
		callBack.setRebateRecordService((RebateRecordService) context.getBean("rebateRecordService"));
		callBack.setPredepositLogDao((PredepositLogDao) context.getBean("predepositLogDao"));
		callBack.setUserMoneyDao((UserMoneyDao) context.getBean("userMoneyDao"));
		String code = "life12676720170725120352878508";
		callBack.excute(code);
	}
}
