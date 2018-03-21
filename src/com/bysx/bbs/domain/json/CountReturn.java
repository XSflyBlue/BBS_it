package com.bysx.bbs.domain.json;
/**
 * 统计与对象
 * @author yangz
 *
 */
public class CountReturn {

	private int count;
	private Object data;
	
	public CountReturn() {
	}
	public CountReturn(int count, Object data) {
		super();
		this.count = count;
		this.data = data;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
}
