package com.neusoft.bbs.service;

import java.util.List;

import com.neusoft.bbs.domain.EXP;
import com.neusoft.bbs.domain.ExpRecord;

/***
 * 经验service接口
 * @author flyblue
 *
 */
public interface EXPService {
	/**
	 * 根据用户id查询经验记录
	 * @param userId
	 * @return 
	 */
	public List<ExpRecord> findEXPRecord(String userId);
	
	/**
	 * 根据用户id删除经验记录
	 * @param userId
	 * @return int
	 */
	public int deleteCoinRecord(Long userId);
	
	/**
	 * 根据用户id插入记录
	 * @param userId
	 * @return int
	 */
	public int addCoinRecord(Long userId,ExpRecord expRecord);
	
	/**
	 * 根据用户id修改经验记录表
	 * @param userId
	 * @return int
	 */
	public int setCoinRecord(Long userId,ExpRecord expRecord);
	
	/**
	 * 根据用户id查找经验值
	 * @param userId
	 * @return
	 */
	public Long findCoinNum(Long userId);
	
	/**
	 * 根据用户id修改经验表
	 * （需要增加一条经验记录，调用setCoinRecord）
	 * @param userId
	 * @param exp
	 * @return int
	 */
	public int setCoinNum(Long userId,EXP exp);
}
