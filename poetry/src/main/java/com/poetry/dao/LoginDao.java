package com.poetry.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.poetry.Entity.User;
import com.poetry.infterface.UserRepository;

/**
 * 用户查询
 * 
 * @author Administrator
 *
 */
@Repository
public class LoginDao {

	@Autowired
	UserRepository userRepository;
	
//	@Autowired

	/**
	 * 用户查询
	 * 
	 * @param username
	 * @return
	 */
	public User getUser(final String username) throws Exception {
		User user = userRepository.findUser(username);
		return user;
	}

	/**
	 * 注册
	 * 
	 * @param user
	 */
	public void saveRegister(final User user) {
		try {
			userRepository.save(user.getUsername(), user.getPassword(), user.getEmil());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
