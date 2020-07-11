package com.poetry.model;

public class CollectionRequest {

	/**
	 * 诗名
	 */
	private String poetryname;
	
	/**
	 * 收藏状态
	 */
	private Boolean collection;
	
	/**
	 * 用户名
	 */
	private String username;

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPoetryname() {
		return poetryname;
	}
	public void setPoetryname(String poetryname) {
		this.poetryname = poetryname;
	}
	public Boolean getCollection() {
		return collection;
	}
	public void setCollection(Boolean collection) {
		this.collection = collection;
	}
	
}
