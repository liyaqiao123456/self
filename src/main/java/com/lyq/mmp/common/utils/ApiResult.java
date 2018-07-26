package com.lyq.mmp.common.utils;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
*   
* 项目名称：cjhsc-service  
* 类名称：com.cjhsc.util.ApiResult
* @author：chenxh  
* 创建时间：2017年12月15日 下午12:39:29
* 描述：
*
 */
@ApiModel(description="接口数据")
public class ApiResult<T> {
	@ApiModelProperty(value = "状态码",name="code", required = true,example="0")
	@JSONField(name="code")
	private int code;
	
	@JSONField(name="message")
	@ApiModelProperty(value = "描述信息",name="message", required = true,example="成功")
	private String message="";
	
	@JSONField(name="data")
	@ApiModelProperty(value = "接口数据",name="data", required = true)
	private T data;
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
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}	
}
