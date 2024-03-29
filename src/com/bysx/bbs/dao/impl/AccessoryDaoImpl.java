package com.bysx.bbs.dao.impl;

import java.sql.Connection;
import java.util.List;

import com.bysx.bbs.commons.util.db.BeanListHandler;
import com.bysx.bbs.commons.util.db.DatabaseUtil;
import com.bysx.bbs.commons.util.db.JdbcUtil_DBCP;
import com.bysx.bbs.dao.AccessoryDao;
import com.bysx.bbs.domain.Accessory;

/**
 * 插件操作实现类
 * @author yangmiao
 *
 */
public class AccessoryDaoImpl implements AccessoryDao{

	@Override
	public int insert(Accessory accessory) {
		String sql = "insert into b_accessory values(B_ACCESSORY_ID_SEQ.nextval,?,?,?,?,sysdate,?,?,?,?)";
		int a = 0;
		Object params[] = {accessory.getPostId(),accessory.getFileName(),accessory.getPath(),accessory.getAuthor(),
							accessory.getAccessoryDescri(),accessory.getFileSize(),accessory.getDownloadNum(),accessory.getCostCoin()};
		try {
			a = DatabaseUtil.update(sql, params);
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		return a;
	}

	@Override
	public int delete(Accessory accessory) {
		int a = 0;
		String sql = "delete from b_accessory where accessory_id=?";
		Object params[] = {accessory.getAccessoryId()};
		try {
			a = DatabaseUtil.update(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public int update(Accessory accessory) {
		int a = 0;
		String sql = "update b_accessory set post_id=?,file_name=?,path=?,author=?,upload_time=sysdate,accessory_descri=?"
				+ "	,file_size=?,download_num=?,cost_coin=? where accessory_id=?";
		Object params[] = {accessory.getFileName(),accessory.getPath(),accessory.getAuthor(),accessory.getAccessoryDescri(),
							accessory.getFileSize(),accessory.getDownloadNum(),accessory.getCostCoin(),accessory.getAccessoryId()};
		try {
			a = DatabaseUtil.update(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public List<Accessory> findByPostId(Long postId) {
		String sql = "select * from b_accessory where post_id=?";
		Object params[] = {postId};
		List<Accessory> list = null;
		try {
			 list= (List<Accessory>)DatabaseUtil.query(sql, params, new BeanListHandler(Accessory.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
