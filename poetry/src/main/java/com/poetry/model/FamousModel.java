package com.poetry.model;

import java.util.List;

import com.poetry.Entity.Famous;

public class FamousModel extends StateModel{
	
	private List<Famous> famous;

	public List<Famous> getFamous() {
		return famous;
	}

	public void setFamous(List<Famous> famous) {
		this.famous = famous;
	}

}
