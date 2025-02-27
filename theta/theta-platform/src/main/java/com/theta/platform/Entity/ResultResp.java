package com.theta.platform.Entity;

public class ResultResp {
	public final static int FAIL = -1;   //通用错误
	public final static int SUCCESS = 0;    //成功
	public final static String SUCCESSMSG = "success";
	public final static String FAILMSG = "fail";
	private int code;
	private String msg;
	private Object data;
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
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
}
