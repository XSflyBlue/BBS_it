package com.neusoft.bbs.dao;

import java.util.List;

import com.neusoft.bbs.domain.Coin;
import com.neusoft.bbs.domain.CoinRecord;

/**
 * 金币DAO接口
 * @author yangmiao
 *
 */
public interface CoinDao {
	
	
	/**
	 * 根据用户id查询金币记录
	 * @param userId
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
	/**
	 * 根据coinId查出所有金币记录
	 * @param coinId
	 * @return
	 */
	public CoinRecord findCoinRecord(Long coinId);
}
