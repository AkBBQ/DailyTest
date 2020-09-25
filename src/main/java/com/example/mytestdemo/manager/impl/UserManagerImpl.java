package com.example.mytestdemo.manager.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mytestdemo.dao.UserDao;
import com.example.mytestdemo.domain.UserDO;
import com.example.mytestdemo.manager.UserManager;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

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

    @Autowired
    private UserManager userManager;

    @Autowired
    private UserDao userDao;

    @Override
    public UserDO queryUser(String userName) {
        QueryWrapper<UserDO> wrapper = new QueryWrapper<>();
        wrapper.eq("name", userName);
        return userManager.getOne(wrapper);
    }

    @Override
    public UserDO getCurrentUser() {
        Subject subject = SecurityUtils.getSubject();
        String userName = String.valueOf(subject.getPrincipal());
        if (StringUtils.isBlank(userName)) {
            return null;
        }
        QueryWrapper<UserDO> wrapper = new QueryWrapper<UserDO>()
                .eq("name", userName);
        return userManager.getOne(wrapper);
    }

    @Override
    public Set<String> getUserRoles(Integer userId) {

        return userDao.queryUserRole(userId);
    }
}
