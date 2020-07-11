package com.poetry.infterface;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.poetry.Entity.Dynasty;

/**
 * 朝代
 * 
 * @author Administrator
 *
 */
public interface DynastyRepository {

	/**
	 * 查询所有朝代
	 * @return
	 */
	@Select("Select * from dynasty")
	public List<Dynasty> findAll(); 
	
	/**
	 * 新增朝代
	 * @param dyanstry
	 * @return
	 */
	@Insert("Insert into dynasty (dynasty) values (#{dyanstry})")
	@Options(useGeneratedKeys = true , keyProperty = "id", keyColumn = "id")
	public int insertDy(@Param("dyanstry") String dyanstry);
	
	/**
	 * 删除朝代
	 * @param dynasty
	 */
	@Delete("Delete from dynasty where dynasty = #{dynasty}")
	public void delete(@Param("dynasty") String dynasty);
	
	/**
	 * 删除朝代相关诗集
	 * @param dynasty
	 */
	@Delete("Delete from poetry where dynasty = #{dynasty}")
	public void delPoetry(@Param("dynasty") String dynasty);

}
