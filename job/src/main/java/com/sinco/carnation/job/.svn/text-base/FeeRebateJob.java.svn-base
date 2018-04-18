package com.sinco.carnation.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.sinco.carnation.rebate.service.RebateService;

/**
 * 
 * @ClassName: FeeRebateJob
 * @Description: TODO(消费返润定时任务)
 * @author Tang
 * @date 2015年9月17日 下午5:38:18
 * 
 */
@Component
public class FeeRebateJob {
	@Autowired
	private RebateService revateService;

	/**
	 * 
	 * @Title: execute
	 * @Description: TODO(手续费返润每月28号执行，跑上一个月的返润数据)
	 * @param 设定文件
	 * @return void 返回类型
	 * @author Tang
	 * @throws
	 */
	@Scheduled(cron = "0 0 3 28 * ?")
//	@Scheduled(cron="0 0/10 * * * ?")
	public void execute() {
		System.out.println("==========！！！！手续费返润！！！！！==========");
		revateService.sendLastMonthChargeRebate();
		System.out.println("==========！！！！手续费返润！！！！！==========");
	}
}
