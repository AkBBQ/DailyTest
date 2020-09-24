package com.example.mytestdemo.manager.impl;

import com.example.mytestdemo.domain.UserDO;
import com.example.mytestdemo.dao.UserDao;
import com.example.mytestdemo.manager.UserManager;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author angtai
 * @since 2020-09-10
 */
@Service
public class UserManagerImpl extends ServiceImpl<UserDao, UserDO> implements UserManager {

}
