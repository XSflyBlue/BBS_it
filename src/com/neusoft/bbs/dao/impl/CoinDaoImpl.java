package com.neusoft.bbs.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.neusoft.bbs.commons.util.db.BeanHandler;
import com.neusoft.bbs.commons.util.db.BeanListHandler;
import com.neusoft.bbs.commons.util.db.DatabaseUtil;
import com.neusoft.bbs.dao.CoinDao;
import com.neusoft.bbs.domain.Coin;
import com.neusoft.bbs.domain.CoinRecord;
import com.neusoft.bbs.domain.form.FollowForm;
import com.neusoft.bbs.domain.form.PageForm;

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
	public int getListPageCount(int pageSize, Long userId) {
		int res = 0;
		
		int rowCount = getListRowCount(userId);
		if (rowCount%pageSize==0) {
			res = rowCount / pageSize;
		} else {
			res = rowCount / pageSize + 1;
		}
		
		return res;
	}

	@Override
	public int getListRowCount(Long userId) {
		StringBuffer find_sql = new StringBuffer();
		find_sql.append("SELECT count(*) ROW_COUNT  ");
		Long id = null;
		if(userId!=null){
			id = userId;
			find_sql.append("from b_coin a,b_coin_record b,b_user base c ");
			find_sql.append("where a.user_id = c.user_id and a.coin_id = b.coin_id ");
			find_sql.append("and c.user_id=? ");
		}else{
			return 0;
		}
		Object params[] = {id};
		PageForm pageForm = null;
		try {
			pageForm = (PageForm) DatabaseUtil.query(find_sql.toString(), params, new BeanHandler(PageForm.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pageForm.getRowCount().intValue();
	}

	@Override
	public List<CoinRecord> findFormList(int pageSize, int rowNum, Long userId) {
		StringBuffer find_sql = new StringBuffer();
		Long id = null;
		//参数确定
		if(userId!=null){
			find_sql.append("select b.coin_record_id,a.coin_id,b.coin_cause,b.coin_get_num,b.coin_get_time ");
			find_sql.append("from b_coin a,b_coin_record b,b_user_base c ");
			find_sql.append("where a.user_id = c.user_id and a.coin_id = b.coin_id ");
			find_sql.append("and c.user_id=? ");
			find_sql.append("order by b.coin_get_time desc");
		}else {
			return null;
		}
		// 分页SQL语句
			String sql = "select*from (select a1.*,rownum rn from (" + find_sql.toString() + ") a1 where rownum<="
					+ rowNum * pageSize + ") where rn>" + ((rowNum - 1) * pageSize);
	
			System.out.println(sql);
			Object params[] = {id};
			List<CoinRecord> coinRecordList = null;
			try {
				coinRecordList = (List<CoinRecord>) DatabaseUtil.query(sql, params, new BeanListHandler(CoinRecord.class));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return coinRecordList;
	}
}
