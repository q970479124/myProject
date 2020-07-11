package com.poetry.infterface;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

/**
 * 收藏
 * @author Administrator
 *
 */
public interface CollectionRespoitory {

	/**
	 * 插入收藏
	 * @param poetryname
	 * @param username
	 */
	@Insert("INSERT INTO COLLECTION (POETRYNAME, USERNAME) VALUES (#{poetryname}, #{username})")
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
	public void save(@Param("poetryname") String poetryname, @Param("username") String username);
	
	/**
	 * 删除收藏
	 * @param poetryname
	 * @param username
	 */
	@Delete("DELETE FROM COLLECTION WHERE USERNAME = #{username} AND POETRYNAME = #{poetryname}")
	public void delect(@Param("poetryname") String poetryname, @Param("username") String username);
}
