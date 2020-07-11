package com.poetry.infterface;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.poetry.Entity.User;

public interface UserRepository{

	/**
	 * 查询用户
	 * 
	 * @param name
	 * @return
	 */
	@Select("Select * from user u where u.username = #{name}")
	public User findUser(@Param("name") String name);
	
	@Insert("Insert into user (username, password, emil) values (#{username}, #{password}, #{emil})")
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
	public void save(@Param("username") String username, @Param("password") String password, @Param("emil") String emil);
}
