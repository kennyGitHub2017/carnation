package generator;

import java.io.File;
import java.util.Collection;

import net.weedfs.client.RequestResult;
import net.weedfs.client.WeedFSFilerClient;

import org.apache.commons.io.FileUtils;

public class UploadTestImage {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WeedFSFilerClient client = new WeedFSFilerClient("120.24.68.189", "8888");
		String[] extensions = {"*"};
		File dir = new File("/Users/yaoweifeng/Documents/workspace/b2b2c/shop-web/src/main/webapp/resources");
		if (dir.exists()) {
			System.out.println(dir);
		}
		// File[] files = dir.listFiles();
		Collection<File> files = FileUtils.listFiles(dir, new String[] {"png", "jpg", "gif"}, true);
		// System.out.println(files);
		for (File f : files) {
			String path = f.getAbsolutePath().replace(dir.getAbsolutePath(), "resources");
			System.out.println(path);
			RequestResult result = client.upload(f, path);
			System.out.println(result.getFid());
		}
	}

}
