package vc.thinker.b2b2c.action.weChat;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VerifyCodeSendResponse {

	@JsonProperty("result")
	private String result;

	@JsonProperty("content")
	private String content;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
