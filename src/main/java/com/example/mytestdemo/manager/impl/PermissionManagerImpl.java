package com.example.mytestdemo.manager.impl;

import com.example.mytestdemo.domain.PermissionDO;
import com.example.mytestdemo.dao.PermissionDao;
import com.example.mytestdemo.manager.PermissionManager;
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
public class PermissionManagerImpl extends ServiceImpl<PermissionDao, PermissionDO> implements PermissionManager {

}
