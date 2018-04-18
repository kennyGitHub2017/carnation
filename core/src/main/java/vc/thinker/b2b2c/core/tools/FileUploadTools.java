package vc.thinker.b2b2c.core.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.ysysgo.fileos.OssTools;

import net.coobird.thumbnailator.Thumbnails;
import net.weedfs.client.RequestResult;
import net.weedfs.client.WeedFSClient;

/**
 * 文件上传工具类
 * 
 * @author zhoufeng.wang
 * 
 */
public class FileUploadTools {
	/**
	 * 设置最大图片大小
	 */
	public static final int IMG_MAX_SIZE = 8 * 1024 * 1024;
	
	protected static String accessKeyId="";
	protected static String accessKeySecret = "";
	protected static String endpoint = "";
	protected static String bucket="";
	
	@Autowired
	private static WeedFSClient fsClient;

	public FileUploadTools() {
	}

	/**
	 * 图片文件大小压缩上传
	 * 
	 * @param file
	 * @return
	 * @throws Exception
	 */
	public static RequestResult imageUpload(MultipartFile file) throws Exception {
		if (file.getSize() > IMG_MAX_SIZE) {
			throw new Exception("图片超出限制");
		}
		// 图片压缩，只压缩文件大小，不压缩尺寸
		String tempFileDir = "/temp/" + UUID.randomUUID() + "_" + new Date().getTime() + "_"
				+ file.getOriginalFilename();
		Thumbnails.of(file.getInputStream()).scale(1f).outputQuality(0.25f).toFile(tempFileDir);

		// 上传至图片服务器
		File toFile = new File(tempFileDir);
		InputStream uploadInputStream = new FileInputStream(toFile);
		RequestResult res = fsClient.upload(uploadInputStream, file.getOriginalFilename(),
				URLConnection.guessContentTypeFromName((file.getOriginalFilename())));

		// 临时图片删除
		if (toFile.exists()) {
			toFile.delete();
		}
		return res;
	}

	/**
	 * 文件按模块上传
	 * 
	 * @param file
	 * @param module
	 * @return
	 */
	public static String fileUpload(MultipartFile file, String module) throws Exception {
		if (file.getSize() > IMG_MAX_SIZE) {
			throw new Exception("图片超出限制");
		}
		return OssTools.ossFileUpload(file, null,null,null,module);
	}
	
	/**
	 * 带文件名上传
	 * @param file
	 * @param fileName
	 * @param module
	 * @return
	 * @throws Exception
	 */
	public static String fileUpload(MultipartFile file,String fileName ,String module)throws Exception{
		return OssTools.ossFileUpload(file, null,null,fileName,module);
	}
	
	public static String fileUpload(InputStream inputstream, String module) throws Exception {
		return OssTools.ossFileUpload(null, inputstream,null,null,module);
	}
	
	public static String fileUpload(byte[] fileByte,String module)throws Exception{
		return OssTools.ossFileUpload(null, null,fileByte,null,module);
	}
	
	
	/**
	 * 文件删除
	 * @param url
	 */
	public static void fileDelete(String url){
		OssTools.ossFileDelete(url,null);
	}

}
