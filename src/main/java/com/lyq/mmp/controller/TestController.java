package com.lyq.mmp.controller;

import com.lyq.mmp.common.pojo.Result;
import com.lyq.mmp.common.pojo.PageUtil;
import com.lyq.mmp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lyq.mmp.service.TestService;

@Controller
public class TestController {

	@Autowired
	private TestService userService;
	
	@ResponseBody
	@RequestMapping("/queryUserDefPage")
	public PageUtil<User> queryUserDefPage(PageUtil<User> page, User user){
		page.setPageNo(1);
		page.setPageSize(1);
		return userService.queryUserDefPage(page, user);
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
