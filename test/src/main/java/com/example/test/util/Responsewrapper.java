package com.example.test.util;


/**
 * response
 */
public class Responsewrapper<Any> {

    private int code = 200;
    private String message = "success";
    private Any result;

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Any getResult() {
		return result;
	}

	public void setResult(Any result) {
		this.result = result;
	}


}