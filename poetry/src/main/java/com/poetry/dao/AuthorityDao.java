package com.poetry.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.poetry.Entity.Authority;
import com.poetry.infterface.AuthorityRespoitory;

/**
 * 权限
 * @author Administrator
 *
 */
@Repository
public class AuthorityDao {

	@Autowired AuthorityRespoitory authorityRespoitory;
	
	/**
	 * 插入权限
	 * @param authority
	 * @param username
	 * @throws Exception
	 */
	public void saveAuthority(final int authority, final String username) throws Exception{
		authorityRespoitory.save(authority, username);
	}
	
	/**
	 * 取得权限
	 * @param username
	 * @return
	 * @throws Exception
	 */
	public Authority getAuthority(final String username) throws Exception{
		return authorityRespoitory.findName(username);
	}
}
