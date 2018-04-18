package vc.thinker.b2b2c.core.mv;

/**
 * json返回结果
 * 
 * @author JG-yes
 * 
 */
public class ActionResult {
	private int code;

	private String errMsg;

	private Object data;

	public static ActionResult NewFail(String msg) {
		ActionResult model = new ActionResult();
		model.code = 0;
		model.errMsg = msg;
		return model;
	}

	public static ActionResult NewSuccess(Object obj) {
		ActionResult model = new ActionResult();
		model.code = 1;
		model.setData(obj);
		return model;
	}

	public static ActionResult ReturnCode(int code) {
		ActionResult model = new ActionResult();
		model.setCode(code);
		return model;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
