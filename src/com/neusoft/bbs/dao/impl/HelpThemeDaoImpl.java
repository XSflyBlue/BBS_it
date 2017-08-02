package com.neusoft.bbs.dao.impl;

import java.util.List;

import com.neusoft.bbs.commons.util.db.BeanHandler;
import com.neusoft.bbs.commons.util.db.BeanListHandler;
import com.neusoft.bbs.commons.util.db.DatabaseUtil;
import com.neusoft.bbs.dao.HelpThemeDao;
import com.neusoft.bbs.domain.HelpTheme;
/**
 * 帮助主题实现类
 * @author yangmiao
 *
 */
public class HelpThemeDaoImpl implements HelpThemeDao{

	@Override
	public int insert(HelpTheme helpTheme) {
		int a = 0;
		String sql = "insert into b_help_theme values(B_HELP_THEME_ID_SEQ.nextval,?,?,?)";
		Object params[] = {helpTheme.getHelpThemeName(),helpTheme.getHelpThemeId(),helpTheme.getHelpContent()};
		try {
			a = DatabaseUtil.update(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public int delete(HelpTheme helpTheme) {
		int a = 0;
		String sql = "delete from b_help_theme where help_theme_id = ?";
		Object params[] = {helpTheme.getHelpThemeId()};
		try {
			a = DatabaseUtil.update(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public int update(HelpTheme helpTheme) {
		int a = 0;
		String sql = "update b_help_theme set help_theme_name=?,help_type_id=?,help_content=? where help_theme_id=?";
		Object params[] = {helpTheme.getHelpThemeName(),helpTheme.getHrlpTypeId(),helpTheme.getHelpContent(),helpTheme.getHelpThemeId()};
		try {
			a = DatabaseUtil.update(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public List<HelpTheme> findByHelpTypeId(Long helpTypeId) {
		String sql = "select * from b_help_theme where help_type_id=?";
		Object params[] = {helpTypeId};
		List<HelpTheme> list = null;
		try {
			list = (List<HelpTheme>)DatabaseUtil.query(sql, params, new BeanListHandler(HelpTheme.class));	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public HelpTheme findByHelpThemeId(Long helpThemeId) {
		String sql = "select * from b_help_theme where help_theme_id=?";
		Object params[] = {helpThemeId};
		HelpTheme helpTheme = null;
		try {
			helpTheme = (HelpTheme)DatabaseUtil.query(sql, params, new BeanHandler(HelpTheme.class));	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return helpTheme;
	}

	@Override
	public List<HelpTheme> findAll() {
		String sql = "select * from b_help_theme ";
		Object params[] = {};
		List<HelpTheme> list = null;
		try {
			list = (List<HelpTheme>)DatabaseUtil.query(sql, params, new BeanListHandler(HelpTheme.class));	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
