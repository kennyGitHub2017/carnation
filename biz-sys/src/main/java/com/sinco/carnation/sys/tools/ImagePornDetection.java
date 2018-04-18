package com.sinco.carnation.sys.tools;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Properties;


import com.alibaba.fastjson.JSON;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.green.model.v20161216.ImageDetectionRequest;
import com.aliyuncs.green.model.v20161216.ImageDetectionResponse;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

/**
 * 图片监黄
 * 
 * @author zhoufeng.wang 2017年3月14日
 */
public class ImagePornDetection {
	protected static String regionId="cn-hangzhou";
	protected static String accessKeyId = "LTAIBrLB1TKXxIb2";
	protected static String accessKeySecret = "Ss8BuI2wseQ2m4utQTjbSzJvls3sh0";
	
	static {
		Properties prop = new Properties();
		try {
			prop.load(ImagePornDetection.class.getResourceAsStream("/application.properties"));
			accessKeyId = prop.getProperty("porn.accessKeyId");
			accessKeySecret = prop.getProperty("porn.secret");
			regionId=prop.getProperty("porn.regionId");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 监黄方法-同步方式 同步图片检测一次只支持单张图片进行检测
	 * 
	 * @param url
	 */
	public static Float syncImageDetection(String url) {
		Float rate = 0f;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("开始时间：" + sdf.format(new Date()));
		IClientProfile profile = DefaultProfile.getProfile(regionId,accessKeyId, accessKeySecret);
		IAcsClient client = new DefaultAcsClient(profile);
		ImageDetectionRequest imageDetectionRequest = new ImageDetectionRequest();
		// 是否同步调用 false: 同步
		imageDetectionRequest.setAsync(false);
		// 设置鉴别类型,porn: 黄图检测
		imageDetectionRequest.setScenes(Arrays.asList("porn"));
		imageDetectionRequest.setConnectTimeout(10000);
		imageDetectionRequest.setReadTimeout(10000);
		// 同步图片检测一次只支持单张图片进行检测
		imageDetectionRequest.setImageUrls(Arrays.asList(url));
		try {
			ImageDetectionResponse imageDetectionResponse = client.getAcsResponse(imageDetectionRequest);

			System.out.println(JSON.toJSONString(imageDetectionResponse));
			System.out.println("监黄返回值："+imageDetectionResponse.getCode());
			if ("Success".equals(imageDetectionResponse.getCode())) {
				List<ImageDetectionResponse.ImageResult> imageResults = imageDetectionResponse
						.getImageResults();
				if (imageResults != null && imageResults.size() > 0) {
					// 同步图片检测只有一个返回的ImageResult
					ImageDetectionResponse.ImageResult imageResult = imageResults.get(0);
					// 黄图检测结果
					ImageDetectionResponse.ImageResult.PornResult pornResult = imageResult.getPornResult();
					if (pornResult != null) {
						// 绿网给出的建议值, 0表示正常，1表示色情，2表示需要review
						//	Integer label = pornResult.getLabel();
						// 黄图分值, 0-100
						rate = pornResult.getRate();
						System.out.println("监黄分值为---------------：" + rate);
						System.out.println("结束时间：" + sdf.format(new Date()));
						return rate;
					}
				}
			}
		} catch (ServerException e) {
			e.printStackTrace();
		} catch (ClientException e) {
			e.printStackTrace();
		}
		return rate;
	}

}
