package com.poetry.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poetry.Entity.Famous;
import com.poetry.Entity.Poetry;
import com.poetry.dao.PoetryDao;
import com.poetry.model.CollectionModel;
import com.poetry.model.CollectionRequest;
import com.poetry.model.PoetryModel;
import com.poetry.model.SearchRequest;
import com.poetry.model.FamousModel;
import com.poetry.model.PoetryAns;
import com.poetry.model.PoetryAnsModel;
import com.poetry.utils.Property;

/**
 * 诗词事务层
 * 
 * @author Administrator
 *
 */
@Service
@Transactional
public class GetPoetryService {

	@Autowired
	PoetryDao poetryDao;

	/**
	 * 诗词点击量降序排列
	 * 
	 * @param index
	 * @return
	 */
	public PoetryAnsModel getOrderDescPoetry(String username) {

		PoetryAnsModel model = new PoetryAnsModel();
		List<PoetryAns> list = new ArrayList<PoetryAns>();
		try {
			list = poetryDao.getOrderDescPoetry(username);
			return lilength(list);
		} catch (Exception e) {
			model.setState(Property.STATE_3);
			model.setCode(Property.CODE_DB_ERROR);
			model.setMessage(Property.MESSAGE_DB_ERROR);
			return model;
		}
	}

	/**
	 * 检索
	 * 
	 * @param req
	 * @return
	 */
	public PoetryAnsModel search(SearchRequest req) {
		PoetryAnsModel model = new PoetryAnsModel();
		List<PoetryAns> list = new ArrayList<PoetryAns>();
		try {
			if (req.getType() == Property.ONE) {
				list = poetryDao.poetrynameSearch(req.getUsername(), req.getKeyword());
				return lilength(list);
			} else if (req.getType() == Property.TWO) {
				list = poetryDao.dySearch(req.getUsername(), req.getKeyword());
				return lilength(list);
			} else if (req.getType() == Property.THREE) {
				list = poetryDao.contentSearch(req.getUsername(), req.getKeyword());
				return lilength(list);
			} else if (req.getType() == Property.FOUR) {
				list = poetryDao.authSearch(req.getUsername(), req.getKeyword());
				return lilength(list);
			} else if (req.getType() == Property.FIVE) {
				list = poetryDao.cateSearch(req.getUsername(), req.getKeyword());
				return lilength(list);
			} else {
				list = poetryDao.poetrynameSearch(req.getUsername(), req.getKeyword());
				return lilength(list);
			}
		} catch (Exception e) {
			model.setState(Property.STATE_3);
			model.setCode(Property.CODE_DB_ERROR);
			model.setMessage(Property.MESSAGE_DB_ERROR);
			return model;
		}
	}

	/**
	 * 收藏
	 * 
	 * @param req
	 * @return
	 */
	public CollectionModel collection(CollectionRequest req) {
		CollectionModel model = new CollectionModel();
		try {
			if (req.getCollection()) {
				poetryDao.collectionSave(req);
			} else {
				poetryDao.collectionDel(req);
			}
		} catch (Exception e) {
			model.setState(Property.STATE_3);
			model.setCode(Property.CODE_DB_ERROR);
			model.setMessage(Property.MESSAGE_DB_ERROR);
		}
		return model;
	}

	/**
	 * 检索结果判断
	 * 
	 * @param list
	 * @return
	 */
	public static PoetryModel listlength(List<Poetry> list) {
		PoetryModel model = new PoetryModel();
		if (list.size() > 0) {
			model.setPoetry(list);
			model.setState(Property.STATE_1);
			return model;
		} else {
			model.setState(Property.STATE_2);
			model.setMessage(Property.MESSAGE_SEARCH_ZERO);
			model.setCode(Property.CODE_SEARCH_ZERO);
			return model;
		}
	}

	public static PoetryAnsModel lilength(List<PoetryAns> list) {
		PoetryAnsModel model = new PoetryAnsModel();
		if (list.size() > 0) {
			model.setPoetry(list);
			model.setState(Property.STATE_1);
			return model;
		} else {
			model.setState(Property.STATE_2);
			model.setMessage(Property.MESSAGE_SEARCH_ZERO);
			model.setCode(Property.CODE_SEARCH_ZERO);
			return model;
		}
	}

	public static FamousModel isFamous(List<Famous> list) {
		FamousModel model = new FamousModel();
		if (list.size() > 0) {
			model.setFamous(list);
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
	 * 检索全件
	 * 
	 * @return
	 */
	public PoetryModel getPoetryAll() {
		PoetryModel model = new PoetryModel();
		List<Poetry> list = new ArrayList<Poetry>();
		try {
			list = poetryDao.getPoetryAll();
			return listlength(list);
		} catch (Exception e) {
			model.setState(Property.STATE_2);
			model.setMessage(Property.MESSAGE_SEARCH_ZERO);
			model.setCode(Property.CODE_SEARCH_ZERO);
			return model;
		}
	}

	/**
	 * 检索全件名句
	 * 
	 * @return
	 */
	public FamousModel getFamousAll() {
		FamousModel model = new FamousModel();
		List<Famous> list = new ArrayList<Famous>();
		try {
			list = poetryDao.getFamousAll();
			return isFamous(list);
		} catch (Exception e) {
			model.setState(Property.STATE_2);
			model.setMessage(Property.MESSAGE_SEARCH_ZERO);
			model.setCode(Property.CODE_SEARCH_ZERO);
			return model;
		}
	}

	/**
	 * 检索名句
	 * 
	 * @param req
	 * @return
	 */
	public FamousModel getFamous(SearchRequest req) {
		FamousModel model = new FamousModel();
		List<Famous> list = new ArrayList<Famous>();
		req.setKeyword('%' + req.getKeyword() + '%');
		try {
			if (req.getType() == Property.ONE) {
				list = poetryDao.getFamousPoetryName(req.getKeyword());
				return isFamous(list);
			} else if (req.getType() == Property.TWO) {
				list = poetryDao.getFamousDynasty(req.getKeyword());
				return isFamous(list);
			} else if (req.getType() == Property.THREE) {
				list = poetryDao.getFamousContent(req.getKeyword());
				return isFamous(list);
			} else if (req.getType() == Property.FOUR) {
				list = poetryDao.getFamousAuth(req.getKeyword());
				return isFamous(list);
			} else {
				list = poetryDao.getFamousContent(req.getKeyword());
				return isFamous(list);
			}
		} catch (Exception e) {
			model.setState(Property.STATE_3);
			model.setCode(Property.CODE_DB_ERROR);
			model.setMessage(Property.MESSAGE_DB_ERROR);
			return model;
		}
	}
}
