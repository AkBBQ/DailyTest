package com.example.mytestdemo.manager.impl;

import com.example.mytestdemo.domain.PermissionDO;
import com.example.mytestdemo.dao.PermissionDao;
import com.example.mytestdemo.manager.PermissionManager;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

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

    public static void main(String[] args) {

        System.out.println(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                .format(new Date()));



    }
}
