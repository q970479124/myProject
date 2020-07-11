package com.poetry.infterface;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.poetry.Entity.Category;

/**
 * 分类
 * @author Administrator
 *
 */
public interface CategoryRepository{

	/**
	 * 查询所有分类
	 * @return
	 */
	@Select("Select * from category")
	public List<Category> findAll(); 
	
	/**
	 * 分类新增
	 * @param category
	 * @return
	 */
	@Insert("Insert into category (category) values (#{category})")
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
	public int insert(@Param("category") String category);
	
	/**
	 * 删除分类
	 * @param category
	 */
	@Delete("Delete from category where category = #{category}")
	public void delete(@Param("category") String category);
	
	/**
	 * 删除分类相关诗集
	 * @param category
	 */
	@Delete("Delete from poetry where category = #{category}")
	public void delPoetry(@Param("category") String category);

}
