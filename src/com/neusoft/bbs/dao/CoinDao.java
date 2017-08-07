package com.neusoft.bbs.dao;

import java.util.List;

import com.neusoft.bbs.domain.Coin;
import com.neusoft.bbs.domain.CoinRecord;
import com.neusoft.bbs.domain.form.CoinRecordForm;

/**
 * 金币DAO接口
 * @author yangmiao
 *
 */
public interface CoinDao {
	
	/**
	 * 根据coinId查询金币记录
	 * @param coinId
	 * @return
	 */
	public List<CoinRecord> findCoinRecordByCoinId(Long coinId);
	
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
	public int insertCoinRecord(CoinRecord coinRecord);
	
	/**
	 * 插入金币
	 * @param coin
	 * @return
	 */
	public int insertCoin(Coin coin);
	/**
	 * 根据用户id修改数据
	 * @param userId
	 * @return
	 */
	public int updateCoinRecord(CoinRecord coinRecord);
	
	/**
	 * 获取每个用户的金币数
	 * @param userId
	 * @return
	 */
	public Coin findCoinNum(Long userId);
	
	/**
	 * 修改金币总数
	 * @param userId
	 * @return
	 */
	public int updateCoinNum(Coin coin);
	
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
