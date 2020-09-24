package com.example.mytestdemo.manager.impl;

import com.example.mytestdemo.domain.RoleDO;
import com.example.mytestdemo.dao.RoleDao;
import com.example.mytestdemo.manager.RoleManager;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author angtai
 * @since 2020-09-10
 */
@Service
public class RoleManagerImpl extends ServiceImpl<RoleDao, RoleDO> implements RoleManager {

}
