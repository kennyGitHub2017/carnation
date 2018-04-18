package com.sinco.carnation.sys.tools;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sinco.carnation.sys.bo.SysConfigBO;
import com.sinco.carnation.sys.model.Accessory;
import com.sinco.carnation.sys.service.SysConfigService;

@Component
public class ImageViewTools {

	@Autowired
	private SysConfigService configService;

	public String random_login_img() {
		String img = "";
		SysConfigBO config = this.configService.getSysConfig();
		if (config.getLoginImgs() != null && config.getLoginImgs().size() > 0) {
			Random random = new Random();
			Accessory acc = config.getLoginImgs().get(random.nextInt(config.getLoginImgs().size()));
			img = acc.getPath() + "/" + acc.getName();
		} else {
			img = "resources/style/common/images/login_img.jpg";
		}
		return img;
	}
}
