package com.poetry.model;

/**
 * 检索
 * 
 * @author Administrator
 *
 */
public class SearchRequest {
	
	/**
	 * 用户
	 */
	private String username;

	/**
	 * 查询类型
	 */
	private int type;
	/**
	 * 输入条件
	 */
	private String keyword;
	/**
	 * 分类
	 */
	private String category;
	/**
	 * 作者
	 */
	private String auth;
	/**
	 * 朝代
	 */
	private String dynasty;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String categoryString) {
		this.category = categoryString;
	}

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	public String getDynasty() {
		return dynasty;
	}

	public void setDynasty(String dynasty) {
		this.dynasty = dynasty;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
