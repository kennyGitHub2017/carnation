package com.varicom.resource;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;

import org.apache.commons.io.FilenameUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.HttpClientBuilder;

public class UploadTest {

	// 由于不同类型需要进行不同方式处理，所以根据上传的实际文件类型增加对应后缀
	private static final String IMAGE_REQ = "/v1/image";
	@SuppressWarnings("unused")
	private static final String AUDIO_REQ = "/v1/audio";
	final static int BUFFER_SIZE = 4096;
	private static final String url = "http://api.jgclub.cn";

	public static void main(String[] args) throws Exception {

		String filePath = "/Users/james/svn/carnation/apis-resource/src/test/resources/test.jpg";
		HttpClient httpClient = HttpClientBuilder.create().build();
		// 图片 url + IMAGE_REQ
		// 音频 url + AUDIO_REQ
		// 视频 url + VIDEO_REQ
		HttpPost post = new HttpPost(url + IMAGE_REQ);

		MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();

		// 如果需要重构代码，只需要选择支持MultipartEntity上传的类库即可，默认BianryBody名为file
		multipartEntityBuilder.addBinaryBody("file", new File(filePath)/** alse support byte[] Inputstream **/
		, ContentType.APPLICATION_OCTET_STREAM, FilenameUtils.getName(filePath));
		// 如果需要重构代码，只需要选择支持MultipartEntity上传的类库即可，默认BianryBody名为file
		multipartEntityBuilder.addBinaryBody("file", new File(filePath)/** alse support byte[] Inputstream **/
		, ContentType.APPLICATION_OCTET_STREAM, FilenameUtils.getName(filePath));

		post.setEntity(multipartEntityBuilder.build());

		// 将参数加入到请求方法中
		try {
			HttpResponse response = httpClient.execute(post);

			/*
			 * output
				{"items":[{"file_url":"http://f3.varicom.com/37,9c53b6d127cb"},{"file_url":"http://f3.varicom.com/37,9c53b6d127cb_1"}],"success":true,"message":"上传成功"}
				items: 文件列表
				success: 成功为true  失败为false
				message:　上传信息

			 * file_url为主文件地址
			 *
			 * 关于图片:
			 * 如果需要裁剪为100x100 则文件路径为　http://f3.varicom.com/36,9c4587c8fe58.100x100
			 * 默认裁剪方式为自动裁剪，如果需要进行等比例补白操作，则文件路径为　http://f3.varicom.com/36,9c4587c8fe58.100x100s
			 *
			 * 关于语音:
			 * file_url 为语音文件地址，由于不是图片，所以上述关于图片的裁剪ＵＲＬ无效
			 *
			 * 关于视频:
			 * file_url为视频文件地址。
			 * 视频Frame截图路径为　主路径_1  http://f3.varicom.com/36,9c4587c8fe58_1
			 * 同理，按照图片裁剪原则，需要不同尺寸的缩略图可使用http://f3.varicom.com/36,9c4587c8fe58_1.100x100
			 *
			 */
			System.out.println(InputStreamTOString(response.getEntity().getContent(), "UTF-8"));

		} catch (Exception ex) {

			ex.printStackTrace();
		} finally {
			post.abort();
		}

	}

	public static String InputStreamTOString(InputStream in, String encoding) throws Exception {

		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		byte[] data = new byte[BUFFER_SIZE];
		int count = -1;
		while ((count = in.read(data, 0, BUFFER_SIZE)) != -1)
			outStream.write(data, 0, count);

		data = null;
		return new String(outStream.toByteArray(), "UTF-8");
	}

}
