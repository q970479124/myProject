package com.poetry.Entity;

/**
 * 收藏
 * @author Administrator
 *
 */
public class Collection {
	
	private int id;
	
	/**
	 * 文章名称
	 */
	private String poetryname;
	
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

	public String getPoetryname() {
		return poetryname;
	}

	public void setPoetryname(String poetryname) {
		this.poetryname = poetryname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	

}
