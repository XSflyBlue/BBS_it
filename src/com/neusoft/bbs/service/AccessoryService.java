package com.neusoft.bbs.service;

import java.util.List;

import com.neusoft.bbs.domain.Accessory;

/**
 * 附件service接口
 * @author flyblue
 *
 */
public interface AccessoryService {
	/***
	 * 插入附件
	 * @param accessory
	 * @return int
	 */
	int addAccessory(Accessory accessory);
	
	/**
	 * 删除附件
	 * @param accessory
	 * @return int
	 */
	int deleteAccessory(Accessory accessory);
	
	/***
	 * 更新附件
	 * @param accessory
	 * @return int
	 */
	int setAccessory(Accessory accessory);

	/**
	 * 查询某postId存在的附件
	 * @param postId
	 * @return List<Accessory>
	 */
	List<Accessory> findAccessory(Long postId);
}
