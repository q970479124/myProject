package com.poetry.infterface;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.poetry.Entity.Auth;

/**
 * 作者
 * 
 * @author Administrator
 *
 */
public interface AuthRespoitory {

	/**
	 * 查询所有作者
	 * 
	 * @return
	 */
	@Select("Select * from auth")
	public List<Auth> findAll();

	/**
	 * 作者名称查询
	 * 
	 * @param auth
	 * @return
	 */
	@Select("Select * from auth where 1=1 and auth like #{auth}")
	public List<Auth> findNameAuth(@Param("auth") String auth);

	/**
	 * 朝代查询
	 * 
	 * @param dynasty
	 * @return
	 */
	@Select("Select * from auth where 1=1 and dynasty like #{dynasty}")
	public List<Auth> findDyAuths(@Param("dynasty") String dynasty);

	/**
	 * 作者新增
	 * 
	 * @param auth
	 * @param dynasty
	 * @param description
	 * @return
	 */
	@Insert("Insert into auth (auth, dynasty, url, quantity, description) values (#{auth}, #{dynasty}, #{url}, #{quantity}, #{description})")
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
	public int insert(@Param("auth") String auth, @Param("dynasty") String dynasty, @Param("url") String url, @Param("quantity") int quantity,
			@Param("description") String description);

	/**
	 * 删除作者（需要删除所以作品）
	 * 
	 * @param auth
	 */
	@Delete("Delete from auth where auth = #{auth}")
	public void delete(@Param("auth") String auth);

	/**
	 * 删除相关诗集
	 * 
	 * @param auth
	 */
	@Delete("Delete from poetry where auth = #{auth}")
	public void delPoetry(@Param("auth") String auth);


	/**
	 * 作者信息更新
	 * 
	 * @param auth
	 * @param dynasty
	 * @param Description
	 */
	@Update("Update Auth set dynasty = #{dynasty}, description = #{description} where auth = #{auth}")
	public int update(@Param("auth") String auth, @Param("dynasty") String dynasty,
			@Param("description") String Description);

	/**
	 * 作者信息更新2
	 * 
	 * @param auth
	 * @param dynasty
	 * @param Description
	 */
	@Update("Update Auth set dynasty = #{dynasty}, quantity = #{quantity}, url = #{url}, description = #{description} where auth = #{auth}")
	public int updates(Auth auth);

	/**
	 * 作者信息全件查询
	 * @return
	 */
	@Select("Select * from Auth")
	public List<Auth> getAuthAll();
}
