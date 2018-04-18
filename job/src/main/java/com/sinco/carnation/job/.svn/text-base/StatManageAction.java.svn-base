package com.sinco.carnation.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sinco.carnation.job.service.JobService;

/**
 * 
 * <p>
 * Title: StatManageAction.java
 * </p>
 * 
 * <p>
 * Description:系统定制器类，每间隔半小时执行一次，用在数据统计及团购开启关闭、自动确认订单生产结算日志等, 其他按小时计算的定制器都可以在这里增加代码控制
 * B2B2C2015版开始，系统定时器方法移到configService中，执行方法分别为runTimerByDay，runTimerByHalfhour
 * 移到configService中能够有效保持所有数据一致性。（hezeng）
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
 * @author thinker,hezeng
 * 
 * @date 2014-5-13
 * 
 * @version 1.0.1
 */
@Component
public class StatManageAction {
	@Autowired
	private JobService jobService;

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Scheduled(cron = "0 0/1 * * * ?")
//	@Scheduled(cron="0 17 11 * * ?")
	public void execute() throws Exception {
		System.out.println("＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝测试五分钟执行一次：正常半小时任务！＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝");
		log.info("[StatManageAction] action------");
		this.jobService.runTimerByHalfhour();
	}

	public JobService getJobService() {
		return jobService;
	}

	public void setJobService(JobService jobService) {
		this.jobService = jobService;
	}

}