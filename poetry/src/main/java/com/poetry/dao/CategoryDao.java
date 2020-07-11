package com.poetry.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.poetry.Entity.Category;
import com.poetry.infterface.CategoryRepository;

/**
 * 分类
 * @author Administrator
 *
 */
@Repository
public class CategoryDao {
	
	@Autowired CategoryRepository categoryRepository;
	
	/**
	 * 分类查询
	 * @return
	 * @throws Exception
	 */
	public List<Category> getCategory() throws Exception{
		List<Category> list = categoryRepository.findAll();
		return list;
	}
	
	/**
	 * 新增分类
	 * @param cateString
	 * @return
	 * @throws Exception
	 */
	public int saveCategory(final String cateString) throws Exception{
		return categoryRepository.insert(cateString);
	}

	/**
	 * 删除分类
	 * @param category
	 * @throws Exception
	 */
	public void delCategory(String category) throws Exception{
		categoryRepository.delete(category);
		categoryRepository.delPoetry(category);
	}
}
