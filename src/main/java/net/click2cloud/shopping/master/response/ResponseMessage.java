package net.click2cloud.shopping.master.response;

import lombok.Data;

@Data
public class ResponseMessage {
	
	private boolean success;
	private String message;
	private String error;
	private String path;

}