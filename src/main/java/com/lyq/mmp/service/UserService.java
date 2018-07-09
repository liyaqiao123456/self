package com.lyq.mmp.service;

import com.lyq.mmp.common.ds.TargetDataSource;
import com.lyq.mmp.common.pojo.AjaxResult;
import com.lyq.mmp.common.pojo.PageAjax;
import com.lyq.mmp.common.utils.AppUtil;
import com.lyq.mmp.mapper.AuthUserMapper;
import com.lyq.mmp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService extends AbstratService<User> {
   @Autowired
   AuthUserMapper authUserMapper;
	/**
	 * 使用默认数据源
	 * @param page
	 * @param user
	 * @return
	 */
	public PageAjax<User> queryUserDefPage(PageAjax<User> page, User user){
		return queryPage(page, user);
	}
	
	@TargetDataSource("ds")
	public PageAjax<User> queryUserDsPage(PageAjax<User> page, User user){
		return queryPage(page, user);
	}

	@TargetDataSource("ds")
	public User findOne(){
		return authUserMapper.findOne();
	}

	@TargetDataSource("ds")
	public int updateOne(){
		User user = new User();
		user.setId(1);
		user.setUsername("mmp");
		user.setPassword("mmp");
		return authUserMapper.updateByPrimaryKey(user);
	}
	
	@TargetDataSource("ds1")
	public PageAjax<User> queryUserDs1Page(PageAjax<User> page, User user){
		return queryPage(page, user);
	}
	
	@TargetDataSource("ds2")
	public PageAjax<User> queryUserDs2Page(PageAjax<User> page, User user){
		return queryPage(page, user);
	}

	/**
	 * 事务测试
	 * @param user
	 * @return
	 */
	@Transactional//添加事务
	@TargetDataSource("ds1")
	public AjaxResult addUser(User user) {
		String str = AppUtil.getRandomString(5);
		user.setUsername("user" + str);
		user.setPassword("123456");
		user.setEmail(str + "@test.com");
		int ret = insert(user);
		if(ret > 0){
			System.out.println(1/0);
			user = new User();
			str = AppUtil.getRandomString(5);
			user.setUsername("user" + str);
			user.setPassword("123456");
			user.setEmail(str + "@test.com");
		}
		return save(user);
	}
}
