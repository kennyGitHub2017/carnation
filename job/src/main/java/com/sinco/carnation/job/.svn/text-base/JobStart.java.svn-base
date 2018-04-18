package com.sinco.carnation.job;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sinco.carnation.job.basic.JobBasic;

public class JobStart implements InitializingBean {

	public static void main(String[] args) {
		String paths[] = {"spring-context-job.xml"};
		JobBasic.ctx = new ClassPathXmlApplicationContext(paths);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		main(new String[] {});
	}

}
