package com.poetry.infterface;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.poetry.Entity.Authority;

/**
 * 权限
 * 
 * @author Administrator
 *
 */
public interface AuthorityRespoitory {

	@Select("SELECT * FROM AUTHORITY WHERE USERNAME = #{username}")
	public Authority findName(@Param("username") String username);
	
	/**
	 * 保存
	 * @param authority
	 * @param username
	 */
	@Insert("INSERT INTO AUTHORITY (AUTHORITY, USERNAME) VALUES (#{authority}, #{username})")
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
	public void save(@Param("authority") int authority, @Param("username") String username);
}
