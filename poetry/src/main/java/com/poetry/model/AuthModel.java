package com.poetry.model;

import java.util.List;

import com.poetry.Entity.Auth;

/**
 * 作者
 * @author Administrator
 *
 */
public class AuthModel extends StateModel{
	
	/**
	 * 作者信息
	 */
	private List<Auth> authList;

	public List<Auth> getAuthList() {
		return authList;
	}

	public void setAuthList(List<Auth> authList) {
		this.authList = authList;
	}
}
