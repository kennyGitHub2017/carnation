package com.sinco.carnation.sys.constant;

import org.springframework.context.annotation.Bean;

/**
 * 获取配置文件属性
 * 
 * @author zhoufeng.wang 2017年3月20日
 */
public class PropertyConfigure {
	/**
	 * 监黄分值设置值
	 */
	private String pornRate;
	/**
	 * 监定为黄图是发短信通知的手机号码
	 */
	private String pornSmsMobile;

	@Bean
	public PropertyConfigure propertyConfigure() {
		PropertyConfigure propertyConfigure = new PropertyConfigure();
		propertyConfigure.setPornRate(pornRate);
		propertyConfigure.setPornSmsMobile(pornSmsMobile);
		return propertyConfigure;
	}

	public String getPornRate() {
		return pornRate;
	}

	public void setPornRate(String pornRate) {
		this.pornRate = pornRate;
	}

	public String getPornSmsMobile() {
		return pornSmsMobile;
	}

	public void setPornSmsMobile(String pornSmsMobile) {
		this.pornSmsMobile = pornSmsMobile;
	}

}
