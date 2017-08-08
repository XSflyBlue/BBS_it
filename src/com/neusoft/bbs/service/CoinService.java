package com.neusoft.bbs.service;

import java.util.List;

import com.neusoft.bbs.domain.Coin;
import com.neusoft.bbs.domain.CoinRecord;
import com.neusoft.bbs.domain.form.CoinRecordForm;

/**
 * 金币service接口类
 * @author yangmiao
 *
 */
public interface CoinService {
	/**
	 * 根据用户id查询金币记录
	 * @param userId
	 * @return
	 */
	public List<CoinRecord> findCoinRecord(Coin coin);
	
	/**
	 * 根据用户id删除金币记录
	 * @param userId
	 * @return
	 */
	public int deleteCoinRecord(Long userId);
	
	/**
	 * 根据用户id插入记录
	 * @param userId
	 * @return
	 */
	public int addCoinRecord(Long userId,CoinRecord coinRecord);
	
	/**
	 * 根据用户id修改金币记录
	 * @param userId
	 * @return
	 */
	public int setCoinRecord(Long userId,CoinRecord coinRecord);
	
	/**
	 * 根据用户id获取金币总数
	 * @param userId
	 * @return
	 */
	public Long findCoinNum(Long userId);
	
	/**
	 * 根据用户id修改金币总数
	 * （需要增加一条经验记录，调用setCoinRecord）
	 * @param userId
	 * @param coinRecord
	 * @return
	 */
	public int setCoinNum(Long userId,Coin coin);
	/**
	 * 金币类插入
	 * @param coin
	 * @return
	 */
	public int addCoin(Coin coin);
	
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
	 * 查找金币记录
	 * @param pageSize，每页显示信息条数
	 * @param rowNum，需要获取的页数
	 * @param userId，查询条件（userId）
	 * @return
	 */
	List<CoinRecordForm> findFormList(int pageSize, int rowNum, Long userId);
}
