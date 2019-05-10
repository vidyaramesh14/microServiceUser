package com.bridgelab.microfundoo.MicroUtil;


import org.springframework.stereotype.Component;

@Component
public class Response {

	private int statusCode;
	private String statusMessage;
	private String Name;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public long getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatusMessage() {
		return statusMessage;
	}
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	public Response() {

	}
}

