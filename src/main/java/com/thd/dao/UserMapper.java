package com.thd.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.thd.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Allen
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * 测试
     * @param name
     * @return
     */
    List<User> selectTest(String name);
}
