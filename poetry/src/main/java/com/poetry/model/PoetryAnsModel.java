package com.poetry.model;

import java.util.List;

/**
 * 诗词
 * 
 * @author Administrator
 *
 */
public class PoetryAnsModel extends StateModel {

	/**
	 * 诗词
	 */
	private List<PoetryAns> poetry;

	public List<PoetryAns> getPoetry() {
		return poetry;
	}

	public void setPoetry(List<PoetryAns> poetry) {
		this.poetry = poetry;
	}

}

