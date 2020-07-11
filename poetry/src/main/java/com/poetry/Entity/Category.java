package com.poetry.Entity;

/**
 * 类别
 * 
 * @author Administrator
 *
 */
public class Category {

	private int id;

	/**
	 * 类别
	 */
	private String category;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", category=" + category + "]";
	}

}
