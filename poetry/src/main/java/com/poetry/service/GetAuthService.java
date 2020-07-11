package com.poetry.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poetry.Entity.Auth;
import com.poetry.dao.AuthDao;
import com.poetry.model.AuthModel;
import com.poetry.model.SearchRequest;
import com.poetry.utils.Property;

@Service
@Transactional
public class GetAuthService {

	@Autowired
	AuthDao authDao;

	/**
	 * 作者信息查询
	 * 
	 * @return
	 */
	public AuthModel getAuth(SearchRequest req) {
		AuthModel model = new AuthModel();
		List<Auth> list = new ArrayList<Auth>();
		try {
			if (req.getType() == Property.ONE) {
				list = authDao.getNameAuth(req.getKeyword());
				return listlength(list);
			} else if (req.getType() == Property.TWO) {
				list = authDao.getDyAuth(req.getKeyword());
				return listlength(list);
			} else {
				list = authDao.getAuth();
				return listlength(list);
			}
		} catch (Exception e) {
			model.setState(Property.STATE_3);
			model.setCode(Property.CODE_DB_ERROR);
			model.setMessage(Property.MESSAGE_DB_ERROR);
			return model;
		}
	}

	/**
	 * 检索结果判断
	 * 
	 * @param list
	 * @return
	 */
	public static AuthModel listlength(List<Auth> list) {
		AuthModel model = new AuthModel();
		if (list.size() > 0) {
			model.setAuthList(list);
			model.setState(Property.STATE_1);
			return model;
		} else {
			model.setState(Property.STATE_2);
			model.setMessage(Property.MESSAGE_SEARCH_ZERO);
			model.setCode(Property.CODE_SEARCH_ZERO);
			return model;
		}
	}

	/**
	 * 作者查询
	 * 
	 * @param auth
	 * @return
	 */
	public AuthModel getAuth(Auth auth) {
		AuthModel model = new AuthModel();
		List<Auth> list = new ArrayList<Auth>();
		try {
			if ("".equals(auth.getAuth())) {
				list = authDao.getAuth();
			} else {
				list = authDao.getNameAuth(auth.getAuth());
			}
			return listlength(list);
		} catch (Exception e) {
			model.setState(Property.STATE_3);
			model.setCode(Property.CODE_DB_ERROR);
			model.setMessage(Property.MESSAGE_DB_ERROR);
			return model;
		}
	}

	/**
	 * 作者信息更新
	 * 
	 * @param auth
	 * @return
	 */
	public AuthModel editAuth(Auth auth) {
		AuthModel model = new AuthModel();
		if(!"".equals(auth.getUrl())) {
			auth.setUrl("/image/" + auth.getUrl());
		}
		try {
			authDao.editAuth(auth);
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
	 * 作者信息全件查询
	 * @return
	 */
	public AuthModel getAuthAll() {
		AuthModel model = new AuthModel();
		List<Auth> list = new ArrayList<Auth>();
		try {
			list = authDao.getAuthAll();
			return listlength(list);
		} catch (Exception e) {
			model.setState(Property.STATE_3);
			model.setCode(Property.CODE_DB_ERROR);
			model.setMessage(Property.MESSAGE_DB_ERROR);
			return model;
		}
	}
}
