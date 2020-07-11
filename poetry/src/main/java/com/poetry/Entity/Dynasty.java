package com.poetry.Entity;

/**
 * 朝代
 * 
 * @author Administrator
 *
 */
public class Dynasty {

	private int id;

	/**
	 * 朝代
	 */
	private String dynasty;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDynasty() {
		return dynasty;
	}

	public void setDynasty(String dynasty) {
		this.dynasty = dynasty;
	}

	@Override
	public String toString() {
		return "Dynasty [id=" + id + ", dynasty=" + dynasty + "]";
	}

}
