package com.neusoft.bbs.dao;

import java.util.List;

import com.neusoft.bbs.domain.EXP;
/**
 * 经验DAO接口
 * @author Tony
 *
 */
import com.neusoft.bbs.domain.ExpRecord;
public interface ExpDao {
	/**
	 * 通过userId查询EXP
	 * @param userId
	 * @return EXP
	 */
	EXP findExpById(Long user_Id);
	/**
	 * 更新EXP表
	 * @param exp
	 * @return
	 */
	int updateExp(EXP exp);
	/**
	 * 插入数据
	 * @param exp
	 * @return
	 */
	int insertExp(EXP exp);
	/**
	 * 根据userId插入经验记录
	 * @param expRecord
	 * @return
	 */
	int insertExpRecord(Long userId,ExpRecord expRecord);
	/**
	 * 根据userId更新经验记录
	 * @param expRecord
	 * @return
	 */
	int updateExpRecord(Long userId,ExpRecord expRecord); 
	/**
	 * 根据userId查找经验记录
	 * @param expRecord
	 * @return
	 */
	List<ExpRecord> findExpRecord(Long userId,ExpRecord expRecord);
	
}
