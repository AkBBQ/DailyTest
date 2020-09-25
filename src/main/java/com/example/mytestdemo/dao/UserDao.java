package com.example.mytestdemo.dao;

import com.example.mytestdemo.domain.UserDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author angtai
 * @since 2020-09-10
 */
public interface UserDao extends BaseMapper<UserDO> {

    Set<String> queryUserRole(@Param("id") Integer userId);

}
