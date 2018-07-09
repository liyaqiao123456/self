package com.lyq.mmp.mapper;

import com.lyq.mmp.common.dao.MyMapper;
import com.lyq.mmp.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AuthUserMapper extends MyMapper<User> {
    User findOne();
}