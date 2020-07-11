package com.poetry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poetry.Entity.Auth;
import com.poetry.Entity.Category;
import com.poetry.Entity.Dynasty;
import com.poetry.dao.AuthDao;
import com.poetry.dao.CategoryDao;
import com.poetry.dao.DynastyDao;
import com.poetry.model.MasterModel;
import com.poetry.utils.Property;

/**
 * 取得作者、朝代、类别
 * 
 * @author Administrator
 *
 */
@Service
@Transactional
public class GetMasterService {

	@Autowired
	AuthDao authDao;
	@Autowired
	DynastyDao dynastyDao;
	@Autowired
	CategoryDao categoryDao;

	public MasterModel getMaster() {
		MasterModel model = new MasterModel();

		try {
			List<Auth> auth = authDao.getAuth();
			List<Dynasty> dynasty = dynastyDao.getDynasty();
			List<Category> category = categoryDao.getCategory();
			model.setAuth(auth);
			model.setDynasty(dynasty);
			model.setCategory(category);
			model.setState(Property.STATE_1);
			return model;
		} catch (Exception e) {
			model.setState(Property.STATE_3);
			model.setCode(Property.CODE_DB_ERROR);
			model.setMessage(Property.MESSAGE_DB_ERROR);
			return model;
		}
	}
	
	/**
	 * 朝代取得
	 * @return model
	 */
	public MasterModel getDynasty() {
		MasterModel model = new MasterModel();
		try {
			List<Dynasty> dynasty = dynastyDao.getDynasty();
			model.setDynasty(dynasty);
			model.setState(Property.STATE_1);
			return model;
		} catch (Exception e) {
			model.setState(Property.STATE_3);
			model.setCode(Property.CODE_DB_ERROR);
			model.setMessage(Property.MESSAGE_DB_ERROR);
			return model;
		}
	}

}
