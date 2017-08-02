package com.neusoft.bbs.dao.impl;

import java.util.List;

import com.neusoft.bbs.commons.util.db.BeanHandler;
import com.neusoft.bbs.commons.util.db.BeanListHandler;
import com.neusoft.bbs.commons.util.db.DatabaseUtil;
import com.neusoft.bbs.dao.CoinDao;
import com.neusoft.bbs.domain.Coin;
import com.neusoft.bbs.domain.CoinRecord;

/**
 * 金币DAO操作实现类
 * @author yangmiao
 *
 */
public class CoinDaoImpl implements CoinDao{
	@Override
	public List<CoinRecord> findCoinRecordByCoinId(Long coinId) {
		String sql = "select coin_cause,coin_get_num,coin_get_time from b_coin_record  where coin_id=?";
		Object params[] = {coinId};
		List<CoinRecord> coinRecordList = null;
		try {
			coinRecordList = (List<CoinRecord>)DatabaseUtil.query(sql, params, new BeanListHandler(CoinRecord.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return coinRecordList;
	}

	@Override
	public int deleteCoinRecord(Long userId) {
		String sql = "delete from b_coin_record a,b_coin b where b.coin_id = a.coin_id and user_id=?";
		Object params[] = {userId};
		int a = 0;
		try {
		    a = DatabaseUtil.update(sql, params);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;	
	}
	@Override
	public int insertCoinRecord(CoinRecord coinRecord) {
		String sql = "insert into b_coin_record(coin_record_id,"
				+ "coin_id,coin_cause,coin_get_num,coin_get_time) value(B_COIN_RECORD_ID_SEQ.nextval,?,?,?,sysdate) ";
		Object params[] = {coinRecord.getCoinId(),coinRecord.getCoinCause(),coinRecord.getCoinGetNum()};
		int a = 0;
		try {
			a = DatabaseUtil.update(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public int updateCoinRecord(CoinRecord coinRecord) {
		String sql = "update b_coin_record  set coin_cause=?,coin_get_num=?,coin_get_time=sysdate where coin_record_id=?";
		Object params[] = {coinRecord.getCoinCause(),coinRecord.getCoinGetNum(),coinRecord.getCoinRecordId()};
		int a = 0;
		try {
			a = DatabaseUtil.update(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public Coin findCoinNum(Long userId) {
		String sql = "select coin_num from b_coin where user_id=?";
		Object params[] = {userId};
		Coin coin = null;
		try {
			coin = (Coin)DatabaseUtil.query(sql, params, new BeanHandler(Coin.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return coin;
	}

	@Override
	public int updateCoinNum(Coin coin) {
		String sql = "update b_coin set coin_num = ? where user_id = ?";
		Object params[] = {coin.getUserId()};
		int a = 0;
		try {
			a = DatabaseUtil.update(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public CoinRecord findCoinRecord(Long coinId) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public CoinRecord findCoinRecord(Long coinId) {
//		String sql = "select * from b_coin_record where coin_id=?";
//		Connection con = null;
//		Object params[] = {coinId};
//		CoinRecord coinRecord = null;
//		try {
//			con = JdbcUtil_DBCP.getConnection();
//			coinRecord = (CoinRecord)DatabaseUtil.query(con, sql, params, new BeanHandler(CoinRecord.class));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return coinRecord;
//	}
}
