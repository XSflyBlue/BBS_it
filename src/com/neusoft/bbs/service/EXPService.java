package com.neusoft.bbs.service;

import java.util.List;

import com.neusoft.bbs.domain.EXP;
import com.neusoft.bbs.domain.ExpRecord;
import com.neusoft.bbs.domain.form.ExpRecordForm;

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
	public List<ExpRecord> findEXPRecord(Long userId);
	/**
	 * 根据用户id和条件查询签到获得的经验记录
	 * @param userId
	 * @param expRecord
	 * @return
	 */
	public List<ExpRecord> findSignEXPRecord(Long userId,ExpRecord expRecord);
	/**
	 * 根据用户id删除经验记录
	 * @param userId
	 * @return int
	 */
	public int deleteExpRecord(Long userId);
	
	/**
	 * 插入Exp
	 * @param userId
	 * @return int
	 */
	public int insertExp(EXP exp);
	
	/**
	 * 根据用户id插入记录
	 * @param userId
	 * @return int
	 */
	public int addExpRecord(Long userId,ExpRecord expRecord);
	
	/**
	 * 根据用户id修改经验记录表
	 * @param userId
	 * @return int
	 */
	public int setExpRecord(Long userId,ExpRecord expRecord);
	
	/**
	 * 根据用户id查找经验值
	 * @param userId
	 * @return
	 */
	public Long findExpNum(Long userId);
	
	/**
	 * 根据用户id修改经验表
	 * （需要增加一条经验记录，调用setCoinRecord）
	 * @param userId
	 * @param exp
	 * @return int
	 */
	public int setExpNum(Long userId,EXP exp);
	
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
