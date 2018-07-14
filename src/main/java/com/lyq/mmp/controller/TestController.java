package com.lyq.mmp.controller;

import com.lyq.mmp.common.pojo.Result;
import com.lyq.mmp.common.pojo.PageUtil;
import com.lyq.mmp.common.utils.ApiResult;
import com.lyq.mmp.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.lyq.mmp.service.TestService;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@Api(tags = "test", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class TestController {

	@Autowired
	private TestService userService;

	@GetMapping(value = "/queryUserDefPage", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "mmp哦", httpMethod = "GET", consumes = "String")
	public ApiResult<PageUtil<User>> queryUserDefPage(
										   @ApiParam(value = "页数", name = "page", required = false,defaultValue = "1") @RequestParam(name = "page", required = false,defaultValue = "1") int page,
										   @ApiParam(value = "每页多少条", name = "pageSize", required = false,defaultValue = "10") @RequestParam(name = "pageSize", required = false,defaultValue = "10") int pageSize,
										   @ApiIgnore User user,
										   @ApiIgnore  PageUtil<User> pageBean
										   ){
		ApiResult<PageUtil<User>>  apiResult=new ApiResult<PageUtil<User>>();
		pageBean.setPageNo(page);
		pageBean.setPageSize(pageSize);
		apiResult.setData(userService.queryUserDefPage(pageBean, user));
		return  apiResult;
	}



}
