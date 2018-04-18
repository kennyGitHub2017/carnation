package com.sinco.carnation.elong.schedule;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadPool {
	private static Logger logger = LoggerFactory.getLogger(ThreadPool.class);
	protected static final int DEFAULT_THREAD = 5;
	protected ExecutorService executor = null;
	protected CompletionService<Schedule> ecs = null;
	
	private ThreadPool(){
		executor = Executors.newCachedThreadPool();
		ecs = new ExecutorCompletionService<Schedule>(executor);
	}
	
	public void shutdown(){
		executor.shutdown();
	}
	
	private static class ThreadPoolFactory{
		private static final ThreadPool threadPool = new ThreadPool();
		public static ThreadPool getThreadPool(){
			return threadPool;
		}
	}
	
	public static ThreadPool getInstance(){
		return ThreadPoolFactory.getThreadPool();
	}
	
	protected void setPoolSize(int size){
		((ThreadPoolExecutor)executor).setCorePoolSize(size);
		((ThreadPoolExecutor)executor).setMaximumPoolSize(size);
	}
	
	/**
	 * 添加任务到线程池，多任务会并发运行
	 * @param task 任务
	 */
	public void addSchedule(ScheduleTask task) {
		addSchedule(task, null);
	}
	
	/**
	 * 添加任务到线程池
	 * @param task 任务
	 * @param callback 执行完回调，会阻塞当前线程直到任务运行完成
	 */
	public void addSchedule(ScheduleTask task, ScheduleCallback callback) {
		Future<Schedule> fu = ecs.submit(task);
		if(callback != null){
			try {
				callback.callback(fu.get());
			} catch (Exception e) {
				logger.error("任务执行失败[ " + task.getSchedule().getSchedule_id() + "]", e);
			}
		}
	}
	
}
