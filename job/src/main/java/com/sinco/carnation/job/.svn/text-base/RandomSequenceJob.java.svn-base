package com.sinco.carnation.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sinco.carnation.sys.service.MessageService;

/**
 * 随机排序任务 猜你喜欢，文章帖子，自测题
 * 
 * @author Administrator
 * 
 */
public class RandomSequenceJob {

	private MessageService messageService;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 随机排序
	 */
	public synchronized void randomSequence() {
		try {
			logger.info("[randomSequence] start");
			messageService.randomSequence();
		} catch (Exception e) {
			logger.error("random SequenceJob error.", e);
		}
	}

	public MessageService getMessageService() {
		return messageService;
	}

	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}

}
