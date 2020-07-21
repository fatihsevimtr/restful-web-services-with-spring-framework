package com.exerate.ui.model.response;

import java.util.Date;

public class ErrorMessage {
	private Date timestamp;
	private String message;

	public ErrorMessage() {

	}

	public ErrorMessage(Date timestamp, String message) {
		this.timestamp = timestamp;
		this.message = message;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
