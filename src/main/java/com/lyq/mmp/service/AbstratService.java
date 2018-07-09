package com.lyq.mmp.service;

import java.util.List;

import com.lyq.mmp.common.pojo.Result;
import com.lyq.mmp.common.pojo.PageUtil;
import com.lyq.mmp.common.utils.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.page.PageMethod;

import tk.mybatis.mapper.common.Mapper;

/**
 * 通用接口
 * @param <T>
 */
@Service
public abstract class AbstratService<T> {

    @Autowired
    protected Mapper<T> mapper;

    public Mapper<T> getMapper() {
        return mapper;
    }

    public T queryByID(Object key) {
        return mapper.selectByPrimaryKey(key);
    }
    
    public List<T> queryList(T entity){
    	return mapper.select(entity);
    }
    
    public T queryOne(T entity){
    	return mapper.selectOne(entity);
    }
    
    public int queryCount(T entity){
    	return mapper.selectCount(entity);
    }

    public List<T> queryByParams(Object example) {
        return mapper.selectByExample(example);
    }
    
    public List<T> queryAll(){
    	return mapper.selectAll();
    }

    public PageUtil<T> queryPage(PageUtil<T> page, T entity){
    	PageMethod.startPage(page.getPageNo(), page.getPageSize());
    	List<T> list = queryList(entity);
        return new PageUtil<T>(list);
    }

    public Result save(T entity) {
        int ret = insert(entity);
        String result = null;
        if(ret <= 0){
        	result = "添加失败";
        }
    	return AppUtil.returnObj(result);
    }
    
    public int insert(T entity){
    	return mapper.insert(entity);
    }

    public Result saveNotNull(T entity) {
    	int ret = mapper.insertSelective(entity);
        String result = null;
        if(ret <= 0){
        	result = "更新失败";
        }
    	return AppUtil.returnObj(result);
    }

    public Result update(T entity) {
    	int ret = updateByID(entity);
        String result = null;
        if(ret <= 0){
        	result = "更新失败";
        }
    	return AppUtil.returnObj(result);
    }
    
    public int updateByID(T entity){
    	return mapper.updateByPrimaryKeySelective(entity);
    }

    public Result delete(Object key) {
        int ret = deleteByID(key);
        String result = null;
        if(ret <= 0){
        	result = "删除失败";
        }
    	return AppUtil.returnObj(result);
    }
    
    public int deleteByID(Object key) {
    	return mapper.deleteByPrimaryKey(key);
    }

}
