package com.sinco.carnation.elong.schedule;

import java.util.concurrent.Callable;

public abstract class ScheduleTask implements Callable<Schedule> {
	private Schedule schedule;
	
	public ScheduleTask(Schedule schedule){
		this.schedule = schedule;
	}

	public Schedule call() throws Exception {
		execute();
		return this.schedule;
	}
	
	public Schedule getSchedule(){
		return this.schedule;
	}
	
	public abstract void execute();

}
