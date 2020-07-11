package com.poetry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poetry.model.CollectionRequest;
import com.poetry.model.PoetryModel;
import com.poetry.model.SearchRequest;
import com.poetry.service.GetPoetryService;

@RestController
@RequestMapping("/poetryAction")
public class GetPoetryControl {

	@Autowired
	GetPoetryService poetryService;

	/**
	 * 诗词点击量降序排列
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("/poetryAll")
	public Object getPoetryAll() {
		PoetryModel model = poetryService.getPoetryAll();
		return model;
	}

	/**
	 * 诗词点击量降序排列
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("/poetry")
	public Object getPoetry(@RequestBody SearchRequest req) {
		return poetryService.getOrderDescPoetry(req.getUsername());
	}

	/**
	 * 检索
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("/search")
	public Object search(@RequestBody SearchRequest req) {
		req.setKeyword("%" + req.getKeyword() + "%");
		return poetryService.search(req);
	}

	/**
	 * 收藏
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("/collection")
	public Object collection(@RequestBody CollectionRequest req) {
		return poetryService.collection(req);
	}

	/**
	 * 查询全件名句
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("/getFamousAll")
	public Object getFamousAll() {
		return poetryService.getFamousAll();
	}

	/**
	 * 查询全件名句
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("/getFamous")
	public Object getFamous(@RequestBody SearchRequest req) {
		return poetryService.getFamous(req);
	}

}
