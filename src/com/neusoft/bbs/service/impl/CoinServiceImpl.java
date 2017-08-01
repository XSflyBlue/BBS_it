package com.neusoft.bbs.service.impl;

import java.util.List;

import com.neusoft.bbs.commons.util.db.TransactionProxy;
import com.neusoft.bbs.dao.CoinDao;
import com.neusoft.bbs.dao.impl.CoinDaoImpl;
import com.neusoft.bbs.domain.Coin;
import com.neusoft.bbs.domain.CoinRecord;
import com.neusoft.bbs.service.CoinService;
/**
 * 金币service实现类
 * @author yangmiao
 *
 */
public class CoinServiceImpl implements CoinService{
	private static final TransactionProxy transactionProxy = new TransactionProxy();
	private static final CoinService  instance = (CoinService) transactionProxy.newProxyInstance(new CoinDaoImpl());
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
		List<CoinRecord> list = coinDao.findCoinRecordByCoinId(coin.getCoinId());
		if(list!=null&&list.size()>0){
			return list;
		}else{
			return null;
		}
	}

	@Override
	public int deleteCoinRecord(Long userId) {
		int record = coinDao.deleteCoinRecord(userId);
		return record;
	}

	@Override
	public int addCoinRecord(Long userId,CoinRecord coinRecord) {
		
		Coin coin = coinDao.findCoinNum(userId);
		coinRecord.setCoinId(coin.getCoinId());
		int record = coinDao.insertCoinRecord(coinRecord);
		return record;
	}

	@Override
	public int setCoinRecord(Long userId,CoinRecord coinRecord) {
		Coin coin = coinDao.findCoinNum(userId);
		coinRecord.setCoinId(coin.getCoinId());
		int record = coinDao.updateCoinRecord(coinRecord);
		return record;
	}
	@Override
	public Long findCoinNum(Long userId) {
		Coin coin = coinDao.findCoinNum(userId);
		Long coin_num = coin.getCoinNum();
		return coin_num;
	}
	@Override
	public int setCoinNum(Long userId,Coin coin) {
		int coinNum = 0;
		if(coin!=null){
			coin.setUserId(userId);
			coinNum = coinDao.updateCoinNum(coin);
		}
		return coinNum;
	}
	
	
}
