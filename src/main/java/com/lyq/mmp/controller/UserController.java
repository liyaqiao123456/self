package com.lyq.mmp.controller;

import com.lyq.mmp.common.pojo.AjaxResult;
import com.lyq.mmp.common.pojo.PageAjax;
import com.lyq.mmp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lyq.mmp.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@ResponseBody
	@RequestMapping("/queryUserDefPage")
	public PageAjax<User> queryUserDefPage(PageAjax<User> page, User user){
		return userService.queryUserDefPage(page, user);
	}
	
	@ResponseBody
	@RequestMapping("/data")
	public PageAjax<User> queryUserDsPage(PageAjax<User> page, User user){
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
	public PageAjax<User> queryUserDs1Page(PageAjax<User> page, User user){
		return userService.queryUserDs1Page(page, user);
	}
	
	@ResponseBody
	@RequestMapping("/data2")
	public PageAjax<User> queryUserDs2Page(PageAjax<User> page, User user){
		return userService.queryUserDs2Page(page, user);
	}

	@ResponseBody
	@RequestMapping("/addUser")
	public AjaxResult addUser(User user){
		return userService.addUser(user);
	}

}
