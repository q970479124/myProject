package com.poetry.infterface;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

/**
 * 用户锁
 * @author Administrator
 *
 */
public interface LockUserRespository {

	@Insert("INSERT INTO LOCKUSER (USERNAME) VALUES (#{username})")
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
	public void save(@Param("username") String username);
}
