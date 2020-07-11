package com.poetry.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poetry.dao.CategoryDao;
import com.poetry.model.StateModel;
import com.poetry.utils.Property;

@Service
@Transactional
public class SaveCategoryService {

	@Autowired CategoryDao categoryDao;
	
	/**
	 * 新增分类
	 * @param cateString
	 * @return
	 */
	public StateModel saveCategory(String cateString) {
		StateModel model = new StateModel();
		try {
			categoryDao.saveCategory(cateString);
			model.setState(Property.STATE_1);
		} catch (Exception e) {
			model.setState(Property.STATE_3);
			model.setCode(Property.CODE_DB_ERROR);
			model.setMessage(Property.MESSAGE_DB_ERROR);
			return model;
		}
		return model;
	}

	/**
	 * 删除分类
	 * @param auth
	 * @return
	 */
	public Object delCategory(String category) {
		StateModel model = new StateModel();
		if(!category.isEmpty()) {
			try {
				categoryDao.delCategory(category);
				model.setState(Property.STATE_1);
			} catch (Exception e) {
				model.setState(Property.STATE_3);
				model.setCode(Property.CODE_DB_ERROR);
				model.setMessage(Property.MESSAGE_DB_ERROR);
				return model;
			}
		}
		return model;
	}
}
