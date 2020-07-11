package com.poetry.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poetry.Entity.Category;
import com.poetry.model.StateModel;
import com.poetry.service.SaveCategoryService;

@RestController
@RequestMapping("/saveCategoryAction")
public class SaveCategoryControl {

	@Autowired SaveCategoryService saveCategoryService;
	
	/**
	 * 新增分类
	 * @param map
	 * @return
	 */
	@RequestMapping("/cgAdd")
	public Object saveCategory(@RequestBody HashMap<String, Object> map) {
		String cateString = String.valueOf(map.get("category"));
		StateModel model = saveCategoryService.saveCategory(cateString);
		return model;
	}
	
	/**
	 * 删除作者
	 * @param auth
	 * @return
	 */
	@RequestMapping("/categoryDel")
	public Object delCategory(@RequestBody Category category) {
		return saveCategoryService.delCategory(category.getCategory());
	}
}
