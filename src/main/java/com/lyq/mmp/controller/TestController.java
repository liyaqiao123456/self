package com.lyq.mmp.controller;

import com.lyq.mmp.common.pojo.PageUtil;
import com.lyq.mmp.common.utils.ApiResult;
import com.lyq.mmp.model.User;
import com.lyq.mmp.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
@RestController
@Api(tags = "test", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class TestController {

	@Autowired
	private TestService userService;

	@GetMapping(value = "/queryUserDefPage", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "mmp哦", httpMethod = "GET", consumes = "String")
	public ApiResult<PageUtil<User>> queryUserDefPage(
			@ApiParam(value = "页数", name = "page", required = false, defaultValue = "1") @RequestParam(name = "page", required = false, defaultValue = "1") int page,
			@ApiParam(value = "每页多少条", name = "pageSize", required = false, defaultValue = "10") @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize,
			@ApiIgnore User user,
			@ApiIgnore PageUtil<User> pageBean
	) {
		ApiResult<PageUtil<User>> apiResult = new ApiResult<PageUtil<User>>();
		try {
			User user1 = new User();
			user1.setEmail("11");
			user1.setId(11);
			user1.setPassword("11");
			User user2 = new User();
			user2.setEmail("11");
			user2.setId(11);
			user2.setPassword("11");
			List lists = new ArrayList();
			lists.add(user1);
			lists.add(user2);
			pageBean.setPageNo(page);
			pageBean.setPageSize(pageSize);
			apiResult.setData(userService.queryUserDefPage(pageBean, user));
			List list = Stream.of(1, 2, 3, 4).filter(p -> p > 2).collect(Collectors.toList());
			JSONArray json = JSONArray.fromObject(lists);
			System.out.println(json);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return apiResult;
	}



}
