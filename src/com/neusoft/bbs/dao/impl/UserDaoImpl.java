package com.neusoft.bbs.dao.impl;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neusoft.bbs.commons.util.StringUtils;
import com.neusoft.bbs.commons.util.db.BeanHandler;
import com.neusoft.bbs.commons.util.db.BeanListHandler;
import com.neusoft.bbs.commons.util.db.DatabaseUtil;
import com.neusoft.bbs.dao.UserDao;
import com.neusoft.bbs.domain.UserBase;
import com.neusoft.bbs.domain.form.PageForm;

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
		java.util.Date uDate = userBase.getLastLoginTime();
		if(uDate != null) {
			Date lastLoginTtime = new Date(uDate .getTime());
			sqlBuilder.append("LAST_LOGIN_TIME=? ");
			arrList.add(lastLoginTtime);
		}
		String lastLoginIp = userBase.getLastLoginIp();
		if(StringUtils.isNotNullString(lastLoginIp)) {
			sqlBuilder.append("LAST_LOGIN_IP=? ");
			arrList.add(lastLoginIp);
		}
		Short power = userBase.getPower();
		if(power != null) {
			sqlBuilder.append("POWER=? ");
			arrList.add(power);
		}
		java.util.Date rDate = userBase.getRegistTime();
		if(rDate != null) {
			Date registTime = new Date(rDate .getTime());
			sqlBuilder.append("REGIST_TIME=?");
			arrList.add(registTime);
		}
		
		sqlBuilder.append(" WHERE USER_ID = ?");
		arrList.add(userBase.getUserId());
		System.out.println(sqlBuilder.toString());
		System.out.println(arrList);
		
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
        int res = 0;
		
		int rowCount = getListRowCount(userBase);
		if (rowCount%pageSize==0) {
			res = rowCount / pageSize;
		} else {
			res = rowCount / pageSize + 1;
		}
		
		return res;
	}

	@Override
	public int getListRowCount(UserBase userBase) {
		// SQL语句

		StringBuffer find_sql = new StringBuffer();
		find_sql.append("SELECT count(*) ROW_COUNT  ");
		find_sql.append("FROM B_USER_BASE ");
		find_sql.append("WHERE 1=1 ");
		Long id = null;
		String str = null;
		List<Object> arrList = new ArrayList<Object>();

		// 参数确定
		if (userBase.getUserId() != null) {
			id = userBase.getUserId();
			arrList.add(id);

			find_sql.append("AND USER_ID = ? ");

		} 
		if (userBase.getUsername() != null) {
			str = userBase.getUsername();

			find_sql.append("AND USERNAME LIKE '%"+ str +"%' ");
		} 
		if (userBase.getPower() != null) {
			id = userBase.getPower().longValue();
			arrList.add(id);
			
			find_sql.append("AND POWER = ? ");
		}

		// System.out.println(find_sql.toString());
		Object params[] = arrList.toArray();
		PageForm pageForm = null;
		try {
			pageForm = (PageForm) DatabaseUtil.query(find_sql.toString(), params, new BeanHandler(PageForm.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pageForm.getRowCount().intValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserBase> findFormList(int pageSize, int rowNum, UserBase userBase) {
		StringBuffer find_sql = new StringBuffer();
		find_sql.append("SELECT * ");
		find_sql.append("FROM B_USER_BASE ");
		find_sql.append("WHERE 1=1 ");
		Long id = null;
		String str = null;
		List<Object> arrList = new ArrayList<Object>();
		
		// 参数确定
		if (userBase.getUserId() != null) {
			id = userBase.getUserId();
			arrList.add(id);

			find_sql.append("AND USER_ID = ? ");

		} 
		if (userBase.getUsername() != null) {
			str = userBase.getUsername();

			find_sql.append("AND USERNAME LIKE '%"+ str +"%' ");
		} 
		if (userBase.getPower() != null) {
			id = userBase.getPower().longValue();
			arrList.add(id);
			
			find_sql.append("AND POWER = ? ");
		}
		// 分页SQL语句
		String sql = "select*from (select a1.*,rownum rn from (" + find_sql.toString() + ") a1 where rownum<="
				+ rowNum * pageSize + ") where rn>" + ((rowNum - 1) * pageSize);

		System.out.println(sql);
		
		Object params[] = arrList.toArray();
		List<UserBase> userBaseList = null;
		try {
			userBaseList = (List<UserBase>) DatabaseUtil.query(sql, params, new BeanListHandler(UserBase.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userBaseList;
	}

}
