package com.lyq.mmp.controller;

import com.lyq.mmp.common.pojo.Result;
import com.lyq.mmp.common.pojo.PageUtil;
import com.lyq.mmp.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lyq.mmp.service.TestService;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "测试接口列表", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class TestController {

	@Autowired
	private TestService userService;
	
	@ApiOperation(value = "验证码", httpMethod = "GET", consumes = "String")
	@GetMapping(value = "/queryUserDefPage", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public PageUtil<User> queryUserDefPage(PageUtil<User> pageBean, User user,int page,int pageSize){
		pageBean.setPageNo(1);
		pageBean.setPageSize(pageSize);
		return userService.queryUserDefPage(pageBean, user);
	}
	
	@ResponseBody
	@RequestMapping("/data")
	public PageUtil<User> queryUserDsPage(PageUtil<User> page, User user){
		return userService.queryUserDsPage(page, user);
	}

	@ResponseBody
	@RequestMapping("/findOne")
	public User findOne(){
		return userService.findOne();
	}
	@ResponseBody
	@RequestMapping("/updateOne")
	public int updateOne(){
		return userService.updateOne();
	}

	@ResponseBody
	@RequestMapping("/data1")
	public PageUtil<User> queryUserDs1Page(PageUtil<User> page, User user){
		return userService.queryUserDs1Page(page, user);
	}
	
	@ResponseBody
	@RequestMapping("/data2")
	public PageUtil<User> queryUserDs2Page(PageUtil<User> page, User user){
		return userService.queryUserDs2Page(page, user);
	}

	@ResponseBody
	@RequestMapping("/addUser")
	public Result addUser(User user){
		return userService.addUser(user);
	}

}
