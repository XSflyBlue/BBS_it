package com.neusoft.bbs.commons.struct;
/**
 * 通过返回消息
 * @author yangz
 *
 */
public class Msg {

	private int code;
	private String msg;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Msg(int code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}
	public Msg() {
	}
}
