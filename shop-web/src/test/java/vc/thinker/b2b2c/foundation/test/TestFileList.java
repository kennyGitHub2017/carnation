package vc.thinker.b2b2c.foundation.test;

import java.io.File;

public class TestFileList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String strPath = "";
		File dir = new File(strPath);
		File[] files = dir.listFiles();
		for (File f : files) {
			System.out.println(f.getName());
		}
	}

}
