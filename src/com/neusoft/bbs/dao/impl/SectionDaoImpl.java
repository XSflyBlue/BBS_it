package com.neusoft.bbs.dao.impl;

import java.util.List;

import com.neusoft.bbs.commons.util.db.BeanHandler;
import com.neusoft.bbs.commons.util.db.BeanListHandler;
import com.neusoft.bbs.commons.util.db.DatabaseUtil;
import com.neusoft.bbs.dao.SectionDao;
import com.neusoft.bbs.domain.Section;
/**
 * 板块Dao实现类
 * @author yangmiao
 *
 */
public class SectionDaoImpl implements SectionDao{

	@Override
	public int insert(Section section) {
		int a = 0;
		String sql = "insert into b_section values(B_SECTION_ID_SEQ.nextval,?,?,?,?)";
		Object params[] = {section.getSectionName(),section.getIsShow(),section.getDistrictId(),section.getSectionDescri()};
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
		Object params[] = {section.getSectionId()};
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
		Object params[] = {section.getSectionName(),section.getIsShow(),section.getDistrictId(),
							section.getSectionDescri(),section.getSectionId()};
		try {
			a = DatabaseUtil.update(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public Section findByPostId(Long sectionId) {
		int a = 0;
		String sql = "select * from b_section where section_id=?";
		Object params[] = {sectionId};
		Section section = null;
		try {
			section = (Section)DatabaseUtil.query(sql, params, new BeanHandler(Section.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return section;
	}

	@Override
	public List<Section> findDistrictAll(Long districtId) {
		List<Section> list = null;
		String sql = "select * from b_section where district_id=?";
		Object params[] = {districtId};
		try {
			list = (List<Section>)DatabaseUtil.query(sql, params, new BeanListHandler(Section.class));
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
			list = (List<Section>)DatabaseUtil.query(sql, params, new BeanListHandler(Section.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
