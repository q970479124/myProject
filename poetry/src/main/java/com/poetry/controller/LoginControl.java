package com.poetry.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.poetry.Entity.User;
import com.poetry.model.LoginModel;
import com.poetry.model.RegisterModel;
import com.poetry.service.LoginServcice;

@RestController
@RequestMapping("/loginAction")
public class LoginControl {

	@Autowired LoginServcice loginService;
	
	/**
	 * 登录
	 * @param map
	 * @return
	 */
	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public Object login(@RequestBody HashMap<String, Object> map) {
		String username = String.valueOf(map.get("username"));
		String password = String.valueOf(map.get("password"));
		LoginModel model = loginService.getLogin(username, password);
		return model;
	}
	
	/**
	 * 注册
	 * @param map
	 * @return
	 */
	@RequestMapping(path = "/register", method = RequestMethod.POST)
	public Object register(@RequestBody HashMap<String, Object> map) {
		User user = new User();
		user.setUsername(String.valueOf(map.get("username")));
		user.setPassword(String.valueOf(map.get("password")));
		user.setEmil(String.valueOf(map.get("emil")));
		RegisterModel model = loginService.saveRegister(user);
		return model;
	}

}
