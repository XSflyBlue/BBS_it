package com.neusoft.bbs.dao;

import java.util.List;

import com.neusoft.bbs.domain.EXP;
import com.neusoft.bbs.domain.ExpRecord;

/**
 * 经验DAO接口
 * @author Tony
 *
 */
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
	
	/***
	 * 获取最大页数
	 * @param pageSize，每页显示信息条数
	 * @param userId，查询条件
	 * @return
	 */
	int getListPageCount(int pageSize, Long userId);

	/***
	 * 获取最大行数
	 * @param userId，查询条件（帖子postId查和跟帖用户commentUserId查）
	 * @return
	 */
	int getListRowCount(Long userId);
	
	/***
	 * 查找经验记录
	 * @param pageSize，每页显示信息条数
	 * @param rowNum，需要获取的页数
	 * @param userId，查询条件（userId）
	 * @return
	 */
	List<ExpRecord> findFormList(int pageSize, int rowNum, Long userId);
}
