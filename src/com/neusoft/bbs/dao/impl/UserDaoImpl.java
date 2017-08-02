package com.neusoft.bbs.dao.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.neusoft.bbs.commons.util.StringUtils;
import com.neusoft.bbs.commons.util.db.BeanHandler;
import com.neusoft.bbs.commons.util.db.DatabaseUtil;
import com.neusoft.bbs.dao.UserDao;
import com.neusoft.bbs.domain.UserBase;

/**
 * 用户DAO实现类
 * @author yangz
 *
 */
public class UserDaoImpl implements UserDao{

	@Override
	public UserBase findByLoginNameAndPassWord(String usernameOrEmail, String password) {
		String sql = "SELECT * FROM B_USER_BASE WHERE (USERNAME=? OR EMAIL=?) AND PASSWORD=?";
		Object params[] = {usernameOrEmail,usernameOrEmail,password};
		UserBase user = null;
		try {
			user = (UserBase) DatabaseUtil.query(sql,params,new BeanHandler(UserBase.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user ;
	}

	@Override
	public UserBase findByEmail(String email) {
		String sql = "SELECT * FROM B_USER_BASE WHERE EMAIL=?";
		Object params[] = {email};
		UserBase user = null;
		try {
			user = (UserBase) DatabaseUtil.query(sql,params,new BeanHandler(UserBase.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user ;
	}

	@Override
	public UserBase findById(Long id) {
		String sql = "SELECT * FROM B_USER_BASE WHERE USER_ID=?";
		Object params[] = {id};
		UserBase user = null;
		try {
			user = (UserBase) DatabaseUtil.query(sql,params,new BeanHandler(UserBase.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user ;
	}

	@Override
	public List<UserBase> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(UserBase userBase) {
		String sql = "INSERT INTO B_USER_BASE VALUES(B_USER_BASE_SEQ.nextval,?,?,?,?,?,?,?)";
		Object params[] = {
				userBase.getUsername(),
				userBase.getEmail(),
				userBase.getPassword(),
				new Date(userBase.getLastLoginTime().getTime()),
				userBase.getLastLoginIp(),
				userBase.getPower(),
				new Date(userBase.getRegistTime().getTime())
				};
		int result = 0;
		try {
			result = DatabaseUtil.update(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int update(UserBase userBase) {
		//UPDATE B_USER_BASE SET USERNAME='',EMAIL='',PASSWORD='',LAST_LOGIN_TIME='',LAST_LOGIN_IP='',POWER='',REGIST_TIME='';
		List<Object> arrList = new ArrayList<Object>();
		StringBuilder sqlBuilder = new StringBuilder("UPDATE B_USER_BASE SET ");
		String userName = userBase.getUsername();
		if(StringUtils.isNotNullString(userName)) {
			sqlBuilder.append("USERNAME=? ");
			arrList.add(userName);
		}
		String email = userBase.getEmail();
		if(StringUtils.isNotNullString(email)) {
			sqlBuilder.append("EMAIL=? ");
			arrList.add(email);
		}
		String password = userBase.getPassword();
		if(StringUtils.isNotNullString(password)) {
			sqlBuilder.append("PASSWORD=? ");
			arrList.add(password);
		}
		Date lastLoginTtime = new Date(userBase.getLastLoginTime().getTime());
		if(lastLoginTtime != null) {
			sqlBuilder.append("LAST_LOGIN_TIME=? ");
			arrList.add(lastLoginTtime);
		}
		String lastLoginIp = userBase.getLastLoginIp();
		if(StringUtils.isNotNullString(lastLoginIp)) {
			sqlBuilder.append("LAST_LOGIN_IP=? ");
			arrList.add(lastLoginIp);
		}
		short power = userBase.getPower();
		if(power != 0) {
			sqlBuilder.append("POWER=? ");
			arrList.add(power);
		}
		Date registTime = new Date(userBase.getRegistTime().getTime());
		if(registTime != null) {
			sqlBuilder.append("REGIST_TIME=?");
			arrList.add(registTime);
		}
		
		Object params[] = arrList.toArray();
		int result = 0;
		try {
			result = DatabaseUtil.update(sqlBuilder.toString(), params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int delete(UserBase userBase) {
		String sql = "DELETE FROM B_USER_BASE WHERE USER_ID=?";
		Object params[] = {userBase.getUserId()};
		int result = 0;
		try {
			result = DatabaseUtil.update(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int getListPageCount(int pageSize, UserBase userBase) {
		
		return 0;
	}

	@Override
	public int getListRowCount(UserBase userBase) {
		
		return 0;
	}

	@Override
	public List<UserBase> findUserBase(int pageSize, int rowNum, UserBase userBase) {
		
		return null;
	}

}
