package com.sinco.carnation.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyJob {

	@Scheduled(cron = "0/2 * * * * ?")
	public void execute() {
		System.out.println("定时任务！！！");
	}
}
