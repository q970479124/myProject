package com.poetry.Entity;

/**
 * 登录表
 * @author Administrator
 *
 */
public class LockUser {

	private int id;
	
	/**
	 * 用户名
	 */
	private String username;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
}
