package com.poetry.Entity;

public class Poetry {

	private int id;
	
	/**
	 * 诗名
	 */
	private String poetryname;
	
	/**
	 * 作者
	 */
	private String auth;
	
	/**
	 * 内容
	 */
	private String content;
	
	/**
	 * 名句
	 */
	private String famous;
	
	/**
	 * 朝代
	 */
	private String dynasty;
	
	/**
	 * 适宜人群
	 */
	private String category;
	
	/**
	 * 点击量
	 */
	private int num;

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

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDynasty() {
		return dynasty;
	}

	public void setDynasty(String dynasty) {
		this.dynasty = dynasty;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getFamous() {
		return famous;
	}

	public void setFamous(String famous) {
		this.famous = famous;
	}

	@Override
	public String toString() {
		return "Poetry [id=" + id + ", poetryname=" + poetryname + ", auth=" + auth + ", content=" + content
				+ ", dynasty=" + dynasty + ", category=" + category + ", num=" + num + "]";
	}
	
}
