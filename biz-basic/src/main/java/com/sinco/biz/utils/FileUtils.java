package com.sinco.biz.utils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy(false)
public class FileUtils {

	/***
	 * 根据当天日期创建文件夹
	 * 
	 * @return
	 */
	private static String createPath(String imageDiskPath) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		StringBuffer sbPath = new StringBuffer();
		sbPath.append(imageDiskPath).append(File.separator).append(calendar.get(Calendar.YEAR))
				.append(File.separator).append(calendar.get(Calendar.MONTH) + 1).append(File.separator)
				.append(calendar.get(Calendar.DAY_OF_MONTH));
		File diFile = new File(sbPath.toString());
		if (!diFile.exists()) {
			diFile.mkdirs();
		}

		return sbPath.toString();
	}

	/***
	 * 将图片文件写入到磁盘中
	 * 
	 * @param id
	 * @param imgData
	 */
	public static void saveImageToDisk(Long id, byte[] imgByte, String imageDiskPath) {
		String filePath = FileUtils.createPath(imageDiskPath);
		String fileName = new StringBuffer().append(id).append(".jpg").toString();
//		File newFile = new File(fileName);

		try {
			// 将字符串转换成二进制，用于显示图片
			// 将上面生成的图片格式字符串 imgStr，还原成图片显示

			InputStream in = new ByteArrayInputStream(imgByte);

			File file = new File(filePath, fileName);// 可以是任何图片格式.jpg,.png等
			FileOutputStream fos = new FileOutputStream(file);

			byte[] b = new byte[1024];
			int nRead = 0;
			while ((nRead = in.read(b)) != -1) {
				fos.write(b, 0, nRead);
			}
			fos.flush();
			fos.close();
			in.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}

	}

}
