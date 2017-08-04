package com.neusoft.bbs.domain.json;

import java.util.List;

import com.neusoft.bbs.domain.form.SectionForm;

public class SectionJson {
	private List<SectionForm> sectionFormList;
	private int maxPage;
	public List<SectionForm> getSectionFormList() {
		return sectionFormList;
	}
	public void setSectionFormList(List<SectionForm> sectionFormList) {
		this.sectionFormList = sectionFormList;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
}
