package com.poetry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poetry.Entity.Poetry;
import com.poetry.dao.AuthDao;
import com.poetry.dao.PoetryDao;
import com.poetry.model.StateModel;
import com.poetry.utils.Property;

@Service
@Transactional
public class SaveAuthService {

	@Autowired AuthDao authDao;
	@Autowired PoetryDao poetryDao;
	
	/**
	 * 新增作者
	 * @param auth
	 * @param dynasty
	 * @param description
	 * @return
	 */
	public StateModel saveAuth(String auth, String dynasty, String url, String description) {
		StateModel model = new StateModel();
		if(!"".equals(url)) {
			url = "/image/" + url;
		}
		int quantity = 0;
		try {
			List<Poetry> list = poetryDao.authSaveSearch(auth);
			quantity = list.size();
			authDao.saveAuth(auth, dynasty, url, description, quantity);
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
	 * 删除作者
	 * @param authString
	 * @return
	 */
	public StateModel delAuth(String authString) {
		StateModel model = new StateModel();
		if(!authString.isEmpty()) {
			try {
				authDao.delAuth(authString);
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
