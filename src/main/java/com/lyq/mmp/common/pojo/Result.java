package com.lyq.mmp.common.pojo;

/**
 * 封装返回数据
 * @author czh
 * @2015年5月20日
 */
public class Result {

	private int code = 1;
	private String message = "操作成功";
	private Object data;
	
	public Result(int code, String message, Object data){
		this.code = code;
		this.message = message;
		this.data = data;
	}
	
	public Result(int code, String message){
		this.code = code;
		this.message = message;
	}
	
	public Result(Object data){
		this.message = "查询成功";
		this.data = data;
	}
	
	public Result(int code){
		this.code = code;
		this.message = "操作失败";
	}
	
	public Result(String message){
		this.code = 0;
		this.message = message;
	}
	
	public Result(){
		
	}


	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "AjaxResult{" +
				"code=" + code +
				", message='" + message + '\'' +
				", data=" + data +
				'}';
	}
}
