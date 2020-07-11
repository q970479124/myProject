package com.poetry.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poetry.model.DynastyModel;
import com.poetry.model.StateModel;
import com.poetry.service.SaveDynastyService;

@RestController
@RequestMapping("/saveDynastyAction")
public class SaveDynastyControl {

	@Autowired SaveDynastyService saveDynastyService;
	
	/**
	 * 朝代新增
	 * @param map
	 * @return
	 */
	@RequestMapping("/dyAdd")
	public Object saveDynasty(@RequestBody HashMap<String, Object> map) {
		String dyStr = String.valueOf(map.get("dynasty"));
		StateModel model = saveDynastyService.saveDynasty(dyStr);
		return model;
	}
	
	/**
	 * 删除朝代
	 * @param dynasty
	 * @return
	 */
	@RequestMapping("/dynastyDel")
	public Object delDynasty(@RequestBody DynastyModel dynasty) {
		return saveDynastyService.delDynasty(dynasty.getDynasty());
	}
}
