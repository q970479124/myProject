package com.poetry.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poetry.Entity.Authority;
import com.poetry.Entity.User;
import com.poetry.dao.AuthorityDao;
import com.poetry.dao.LoginDao;
import com.poetry.model.LoginModel;
import com.poetry.model.RegisterModel;
import com.poetry.utils.Property;

/**
 * 
 * @author Administrator
 *
 */
@Transactional
@Service
public class LoginServcice {

	@Autowired
	LoginDao loginDao;
	
	@Autowired AuthorityDao authorityDao;

	/**
	 * 登录
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public LoginModel getLogin(String username, String password) {

		LoginModel model = new LoginModel();
		if (username.isEmpty() || password.isEmpty()) {
			model.setState(Property.STATE_3);
			model.setCode(Property.CODE_PARAMETER_ERROR);
			model.setMessage(Property.MESSAGE_PARAMETER_ERROR);
			return model;
		}
		try {
			User user = loginDao.getUser(username);
			if (user != null) {
				Authority authority = authorityDao.getAuthority(username);
				StringBuffer sBuffer = new StringBuffer();
				sBuffer.append(user.getPassword());
				String oldPassword = sBuffer.reverse().toString();
				if (oldPassword.equals(password)) {
					model.setAuthority(authority.getAuthority());
					model.setState(Property.STATE_1);
					return model;
				} else {
					model.setState(Property.STATE_3);
					model.setCode(Property.CODE_LOGIN_PASSWORD_ERROR);
					model.setMessage(Property.MESSAGE_LOGIN_PASSWORD_ERROR);
					return model;
				}
			} else {
				model.setState(Property.STATE_3);
				model.setCode(Property.CODE_LOGIN_USERNAME_ERROR);
				model.setMessage(Property.MESSAGE_LOGIN_USERNAME_ERROR);
				return model;
			}
		} catch (Exception e) {
			model.setState(Property.STATE_3);
			model.setCode(Property.CODE_DB_ERROR);
			model.setMessage(Property.MESSAGE_DB_ERROR);
			return model;
		}
	}

	/**
	 * 注册
	 * 
	 * @param user
	 * @return
	 */
	public RegisterModel saveRegister(User user) {

		RegisterModel model = new RegisterModel();
		StringBuffer sb = new StringBuffer();

		if (user.getUsername().isEmpty() || user.getPassword().isEmpty()) {
			model.setState(Property.STATE_3);
			model.setCode(Property.CODE_PARAMETER_ERROR);
			model.setMessage(Property.MESSAGE_PARAMETER_ERROR);
			return model;
		} else {
			sb.append(user.getPassword());
			String pass = sb.reverse().toString();
			user.setPassword(pass);
		}
		try {
			User users = loginDao.getUser(user.getUsername());
			loginDao.saveRegister(user);
			// 权限
			authorityDao.saveAuthority(Property.AUTHORITY, user.getUsername());
			if (users != null) {
				model.setState(Property.STATE_3);
				model.setCode(Property.CODE_REGISTER_USERNAME_EXIST);
				model.setMessage(Property.MESSAGE_REGISTER_USERNAME_EXIST);
				return model;
			} else {
				model.setState(Property.STATE_1);
				return model;
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.setState(Property.STATE_3);
			model.setCode(Property.CODE_DB_ERROR);
			model.setMessage(Property.MESSAGE_DB_ERROR);
			return model;
		}
	}
}
