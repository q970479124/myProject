package com.poetry.model;

/**
 * 返回状态
 * @author Administrator
 *
 */
public class StateModel {

	/**
	 * 状态
	 */
	private int state;
	
	/**
	 * 描述
	 */
	private String message;
	
	/**
	 * 代码
	 */
	private String code;

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
}
