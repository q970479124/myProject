package com.poetry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poetry.Entity.Auth;
import com.poetry.service.SaveAuthService;

@RestController
@RequestMapping("/saveAuthAction")
public class SaveAuthControl {
	
	@Autowired SaveAuthService saveAuthService;

	/**
	 * 作者新增
	 * @param map
	 * @return
	 */
	@RequestMapping("/authAdd")
	public Object saveAuth(@RequestBody Auth auth) {
		return saveAuthService.saveAuth(auth.getAuth(), auth.getDynasty(), auth.getUrl(), auth.getDescription());
	}
	
	/**
	 * 删除作者
	 * @param map
	 * @return
	 */
	@RequestMapping("/authDel")
	public Object delAuth(@RequestBody Auth auth) {
		return saveAuthService.delAuth(auth.getAuth());
	}
}
