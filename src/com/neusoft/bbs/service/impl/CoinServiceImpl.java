package com.neusoft.bbs.service.impl;

import java.util.List;

import com.neusoft.bbs.commons.util.db.TransactionProxy;
import com.neusoft.bbs.dao.CoinDao;
import com.neusoft.bbs.dao.impl.CoinDaoImpl;
import com.neusoft.bbs.domain.Coin;
import com.neusoft.bbs.domain.CoinRecord;
import com.neusoft.bbs.domain.form.CoinRecordForm;
import com.neusoft.bbs.service.CoinService;
/**
 * 金币service实现类
 * @author yangmiao
 *
 */
public class CoinServiceImpl implements CoinService{
	private static final TransactionProxy transactionProxy = new TransactionProxy();
	private static final CoinService  instance = (CoinService) transactionProxy.newProxyInstance(new CoinServiceImpl());
	/**
	 * 获取CoinService实例
	 * @return
	 */
	public static CoinService getInstance(){
		return instance;
	}
	/**
	 * 私有化构造方法
	 */
	private CoinServiceImpl(){}
	
	CoinDao coinDao = new CoinDaoImpl();
	
	@Override
	public List<CoinRecord> findCoinRecord(Coin coin) {
		List<CoinRecord> list = null;
		list= coinDao.findCoinRecordByCoinId(coin.getCoinId());
		return list;
	}

	@Override
	public int deleteCoinRecord(Long userId) {
		int record = 0;
		record = coinDao.deleteCoinRecord(userId);
		return record;
	}

	@Override
	public int addCoinRecord(Long userId,CoinRecord coinRecord) {
		Coin coin = null;
		int record = 0;
		coin = coinDao.findCoinNum(userId);
		
		if(coin!=null){
			coinRecord.setCoinId(coin.getCoinId());
			record = coinDao.insertCoinRecord(coinRecord);
		}else{
			return 0;
		}
		return record;
	}
	
	@Override
	public int setCoinRecord(Long userId,CoinRecord coinRecord) {
		int record = 0;
		Coin coin = null;
		coin = coinDao.findCoinNum(userId);
		if(coin!=null){
			coinRecord.setCoinId(coin.getCoinId());
			record = coinDao.updateCoinRecord(coinRecord);
			System.out.println("record:"+record);
		}
		System.out.println(coinRecord.getCoinCause()+"=== "+coinRecord.getCoinGetNum());
		return record;
	}
	@Override
	public Long findCoinNum(Long userId) {
		Coin coin = null; 
		Long coin_num = null;
		coin = coinDao.findCoinNum(userId);
		if(coin!=null){
			coin_num = coin.getCoinNum();
		}
		return coin_num;
	}
	@Override
	public int setCoinNum(Long userId,Coin coin) {
		int coinNum = 0;
		coin.setUserId(userId);
		coinNum = coinDao.updateCoinNum(coin);
		return coinNum;
	}
	@Override
	public int getListPageCount(int pageSize, Long userId) {
		int pageCount = 0;
		pageCount = coinDao.getListPageCount(pageSize, userId);
		return pageCount;
	}
	@Override
	public int getListRowCount(Long userId) {
		int rowCount = 0;
		rowCount = coinDao.getListRowCount(userId);
		return rowCount;
	}
	@Override
	public List<CoinRecordForm> findFormList(int pageSize, int rowNum, Long userId) {
		List<CoinRecordForm> coinRecordList = null;
		coinRecordList = coinDao.findFormList(pageSize, rowNum, userId);
		return coinRecordList;
	}
	@Override
	public int addCoin(Coin coin) {
		int a = 0;
		a = coinDao.insertCoin(coin);
		return a;
	}
}
