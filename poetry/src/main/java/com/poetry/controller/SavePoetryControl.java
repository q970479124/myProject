package com.poetry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poetry.Entity.Poetry;
import com.poetry.service.SavePoetryService;

@RestController
@RequestMapping("/savePoetryAction")
public class SavePoetryControl {
	
	@Autowired SavePoetryService savePoetryService;
	
	/**
	 * 诗词保存
	 * @param poetry
	 * @return
	 */
	@RequestMapping("/savePoetry")
	public Object savePoetry(@RequestBody Poetry poetry) {
		return savePoetryService.savePoetry(poetry);
	}
	
	/**
	 * 删除诗歌
	 * @param poetry
	 * @return
	 */
	@RequestMapping("/delPoetry")
	public Object delPoetry(@RequestBody Poetry poetry) {
		return savePoetryService.delPoetry(poetry);
	}
	
	/**
	 * 修改诗歌
	 * @param poetry
	 * @return
	 */
	@RequestMapping("/editPoetry")
	public Object editPoetry(@RequestBody Poetry poetry) {
		return savePoetryService.editPoetry(poetry);
	}
}
