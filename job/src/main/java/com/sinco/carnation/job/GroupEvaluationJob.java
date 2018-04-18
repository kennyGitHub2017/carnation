package com.sinco.carnation.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.sinco.carnation.o2o.service.GroupEvaluationService;

@Component
public class GroupEvaluationJob {
	@Autowired
	private GroupEvaluationService evaluationService;

	// 每5分钟更新一次
	@Scheduled(cron = "0 0/5 * * * ?")
	public void execute() {
		System.out.println("group evaluate start...");
		evaluationService.dataToTotal(10);// 十分钟内更新
	}
}
