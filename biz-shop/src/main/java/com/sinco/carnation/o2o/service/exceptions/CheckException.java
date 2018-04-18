/**
 * 
 */
package com.sinco.carnation.o2o.service.exceptions;

/**
 * 自定义检测参数异常
 * 
 * @author Young
 * 
 */
public class CheckException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CheckException() {
		super();
	}

	public CheckException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public CheckException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public CheckException(String arg0) {
		super(arg0);
	}

	public CheckException(Throwable arg0) {
		super(arg0);
	}
}
