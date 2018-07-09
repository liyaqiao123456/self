package com.lyq.mmp.service;

import com.lyq.mmp.common.ds.TargetDataSource;
import com.lyq.mmp.common.pojo.Result;
import com.lyq.mmp.common.pojo.PageUtil;
import com.lyq.mmp.common.utils.AppUtil;
import com.lyq.mmp.mapper.AuthUserMapper;
import com.lyq.mmp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestService extends AbstratService<User> {
   @Autowired
   AuthUserMapper authUserMapper;
	/**
	 * 使用默认数据源时不需要标示
	 * @param page
	 * @param user
	 * @return
	 */
	public PageUtil<User> queryUserDefPage(PageUtil<User> page, User user){
		return queryPage(page, user);
	}
	
	@TargetDataSource("ds")
	public PageUtil<User> queryUserDsPage(PageUtil<User> page, User user){
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
	public PageUtil<User> queryUserDs1Page(PageUtil<User> page, User user){
		return queryPage(page, user);
	}
	
	@TargetDataSource("ds2")
	public PageUtil<User> queryUserDs2Page(PageUtil<User> page, User user){
		return queryPage(page, user);
	}

	/**
	 * 事务测试
	 * @param user
	 * @return
	 */
	@Transactional//添加事务
	@TargetDataSource("ds1")
	public Result addUser(User user) {
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
