package com.poetry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poetry.Entity.Auth;
import com.poetry.Entity.Poetry;
import com.poetry.dao.AuthDao;
import com.poetry.dao.PoetryDao;
import com.poetry.model.StateModel;
import com.poetry.utils.Property;

@Service
@Transactional
public class SavePoetryService {

	@Autowired PoetryDao poetryDao;
	@Autowired AuthDao authDao;

	/**
	 * 诗歌新增
	 * @param poetry
	 * @return model
	 */
	public Object savePoetry(Poetry poetry) {
		StateModel model = new StateModel();
		try {
			List<Auth> authList = authDao.getNameAuth(poetry.getAuth());
			if(authList.size()<0) {
				model.setState(Property.STATE_2);
				model.setCode(Property.CODE_AUTH_ZERO);
				model.setMessage(Property.MESSAGE_AUTH_ZERO);
				return model;
			}else {
				poetry.setDynasty(authList.get(0).getDynasty());
				poetry.setNum(0);
			}
			int i = poetryDao.savePoetry(poetry);
			if(i!=-1) {
				Auth auth = authList.get(0);
				int x = auth.getQuantity() + 1;
				auth.setQuantity(x);
				authDao.editAuth(auth);
			}
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
	 * 删除诗歌
	 * @param poetry
	 * @return model
	 */
	public Object delPoetry(Poetry poetry) {
		StateModel model = new StateModel();
		try {
			List<Auth> authList = authDao.getNameAuth(poetry.getAuth());
			if(authList.size()<0) {
				model.setState(Property.STATE_2);
				model.setCode(Property.CODE_AUTH_ZERO);
				model.setMessage(Property.MESSAGE_AUTH_ZERO);
				return model;
			}else {
				int i =  poetryDao.delPoetry(poetry);
				if(i!=-1) {
					Auth auth = authList.get(0);
					int x = auth.getQuantity() - 1;
					auth.setQuantity(x);
					authDao.editAuth(auth);
				}
			}
			return model;
		} catch (Exception e) {
			model.setState(Property.STATE_3);
			model.setCode(Property.CODE_DB_ERROR);
			model.setMessage(Property.MESSAGE_DB_ERROR);
			return model;
		}
	}

	/**
	 * 修改诗歌
	 * @param poetry
	 * @return
	 */
	public Object editPoetry(Poetry poetry) {
		StateModel model = new StateModel();
		try {
			List<Auth> authList = authDao.getNameAuth(poetry.getAuth());
			if(authList.size()<0) {
				model.setState(Property.STATE_2);
				model.setCode(Property.CODE_AUTH_ZERO);
				model.setMessage(Property.MESSAGE_AUTH_ZERO);
				return model;
			}else {
				poetry.setDynasty(authList.get(0).getDynasty());
				poetryDao.editPoetry(poetry);
				model.setState(Property.STATE_1);
			}
			return model;
		} catch (Exception e) {
			model.setState(Property.STATE_3);
			model.setCode(Property.CODE_DB_ERROR);
			model.setMessage(Property.MESSAGE_DB_ERROR);
			return model;
		}
	}
}
