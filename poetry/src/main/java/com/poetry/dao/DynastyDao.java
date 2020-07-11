package com.poetry.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.poetry.Entity.Dynasty;
import com.poetry.infterface.DynastyRepository;

/**
 * 朝代
 * @author Administrator
 *
 */
@Repository
public class DynastyDao {
	
	@Autowired DynastyRepository dynastyRepository;
	
	/**
	 * 朝代查询
	 * @return
	 * @throws Exception
	 */
	public List<Dynasty> getDynasty() throws Exception{
		List<Dynasty> list = dynastyRepository.findAll();
		return list;
	}
	
	/**
	 * 朝代新增
	 * @param dyStr
	 * @return
	 */
	public int saveDynasty(final String dyStr) throws Exception{
		int i = dynastyRepository.insertDy(dyStr);
		return i;
	}

	/**
	 * 删除朝代
	 * @param dynasty
	 */
	public void delDynasty(String dynasty) throws Exception{
		dynastyRepository.delete(dynasty);
		dynastyRepository.delPoetry(dynasty);
	}

}
