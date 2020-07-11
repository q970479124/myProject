package com.poetry.model;

import java.util.List;

import com.poetry.Entity.Poetry;

/**
 * 推荐
 * @author Administrator
 *
 */
public class RecommendModel extends StateModel{

	/**
	 * 诗词信息
	 */
	private List<Poetry> poetryList;

	public List<Poetry> getPoetryList() {
		return poetryList;
	}

	public void setPoetryList(List<Poetry> poetryList) {
		this.poetryList = poetryList;
	}
}
