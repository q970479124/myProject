package com.poetry.model;

import java.util.List;

import com.poetry.Entity.Poetry;

/**
 * 诗词
 * 
 * @author Administrator
 *
 */
public class PoetryModel extends StateModel {

	/**
	 * 诗词
	 */
	private List<Poetry> poetry;

	public List<Poetry> getPoetry() {
		return poetry;
	}

	public void setPoetry(List<Poetry> poetry) {
		this.poetry = poetry;
	}

}
