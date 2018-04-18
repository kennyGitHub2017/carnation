package com.ysysgo.fileos;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import com.aliyun.oss.ClientConfiguration;
import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.ObjectMetadata;


/**
 * 文件上传工具类
 * 
 * @author zhoufeng.wang
 * 
 */
public class OssTools {
	/**
	 * 设置最大图片大小
	 */
	public static final int IMG_MAX_SIZE = 10 * 1024 * 1024;
	private static String ENDPOINT=OssConstants.OSS_ENDPOINT;
	private static String BUCKET=OssConstants.OSS_BUCKET;
	private static final Boolean ISMOCK=true;
	
	public static String ossFileUpload(MultipartFile file,InputStream inputstream,byte[] fileByte,String fileName, String module) {
		// 创建ClientConfiguration实例
		ClientConfiguration conf = new ClientConfiguration();
		// 设置OSSClient使用的最大连接数，默认1024
		conf.setMaxConnections(200);
		// 设置请求超时时间，默认50秒
		conf.setSocketTimeout(10000);
		// 设置失败请求重试次数，默认3次
		conf.setMaxErrorRetry(5);
		
		//根据module设置ENDPOINT，BUCKET
		OssInfo ossInfo=getOssInfo(module);		
		ENDPOINT=ossInfo.getEndpoint();
		BUCKET=ossInfo.getBucket();
		
		// 创建OSSClient实例
		OSSClient ossClient = new OSSClient(ENDPOINT, OssConstants.OSS_ACCESSKEYID, OssConstants.OSS_ACCESSKEYSECRET, conf);
		// 上传文件流
		ObjectMetadata objectMetadata = new ObjectMetadata();
		if(file!=null || fileByte!=null){
			//设置图片文件类型
//			objectMetadata.setContentType(file.getContentType());
//			if ("application/octet-stream".equals(file.getContentType())
//					|| "application/x-plt".equals(file.getContentType())) {
//				objectMetadata.setContentType("image/jpeg");
//			}
			objectMetadata.setContentType("image/jpeg");
		}
		if(fileName==null){
			fileName = UUID.randomUUID().toString().replaceAll("-", "") + new Date().getTime();
		}
		String keySuffixWithSlash =null;
		if("".equals(module)){
			keySuffixWithSlash = fileName;
		}else{
			keySuffixWithSlash = module==null?"":module+"/"+fileName;
		}
		try {
			if(fileByte==null){
				ossClient.putObject(BUCKET, keySuffixWithSlash,inputstream==null?file.getInputStream():inputstream, objectMetadata);
			}else{
				ossClient.putObject(BUCKET,keySuffixWithSlash, new ByteArrayInputStream(fileByte), objectMetadata);
			}
			URI url = ossClient.getEndpoint();
			// 关闭client
			ossClient.shutdown();
			return url.toString() + "/" + keySuffixWithSlash;
		} catch (OSSException e) {
			e.printStackTrace();
		} catch (ClientException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("["+module+"] oss upload error!");
		return null;
	}
	
	public static void ossFileDelete(String url,String module){
		//根据module设置ENDPOINT，BUCKET
		OssInfo ossInfo=getOssInfo(module);
		ENDPOINT=ossInfo.getEndpoint();
		BUCKET=ossInfo.getBucket();
		
		// 创建OSSClient实例
		OSSClient ossClient = new OSSClient(ENDPOINT, OssConstants.OSS_ACCESSKEYID, OssConstants.OSS_ACCESSKEYSECRET);
		
		String fileName=url.split("/")[url.split("/").length-1];
		// 删除Object
		ossClient.deleteObject(BUCKET, fileName);
		// 关闭client
		ossClient.shutdown();
	}
	
	
	static String getContentType(String fileName){
		return "image/jpeg";
	}
	
	/**
	 * 根据模块划分获得oss参数值
	 * @param module
	 * @return
	 */
	static OssInfo getOssInfo(String module){
		OssInfo ossInfo=new OssInfo();
		Map<String,String> ossSetMaps=OssConstants.getOssConstantSet(ISMOCK);
		
		//笼统存储位置
		if("".equals(module)){
			ossInfo.setEndpoint(ossSetMaps.get("OSS_ENDPOINT"));
			ossInfo.setBucket(ossSetMaps.get("OSS_BUCKET"));
			return ossInfo;
		}
		
		//健康圈
		if(module.startsWith("healthcircle")){
			ossInfo.setEndpoint(ossSetMaps.get("OSS_HEALTH_CIRCLE_ENDPOINT"));
			ossInfo.setBucket(ossSetMaps.get("OSS_HEALTH_CIRCLE_BUCKET"));
			return ossInfo;
		}
		
		//自营商品，积分兑换
		if(module.startsWith("goods") || module.startsWith("integral")){
			ossInfo.setEndpoint(ossSetMaps.get("OSS_GOODS_ENDPOINT"));
			ossInfo.setBucket(ossSetMaps.get("OSS_GOODS_BUCKET"));
			return ossInfo;
		}
		
		//商家商品，相册，精选专区
		if(module.startsWith("seller")){
			ossInfo.setEndpoint(ossSetMaps.get("OSS_SELLER_GOODS_ENDPOINT"));
			ossInfo.setBucket(ossSetMaps.get("OSS_SELLER_GOODS_BUCKET"));
			return ossInfo;
		}
		
		//资料（商户资料等）
		if(module.startsWith("data")){
			ossInfo.setEndpoint(ossSetMaps.get("OSS_DATA_ENDPOINT"));
			ossInfo.setBucket(ossSetMaps.get("OSS_DATA_BUCKET"));
			return ossInfo;
		}
		
		return ossInfo;
	}
}

class OssInfo{
	String endpoint;
	String bucket;
	public String getEndpoint() {
		return endpoint;
	}
	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}
	public String getBucket() {
		return bucket;
	}
	public void setBucket(String bucket) {
		this.bucket = bucket;
	}
	
}
