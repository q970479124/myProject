package com.poetry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poetry.model.MasterModel;
import com.poetry.service.GetMasterService;

/**
 * 取得作者、朝代、类别
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/masterAction")
public class GetMasterControl {

	/**
	 * master取得
	 */
	@Autowired GetMasterService getMasterService;
	@RequestMapping("/master")
	public Object getMaster() {
		MasterModel model = getMasterService.getMaster();
		return model;
	}
	
	/**
	 * 朝代取得
	 * @return
	 */
	@RequestMapping("/getDynasty")
	public Object getDynasty() {
		MasterModel model = getMasterService.getDynasty();
		return model;
	}
}
