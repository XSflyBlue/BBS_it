package com.neusoft.bbs.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.neusoft.bbs.commons.util.db.BeanHandler;
import com.neusoft.bbs.commons.util.db.BeanListHandler;
import com.neusoft.bbs.commons.util.db.DatabaseUtil;
import com.neusoft.bbs.dao.SectionDao;
import com.neusoft.bbs.domain.Section;
import com.neusoft.bbs.domain.form.FollowForm;
import com.neusoft.bbs.domain.form.PageForm;
import com.neusoft.bbs.domain.form.SectionForm;

import oracle.net.aso.f;

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
		find_sql.append("SELECT count(*) ROW_COUNT");
		find_sql.append(" FROM B_SECTION");
		find_sql.append(" WHERE 1=1");
		Long id = null;
		String str = null;
		List<Object> arrList = new ArrayList<Object>();
		if (section != null) {
			// 参数确定
			if (section.getSectionId() != null) {
				// sectionId查询
				id = section.getSectionId();
				find_sql.append(" AND SECTION_ID=?");
				arrList.add(id);
			}
			if (section.getSectionName() != null) {
				// sectionName查询
				str = section.getSectionName();
				find_sql.append(" AND SECTION_NAME=?");
				arrList.add(str);
			}
			if (section.getIsShow() != null) {
				// isShow查询
				id = section.getIsShow().longValue();
				find_sql.append(" AND IS_SHOW=?");
				arrList.add(id);
			}
			if (section.getDistrictId() != null) {
				// districtId查询
				id = section.getDistrictId();
				find_sql.append(" AND DISTRICT_ID=?");
				arrList.add(id);
			}
		} 
		System.out.println(find_sql.toString());
		Object params[] = arrList.toArray();
		PageForm pageForm = null;
		try {
			pageForm = (PageForm) DatabaseUtil.query(find_sql.toString(), params, new BeanHandler(PageForm.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("in SectionDaoImpl :"+pageForm.getRowCount().intValue());
		return pageForm.getRowCount().intValue();
	}

	@Override
	public List<SectionForm> findFormList(int pageSize, int rowNum, Section section) {
		StringBuffer find_sql = new StringBuffer();
		find_sql.append(
				"SELECT S.SECTION_ID,S.SECTION_NAME,S.IS_SHOW,S.DISTRICT_ID,S.SECTION_DESCRI,COUNT (M.USER_ID) ADMIN_NUM");
		find_sql.append(" FROM B_SECTION S,B_MODERATOR M");
		find_sql.append(" WHERE 1=1");

		List<Object> arrList = new ArrayList<Object>();
		Long id = null;
		String str = null;
		if (section != null) {
			// section 不为空情况
			// 参数确定
			if (section.getSectionId() != null) {
				id = section.getSectionId();
				find_sql.append(" AND S.SECTION_ID = ?");
				find_sql.append(" AND M.MODERATOR_TYPE = 0");
				find_sql.append(" AND M.AREA_ID = S.SECTION_ID");
				arrList.add(id);
			}
			if (section.getSectionName() != null) {
				// sectionName查询
				str = section.getSectionName();
				find_sql.append(" AND SECTION_NAME=?");
				arrList.add(str);
			}
			if (section.getIsShow() != null) {
				// isShow查询
				id = section.getIsShow().longValue();
				find_sql.append(" AND IS_SHOW=?");
				arrList.add(id);
			}
			if (section.getDistrictId() != null) {
				// districtId查询
				id = section.getDistrictId();
				find_sql.append(" AND DISTRICT_ID=?");
				arrList.add(id);
			}
		} 

		find_sql.append(" GROUP BY S.SECTION_ID,SECTION_NAME,S.IS_SHOW,S.DISTRICT_ID,S.SECTION_DESCRI");

		// 分页SQL语句
		String sql = "select * from (select a1.*,rownum rn from (" + find_sql.toString() + ") a1 where rownum<="
				+ rowNum * pageSize + ") where rn>" + ((rowNum - 1) * pageSize);

		System.out.println("完整："+sql);
		Object params[] = arrList.toArray();
		System.out.println(Arrays.toString(params));
		List<SectionForm> sectionFormList = null;
		try {
			sectionFormList = (List<SectionForm>) DatabaseUtil.query(sql, params,
					new BeanListHandler(SectionForm.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sectionFormList;
	}

	@Override
	public Section findBySectionName(String sectionName) {
		Section section = null;
		String sql = "select * from b_section where section_name=?";
		Object params[] = { sectionName };
		try {
			section = (Section) DatabaseUtil.query(sql, params, new BeanHandler(Section.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return section;
	}

}
