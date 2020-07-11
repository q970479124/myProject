package com.poetry.infterface;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.poetry.Entity.Famous;
import com.poetry.Entity.Poetry;
import com.poetry.model.PoetryAns;

/**
 * 诗词表 JPA JPQL
 * @author Administrator
 *
 */
public interface PoetryRepository {
	
	/**
	 * 检索全件
	 * @return
	 */
	@Select("SELECT p.* FROM poetry p LEFT JOIN ( SELECT c.poetryname, count( c.poetryname ) AS s FROM collection c GROUP BY c.poetryname ) AS t ON p.poetryname = t.poetryname ORDER BY t.s DESC")
	public List<Poetry> findAll();
	
	/**
	 * 按点击量降序查询
	 * @return
	 */
	@Select("SELECT p.*,o.username FROM poetry p LEFT JOIN (SELECT * FROM collection c WHERE username = #{username}) AS o ON p.poetryname = o.poetryname")
	public List<PoetryAns> findOrderDescPoetry(@Param("username") String username);
	
	/**
	 * 诗名检索
	 * @param keyword
	 * @return
	 */
	@Select("SELECT p.*,o.username FROM poetry p LEFT JOIN (SELECT * FROM collection c WHERE username = #{username}) AS o ON p.poetryname = o.poetryname WHERE p.POETRYNAME like #{keyword} ORDER BY p.NUM DESC")
	public List<PoetryAns> poetrynameSearch(@Param("username") String username, @Param("keyword") String keyword);
	
	/**
	 * 内容检索
	 * @param keyword
	 * @return
	 */
	@Select("SELECT p.*,o.username FROM poetry p LEFT JOIN (SELECT * FROM collection c WHERE username = #{username}) AS o ON p.poetryname = o.poetryname WHERE p.CONTENT like #{keyword} ORDER BY p.NUM DESC")
	public List<PoetryAns> contentSearch(@Param("username") String username, @Param("keyword") String keyword);
	
	/**
	 * 作者检索
	 * @param keyword
	 * @return
	 */
	@Select("SELECT p.*,o.username FROM poetry p LEFT JOIN (SELECT * FROM collection c WHERE username = #{username}) AS o ON p.poetryname = o.poetryname WHERE p.AUTH like #{keyword} ORDER BY p.NUM DESC")
	public List<PoetryAns> authSearch(@Param("username") String username, @Param("keyword") String keyword);
	
	/**
	 * 分类检索
	 * @param keyword
	 * @return
	 */
	@Select("SELECT p.*,o.username FROM poetry p LEFT JOIN (SELECT * FROM collection c WHERE username = #{username}) AS o ON p.poetryname = o.poetryname WHERE p.CATEGORY like #{keyword} ORDER BY p.NUM DESC")
	public List<PoetryAns> cateSearch(@Param("username") String username, @Param("keyword") String keyword);
	
	/**
	 * 朝代检索
	 * @param keyword
	 * @return
	 */
	@Select("SELECT p.*,o.username FROM poetry p LEFT JOIN (SELECT * FROM collection c WHERE username = #{username}) AS o ON p.poetryname = o.poetryname WHERE p.DYNASTY like #{keyword} ORDER BY p.NUM DESC")
	public List<PoetryAns> dySearch(@Param("username") String username, @Param("keyword") String keyword);

	/**
	 * 诗歌保存
	 * @param poetry
	 */
	@Insert("Insert into POETRY (poetryname, auth, content, famous, dynasty, category, num) values (#{poetryname}, #{auth}, #{content}, #{famous}, #{dynasty}, #{category}, #{num})")
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
	public int save(Poetry poetry);

	/**
	 * 删除诗集
	 * @return
	 */
	@Delete("Delete from POETRY where poetryname = #{poetryname} and auth = #{auth}")
	public int delete(@Param("poetryname") String poetryname, @Param("auth") String auth);

	/**
	 * 修改诗集
	 * @param poetry
	 * @return
	 */
	@Update("Update POETRY set poetryname = #{poetryname}, auth = #{auth}, content = #{content}, famous = #{famous}, dynasty = #{dynasty}, category = #{category} where id = #{id}")
	public int edit(Poetry poetry);

	/**
	 * 检索全件名句
	 * @return
	 */
	@Select("Select auth,famous,poetryname from Poetry")
	public List<Famous> getFamousAll();
	
	
	/**
	 * 名句(朝代)
	 * @return
	 */
	@Select("Select auth,famous,poetryname from Poetry where dynasty like #{dynasty}")
	public List<Famous> getFamousDynasty(@Param("dynasty") String dynasty);
	
	/**
	 * 名句(诗名)
	 * @return
	 */
	@Select("Select auth,famous,poetryname from Poetry where poetryname like #{poetryname}")
	public List<Famous> getFamousPoetryName(@Param("poetryname") String poetryname);
	
	/**
	 * 名句(作者)
	 * @return
	 */
	@Select("Select auth,famous,poetryname from Poetry where auth like #{auth}")
	public List<Famous> getFamousAuth(@Param("auth") String auth);
	
	/**
	 * 名句(内容)
	 * @return
	 */
	@Select("Select auth,famous,poetryname from Poetry where content like #{content}")
	public List<Famous> getFamousContent(@Param("content") String content);
	
	/**
	 * 作者检索
	 * @param keyword
	 * @return
	 */
	@Select("SELECT p.* from Poetry p WHERE p.AUTH like #{keyword} ORDER BY p.NUM DESC")
	public List<Poetry> authSaveSearch(@Param("keyword") String keyword);
	
}
