package com.poetry.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.poetry.Entity.Auth;
import com.poetry.infterface.AuthRespoitory;

/**
 * 作者
 * 
 * @author Administrator
 *
 */
@Repository
public class AuthDao {

	@Autowired
	AuthRespoitory authRespoitory;

	/**
	 * 作者查询
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Auth> getAuth() throws Exception {
		List<Auth> list = authRespoitory.findAll();
		return list;
	}

	/**
	 * 以作者名称查询
	 * 
	 * @param keyword
	 * @return
	 * @throws Exception
	 */
	public List<Auth> getNameAuth(final String keyword) throws Exception {
		List<Auth> list = authRespoitory.findNameAuth(keyword);
		return list;
	}

	/**
	 * 以朝代查询作者
	 * 
	 * @param keyword
	 * @return
	 * @throws Exception
	 */
	public List<Auth> getDyAuth(final String keyword) throws Exception {
		List<Auth> list = authRespoitory.findDyAuths(keyword);
		return list;
	}

	/**
	 * 新增作者
	 * 
	 * @return
	 * @throws Exception
	 */
	public int saveAuth(final String auth, final String dynasty, final String url, final String description, final int quantity)
			throws Exception {
		return authRespoitory.insert(auth, dynasty, url, quantity, description);
	}

	/**
	 * 删除作者
	 * 
	 * @param authString
	 */
	public void delAuth(final String auth) throws Exception {
		authRespoitory.delete(auth);
		authRespoitory.delPoetry(auth);
		authRespoitory.delPoetry(auth);
	}

	/**
	 * 作者信息更新
	 * 
	 * @param auth
	 */
	public void editAuth(Auth auth) {
		authRespoitory.updates(auth);
	}

	/**
	 * 作者信息全件查询
	 * @return
	 */
	public List<Auth> getAuthAll() {
		return authRespoitory.getAuthAll();
	}
}
