package com.poetry.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.poetry.Entity.Famous;
import com.poetry.Entity.Poetry;
import com.poetry.infterface.CollectionRespoitory;
import com.poetry.infterface.PoetryRepository;
import com.poetry.model.CollectionRequest;
import com.poetry.model.PoetryAns;

/**
 * 诗词
 * @author Administrator
 *
 */
@Repository
public class PoetryDao {
	
	@Autowired PoetryRepository poetryRepository;
	@Autowired CollectionRespoitory collectionRespoitory;

	/**
	 * 诗词点击量降序排列
	 * @return
	 * @throws Exception
	 */
	public List<PoetryAns> getOrderDescPoetry(final String username) throws Exception{
		return poetryRepository.findOrderDescPoetry(username);
	}
	
	/**
	 * 诗名检索
	 * @param keyword
	 * @return
	 * @throws Exception
	 */
	public List<PoetryAns> poetrynameSearch(final String username, final String keyword) throws Exception{
		return poetryRepository.poetrynameSearch(username, keyword);
	}
	
	/**
	 * 内容检索
	 * @param keyword
	 * @return
	 * @throws Exception
	 */
	public List<PoetryAns> contentSearch(final String username, final String keyword) throws Exception{
		return poetryRepository.contentSearch(username, keyword);
	}
	
	/**
	 * 作者检索
	 * @param keyword
	 * @return
	 * @throws Exception
	 */
	public List<PoetryAns> authSearch(final String username, final String keyword) throws Exception{
		return poetryRepository.authSearch(username, keyword);
	}
	
	/**
	 * 分类检索
	 * @param keyword
	 * @return
	 * @throws Exception
	 */
	public List<PoetryAns> cateSearch(final String username, final String keyword) throws Exception{
		return poetryRepository.cateSearch(username, keyword);
	}
	
	/**
	 * 朝代检索
	 * @param keyword
	 * @return
	 * @throws Exception
	 */
	public List<PoetryAns> dySearch(final String username, final String keyword) throws Exception{
		return poetryRepository.dySearch(username, keyword);
	}
	
	/**
	 * 插入收藏
	 * @param req
	 * @throws Exception
	 */
	public void collectionSave(final CollectionRequest req) throws Exception{
		collectionRespoitory.save(req.getPoetryname(), req.getUsername());
	}
	
	/**
	 * 删除收藏
	 * @param req
	 * @throws Exception
	 */
	public void collectionDel(final CollectionRequest req) throws Exception{
		collectionRespoitory.delect(req.getPoetryname(), req.getUsername());
	}

	/**
	 * 诗歌保存
	 * @param poetry
	 */
	public int savePoetry(final Poetry poetry) {
		return poetryRepository.save(poetry);
	}

	/**
	 * 检索全件
	 * @return
	 */
	public List<Poetry> getPoetryAll() {
		List<Poetry> list = poetryRepository.findAll();
		return list;
	}

	/**
	 * 删除诗集
	 * @param poetry
	 * @return
	 */
	public int delPoetry(final Poetry poetry) {
		return poetryRepository.delete(poetry.getPoetryname(), poetry.getAuth());
	}

	/**
	 * 修改诗歌
	 * @param poetry
	 */
	public void editPoetry(Poetry poetry) {
		poetryRepository.edit(poetry);
	}

	/**
	 * 检索全件名句
	 * @return
	 */
	public List<Famous> getFamousAll() {
		return poetryRepository.getFamousAll();
	}

	/**
	 * 检索名句(诗名)
	 * @return
	 */
	public List<Famous> getFamousPoetryName(String keyword) {
		return poetryRepository.getFamousPoetryName(keyword);
	}

	/**
	 * 检索名句(朝代)
	 * @return
	 */
	public List<Famous> getFamousDynasty(String keyword) {
		return poetryRepository.getFamousDynasty(keyword);
	}

	/**
	 * 检索名句(内容)
	 * @return
	 */
	public List<Famous> getFamousContent(String keyword) {
		return poetryRepository.getFamousContent(keyword);
	}

	/**
	 * 检索名句(作者)
	 * @return
	 */
	public List<Famous> getFamousAuth(String keyword) {
		return poetryRepository.getFamousAuth(keyword);
	}

	/**
	 * 检索作者)
	 * @param keyword
	 * @return
	 */
	public List<Poetry> authSaveSearch(String keyword) {
		return poetryRepository.authSaveSearch(keyword);
	}
}
