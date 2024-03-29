package com.bysx.bbs.dao;

import java.util.List;

import com.bysx.bbs.domain.EXP;
import com.bysx.bbs.domain.ExpRecord;
import com.bysx.bbs.domain.form.ExpRecordForm;

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
	EXP findExpById(Long userId);
	
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
	
	/**
	 * 根据条件查询用户今日的经验记录
	 * @param userId
	 * @param expRecord
	 * @return
	 */
	List<ExpRecord> findSignExpRecord(Long userId,ExpRecord expRecord);
	
	/***
	 * 获取最大页数
	 * @param pageSize，每页显示信息条数
	 * @param userId，查询条件
	 * @return
	 */
	int getListPageCount(int pageSize, Long userId);

	/***
	 * 获取最大行数
	 * @param userId，查询条件（userId查）
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
	List<ExpRecordForm> findFormList(int pageSize, int rowNum, Long userId);
}
