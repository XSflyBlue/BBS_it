package com.neusoft.bbs.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neusoft.bbs.commons.util.db.BeanHandler;
import com.neusoft.bbs.commons.util.db.BeanListHandler;
import com.neusoft.bbs.commons.util.db.DatabaseUtil;
import com.neusoft.bbs.dao.CoinDao;
import com.neusoft.bbs.domain.Coin;
import com.neusoft.bbs.domain.CoinRecord;
import com.neusoft.bbs.domain.form.CoinRecordForm;
import com.neusoft.bbs.domain.form.FollowForm;
import com.neusoft.bbs.domain.form.PageForm;

/**
 * 金币DAO操作实现类
 * @author yangmiao
 *
 */
public class CoinDaoImpl implements CoinDao{
	@Override
	public List<CoinRecord> findCoinRecordByCoinId(Long userId,CoinRecord record) {
		StringBuffer sql = new StringBuffer("SELECT R.* FROM B_COIN_RECORD R,B_COIN C WHERE 1=1 ");
		List<Object> list = new ArrayList<Object>();
		if(userId!=null){
			sql.append("and r.coin_id = c.coin_id ");
			sql.append("and c.user_id =? ");
			list.add(userId);
		}else{
			return null;
		}
		if(record!=null){
			if(record.getCoinCause()!=null){
				sql.append("and r.coin_cause like '%"+record.getCoinCause().trim()+"%'");
			}
		}
		sql.append(" order by r.coin_get_time desc");
//		System.out.println("金币记录:sql:"+sql);
		Object params[] = list.toArray();
		List<CoinRecord> coinRecordList = null;
		try {
			coinRecordList = (List<CoinRecord>)DatabaseUtil.query(sql.toString(), params, new BeanListHandler(CoinRecord.class));
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
				+ "coin_id,coin_cause,coin_get_num,coin_get_time) values(B_COIN_RECORD_ID_SEQ.nextval,?,?,?,sysdate) ";
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
		String sql = "update b_coin_record  set coin_cause=?,coin_get_num=?,coin_get_time=sysdate where coin_id=?";
		Object params[] = {coinRecord.getCoinCause(),coinRecord.getCoinGetNum(),coinRecord.getCoinId()};
		int a = 0;
		try {
			a = DatabaseUtil.update(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}
	
//	@Override
//	public Coin findCoinNum(Long userId) {
//		String sql = "select c.COIN_ID,c.USER_ID,sum(r.coin_get_num) COIN_NUM "
//				+ "from b_coin c,b_user_base b,b_coin_record r "
//				+ "where c.user_id = b.user_id  and c.coin_id = r.coin_id "
//				+ "and b.user_id=? "
//				+ "group by c.coin_id,c.user_id";
//		Object params[] = {userId};
//		System.out.println("sql："+sql);
//		Coin coin = null;
//		try {
//			coin = (Coin)DatabaseUtil.query(sql, params, new BeanHandler(Coin.class));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return coin;
//	}

	@Override
	public int updateCoinNum(Coin coin) {
		String sql = "update b_coin set coin_num = ? where user_id = ?";
		Object params[] = {coin.getCoinNum(),coin.getUserId()};
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
			find_sql.append("from b_coin a,b_coin_record b,b_user_base c ");
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
	public List<CoinRecordForm> findFormList(int pageSize, int rowNum, Long userId) {
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
	
//			System.out.println(sql);
			Object params[] = {userId};
			List<CoinRecordForm> coinRecordFormList = null;
			try {
				coinRecordFormList = (List<CoinRecordForm>) DatabaseUtil.query(sql, params, new BeanListHandler(CoinRecordForm.class));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return coinRecordFormList;
	}

	@Override
	public int insertCoin(Coin coin) {
		String sql = "insert into b_coin(user_id,coin_id,coin_num)"
				+ "values(?,B_COIN_RECORD_ID_SEQ.nextval,?) ";
		Object params[] = {coin.getUserId(), coin.getCoinNum()};
		int result = 0;
		try {
			result = DatabaseUtil.update(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Coin findCoinByUserId(Long userId) {
		String sql = "select * from b_coin where user_id=?";
		Object params[] = {userId};
		Coin coin = null;
		try {
			coin = (Coin)DatabaseUtil.query(sql, params, new BeanHandler(Coin.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return coin;
	}
}
