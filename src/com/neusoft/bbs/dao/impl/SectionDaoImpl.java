package com.neusoft.bbs.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.neusoft.bbs.commons.util.db.BeanHandler;
import com.neusoft.bbs.commons.util.db.BeanListHandler;
import com.neusoft.bbs.commons.util.db.DatabaseUtil;
import com.neusoft.bbs.dao.SectionDao;
import com.neusoft.bbs.domain.Section;
import com.neusoft.bbs.domain.form.FollowForm;
import com.neusoft.bbs.domain.form.PageForm;
import com.neusoft.bbs.domain.form.SectionForm;

/**
 * 板块Dao实现类
 * 
 * @author yangmiao
 *
 */
public class SectionDaoImpl implements SectionDao {

	@Override
	public int insert(Section section) {
		int a = 0;
		String sql = "insert into b_section values(B_SECTION_ID_SEQ.nextval,?,?,?,?)";
		Object params[] = { section.getSectionName(), section.getIsShow(), section.getDistrictId(),
				section.getSectionDescri() };
		try {
			a = DatabaseUtil.update(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public int delete(Section section) {
		int a = 0;
		String sql = "delete from b_section where section_id=?";
		Object params[] = { section.getSectionId() };
		try {
			a = DatabaseUtil.update(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public int update(Section section) {
		int a = 0;
		String sql = "update b_section set section_name=?,is_show=?,district_id=?,section_descri=? where section_id=?";
		Object params[] = { section.getSectionName(), section.getIsShow(), section.getDistrictId(),
				section.getSectionDescri(), section.getSectionId() };
		try {
			a = DatabaseUtil.update(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public Section findBySectionId(Long sectionId) {
		int a = 0;
		String sql = "select * from b_section where section_id=?";
		Object params[] = { sectionId };
		Section section = null;
		try {
			section = (Section) DatabaseUtil.query(sql, params, new BeanHandler(Section.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return section;
	}

	@Override
	public List<Section> findDistrictAll(Long districtId) {
		List<Section> list = null;
		String sql = "select * from b_section where district_id=?";
		Object params[] = { districtId };
		try {
			list = (List<Section>) DatabaseUtil.query(sql, params, new BeanListHandler(Section.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Section> findAll() {
		List<Section> list = null;
		String sql = "select * from b_section ";
		Object params[] = {};
		try {
			list = (List<Section>) DatabaseUtil.query(sql, params, new BeanListHandler(Section.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int getListPageCount(int pageSize, Section section) {
		int res = 0;
		int rowCount = getListRowCount(section);
		if (rowCount % pageSize == 0) {
			res = rowCount / pageSize;
		} else {
			res = rowCount / pageSize + 1;
		}
		return res;
	}

	@Override
	public int getListRowCount(Section section) {
		StringBuffer find_sql = new StringBuffer();
		find_sql.append("SELECT count(*) ROW_COUNT ");
		Long id = null;
		// 参数确定
		if (section.getSectionId() != null) {
			id = section.getSectionId();
			find_sql.append("FROM B_SECTION ");
			find_sql.append("WHERE SECTION_ID=?");
		} else {
			return 0;
		}
		Object params[] = { id };
		PageForm pageForm = null;
		try {
			pageForm = (PageForm) DatabaseUtil.query(find_sql.toString(), params, new BeanHandler(PageForm.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pageForm.getRowCount().intValue();
	}

	@Override
	public List<SectionForm> findFormList(int pageSize, int rowNum, Section section) {
		StringBuffer find_sql = new StringBuffer();
		Long id = null;
		// 参数确定
		if (section.getSectionId() != null) {
			id = section.getSectionId();
			find_sql.append(
					"SELECT S.SECTION_ID,S.SECTION_NAME,S.IS_SHOW,S.DISTRICT_ID,S.SECTION_DESCRI,COUNT (M.USER_ID) ADMIN_NUM");
			find_sql.append(" FROM B_SECTION S,B_MODERATOR M");
			find_sql.append(" WHERE S.SECTION_ID = ?");
			find_sql.append(" AND M .MODERATOR_TYPE = 0");
			find_sql.append(" AND M .AREA_ID = S.SECTION_ID");
			find_sql.append(" GROUP BY S.SECTION_ID,SECTION_NAME,S.IS_SHOW,S.DISTRICT_ID,S.SECTION_DESCRI;");
		} else {
			return null;
		}
		// 分页SQL语句
		String sql = "select*from (select a1.*,rownum rn from (" + find_sql.toString() + ") a1 where rownum<="
				+ rowNum * pageSize + ") where rn>" + ((rowNum - 1) * pageSize);

		System.out.println(sql);
		Object params[] = { id };
		List<SectionForm> sectionFormList = null;
		try {
			sectionFormList = (List<SectionForm>) DatabaseUtil.query(sql, params, new BeanListHandler(FollowForm.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sectionFormList;
	}

	@Override
	public Section findBySectionName(String sectionName) {
		// TODO Auto-generated method stub
		return null;
	}

}
