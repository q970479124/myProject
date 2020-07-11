package com.poetry.Entity;

public class Authority {
	
	private int id;
	/**
	 * 权限
	 */
	private int authority;
	
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

	public int getAuthority() {
		return authority;
	}

	public void setAuthority(int authority) {
		this.authority = authority;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}
