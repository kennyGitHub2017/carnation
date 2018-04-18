package vc.thinker.b2b2c.core.zip;

import java.io.IOException;
import java.util.zip.GZIPOutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;

/**
 * 
 * <p>
 * Title: CompressedStream.java
 * </p>
 * 
 * <p>
 * Description:压缩输出流
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * 
 * <p>
 * Company: 深圳市新科聚合网络技术有限公司 www.thinker.vc
 * </p>
 * 
 * @author thinker
 * 
 * @date 2015-5-20
 * 
 * @version 1.0.1
 */
public class CompressedStream extends ServletOutputStream {
	private ServletOutputStream out;
	private GZIPOutputStream gzip;

	/**
	 * 指定压缩缓冲流
	 * 
	 * @param 输出流到压缩
	 * @throws IOException
	 *             if an error occurs with the {@link GZIPOutputStream}.
	 */
	public CompressedStream(ServletOutputStream out) throws IOException {
		this.out = out;
		reset();
	}

	/** @see ServletOutputStream * */
	public void close() throws IOException {
		gzip.close();
	}

	/** @see ServletOutputStream * */
	public void flush() throws IOException {
		gzip.flush();
	}

	/** @see ServletOutputStream * */
	public void write(byte[] b) throws IOException {
		write(b, 0, b.length);
	}

	/** @see ServletOutputStream * */
	public void write(byte[] b, int off, int len) throws IOException {
		gzip.write(b, off, len);
	}

	/** @see ServletOutputStream * */
	public void write(int b) throws IOException {
		gzip.write(b);
	}

	public void reset() throws IOException {
		gzip = new GZIPOutputStream(out);
	}

	@Override
	public boolean isReady() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setWriteListener(WriteListener writeListener) {
		// TODO Auto-generated method stub

	}

}
