package com.poetry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poetry.Entity.Auth;
import com.poetry.model.SearchRequest;
import com.poetry.service.GetAuthService;

@RestController
@RequestMapping("/authAction")
public class GetAuthControl {

	@Autowired
	GetAuthService authService;

	/**
	 * 作者信息全件查询
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("/getAuthAll")
	public Object getAuthAll() {
		return authService.getAuthAll();
	}
	
	/**
	 * 作者信息查询
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("/auth")
	public Object getAuth(@RequestBody SearchRequest req) {
		req.setKeyword("%" + req.getKeyword() + "%");
		return authService.getAuth(req);
	}

	/**
	 * 作者信息取得
	 * 
	 * @param auth
	 * @return
	 */
	@RequestMapping("/getAuth")
	public Object getAuth(@RequestBody Auth auth) {
		return authService.getAuth(auth);
	}

	/**
	 * 作者信息更新
	 * 
	 * @param auth
	 * @return
	 */
	@RequestMapping("/editAuth")
	public Object editAuth(@RequestBody Auth auth) {
		return authService.editAuth(auth);
	}
}
