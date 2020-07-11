package com.poetry.Entity;

/**
 * 作者
 * 
 * @author Administrator
 *
 */
public class Auth {
	private int id;

	/**
	 * 作者
	 */
	private String auth;
	
	/**
	 * 朝代
	 */
	private String dynasty;
	
	/**
	 * 作品数量
	 */
	private int quantity;
	
	/**
	 * 描述
	 */
	private String description;
	
	/**
	 * 图片路径
	 */
	private String url;

	public String getDynasty() {
		return dynasty;
	}

	public void setDynasty(String dynasty) {
		this.dynasty = dynasty;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Auth [id=" + id + ", auth=" + auth + "]";
	}

}
