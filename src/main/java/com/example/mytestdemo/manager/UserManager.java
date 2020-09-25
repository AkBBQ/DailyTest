package com.example.mytestdemo.manager;

import com.example.mytestdemo.domain.UserDO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Set;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author angtai
 * @since 2020-09-10
 */
public interface UserManager extends IService<UserDO> {

    /**
     * 根据用户名查找用户
     *
     * @param userName
     * @return
     */
    UserDO queryUser(String userName);

    /**
     * 获取当前登录的用户
     *
     * @return
     */
    UserDO getCurrentUser();

    Set<String> getUserRoles(Integer userId);

}
