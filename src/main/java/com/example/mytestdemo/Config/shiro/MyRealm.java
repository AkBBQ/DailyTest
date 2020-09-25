package com.example.mytestdemo.Config.shiro;

import com.example.mytestdemo.domain.UserDO;
import com.example.mytestdemo.manager.UserManager;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * 自定义Realm用于查询用户的角色和权限信息并保存到权限管理器：
 *
 * @author angtai
 */

public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UserManager userManager;

    /**
     * 登录验证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 拿到输入的登录名以及密码
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        // 获取数据库中该用户的用户名以及密码
        UserDO userDO = userManager.queryUser(token.getUsername());
        // 将获取到的用户信息放入shiro进行对比
        if (Objects.nonNull(userDO)) {
            return new SimpleAuthenticationInfo(userDO.getName(), userDO.getPassword(), getName());
        }
        return null;
    }


    /**
     * 权限配置类
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("————权限认证————");
        String userName = (String) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // 获得该用户角色
        UserDO userDO = userManager.queryUser(userName);
        //需要将 role 封装到 Set 作为 info.setRoles() 的参数
        Set<String> role = userManager.getUserRoles(userDO.getId());
        //设置该用户拥有的角色
        info.setRoles(role);
        //权限
        Set<String> authorities = new HashSet<>();
        info.setStringPermissions(authorities);
        return info;
    }


}