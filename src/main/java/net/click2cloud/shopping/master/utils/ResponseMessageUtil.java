package net.click2cloud.shopping.master.utils;

import org.springframework.stereotype.Component;

import net.click2cloud.shopping.master.response.ResponseMessage;

@Component
public class ResponseMessageUtil {

	public ResponseMessage sendResponse(boolean isSuccess, String message, String error) {

		ResponseMessage responseMessage = new ResponseMessage();
		responseMessage.setSuccess(isSuccess);
		if (isSuccess) {
			responseMessage.setMessage(message);
		} else {
			responseMessage.setError(error);
		}
		return responseMessage;

	}

}
