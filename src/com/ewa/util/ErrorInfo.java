package com.ewa.util;

public class ErrorInfo extends Throwable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String detailMessage;
	
	public String getDetailMessage() {
		return this.detailMessage;
	}
	
	public void setDetailMessage(String detailMessage) {
		this.detailMessage = detailMessage;
	}
}
