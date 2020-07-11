package com.poetry.model;

import java.util.List;

import com.poetry.Entity.Auth;
import com.poetry.Entity.Category;
import com.poetry.Entity.Dynasty;

/**
 * 取得作者、朝代、类别
 * @author Administrator
 *
 */
public class MasterModel extends StateModel{

	/**
	 * 作者
	 */
	private List<Auth> auth;
	
	/**
	 * 朝代
	 */
	private List<Dynasty> dynasty;
	
	/**
	 * 分类
	 */
	private List<Category> category;

	public List<Auth> getAuth() {
		return auth;
	}

	public void setAuth(List<Auth> auth) {
		this.auth = auth;
	}

	public List<Dynasty> getDynasty() {
		return dynasty;
	}

	public void setDynasty(List<Dynasty> dynasty) {
		this.dynasty = dynasty;
	}

	public List<Category> getCategory() {
		return category;
	}

	public void setCategory(List<Category> category) {
		this.category = category;
	}

}
