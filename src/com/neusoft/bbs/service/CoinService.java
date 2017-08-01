package com.neusoft.bbs.service;

import java.util.List;

import com.neusoft.bbs.domain.Coin;
import com.neusoft.bbs.domain.CoinRecord;

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
	 * 根据用户id修改数据
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
	 * @param userId
	 * @param coinRecord
	 * @return
	 */
	public int setCoinNum(Long userId,Coin coin);
}
