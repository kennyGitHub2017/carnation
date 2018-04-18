package vc.thinker.b2b2c.core.zip;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 * 
 * <p>
 * Title: CompressionResponse.java
 * </p>
 * 
 * <p>
 * Description: 完成数据输出流的压缩工作，该类在web应用中的可以使用web服务器配置完成相同的功能,后续版本将会删除，仅仅保留学习使用
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
public class CompressionResponse extends HttpServletResponseWrapper {
	protected HttpServletResponse response;
	private ServletOutputStream out;
	private CompressedStream compressedOut;
	private PrintWriter writer;
	protected int contentLength;

	public CompressionResponse(HttpServletResponse response) throws IOException {
		super(response);
		this.response = response;
		compressedOut = new CompressedStream(response.getOutputStream());
	}

	public void setContentLength(int len) {
		contentLength = len;
	}

	public ServletOutputStream getOutputStream() throws IOException {
		if (null == out) {
			if (null != writer) {
				throw new IllegalStateException("getWriter() has already been called on this response.");
			}
			out = compressedOut;
		}
		return out;
	}

	public PrintWriter getWriter() throws IOException {
		if (null == writer) {
			if (null != out) {
				throw new IllegalStateException("getOutputStream() has already been called on this response.");
			}
			writer = new PrintWriter(compressedOut);
		}
		return writer;

	}

	public void flushBuffer() {
		try {
			if (writer != null) {
				writer.flush();
			} else if (out != null) {
				out.flush();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void reset() {
		super.reset();
		try {
			compressedOut.reset();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void resetBuffer() {
		super.resetBuffer();
		try {
			compressedOut.reset();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void close() throws IOException {
		compressedOut.close();
	}
}