package com.neusoft.bbs.dao;

import java.util.List;

import com.neusoft.bbs.domain.Accessory;

/***
 * 附件Dao接口
 * @author flyblue
 *
 */
public interface AccessoryDao {
	/***
	 * 插入附件
	 * @param accessory
	 * @return int
	 */
	int insert(Accessory accessory);
	
	/**
	 * 删除附件
	 * @param accessory
	 * @return int
	 */
	int delete(Accessory accessory);
	
	/***
	 * 更新附件
	 * @param accessory
	 * @return int
	 */
	int update(Accessory accessory);

	/**
	 * 查询某postId存在的附件
	 * @param postId
	 * @return List<Accessory>
	 */
	List<Accessory> findByPostId(Long postId);
}
