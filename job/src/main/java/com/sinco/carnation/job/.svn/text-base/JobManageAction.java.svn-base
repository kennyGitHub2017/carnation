package com.sinco.carnation.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.sinco.carnation.job.service.JobService;

/**
 * 
 * <p>
 * Title: JobManageAction.java
 * </p>
 * 
 * <p>
 * Description: 系统定时任务控制器，每天00:00:01秒执行
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
 * @author thinker，hezeng
 * 
 * @date 2014-5-13
 * 
 * @version 1.0.1
 */
@Component
public class JobManageAction {
	@Autowired
	private JobService jobService;

	@Scheduled(cron = "0 0/10 * * * ?")
	public void execute() {
		System.out.println("＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝测试十分钟执行一次：正常一天任务！＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝");
		this.jobService.runTimerByDay();
	}

}
