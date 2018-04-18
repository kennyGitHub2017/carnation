package com.sinco.carnation.resource.web.response;

import java.util.ArrayList;
import java.util.List;

import com.sinco.api.response.ApiResponse;

public class Result extends ApiResponse {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<FileItem> items = new ArrayList<FileItem>();
	private boolean success = true;
	private String message;

	public List<FileItem> getItems() {
		return items;
	}

	public void addItems(FileItem item) {
		items.add(item);
	}

	public void setItems(List<FileItem> items) {
		this.items = items;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
