package com.poetry.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poetry.dao.DynastyDao;
import com.poetry.model.StateModel;
import com.poetry.utils.Property;

@Service
@Transactional
public class SaveDynastyService {

	@Autowired DynastyDao dynastyDao;
	
	/**
	 * 朝代新增
	 * @param dyStr
	 * @return
	 */
	public StateModel saveDynasty(String dyStr) {
		StateModel model = new StateModel();
		try {
			dynastyDao.saveDynasty(dyStr);
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
	 * 删除朝代
	 * @param dynasty
	 * @return
	 */
	public Object delDynasty(String dynasty) {
		StateModel model = new StateModel();
		if(!dynasty.isEmpty()) {
			try {
				dynastyDao.delDynasty(dynasty);
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
