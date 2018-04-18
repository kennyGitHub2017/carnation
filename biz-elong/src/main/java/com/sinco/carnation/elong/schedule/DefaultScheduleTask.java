package com.sinco.carnation.elong.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sinco.carnation.elong.service.ElongOrderService;

public class DefaultScheduleTask extends ScheduleTask {
	private static final Logger LOGGER = LoggerFactory.getLogger(DefaultScheduleTask.class);
	private static final int[] UPDATE_RATE = {30, 60, 120};
	private ElongOrderService orderService;
	
	public DefaultScheduleTask(Schedule schedule, ElongOrderService orderService) {
		super(schedule);
		this.orderService = orderService;
	}

	@Override
	public void execute() {
		if(getSchedule() != null){
			//更新订单状态
			for(int rate : UPDATE_RATE){
				try{
					Thread.sleep(rate * 1000);
					orderService.synOrder(Long.parseLong(getSchedule().getSchedule_id()));
				}catch(Exception e){
					LOGGER.error("订单同步失败", e);
				}
			}
		}
	}

}
