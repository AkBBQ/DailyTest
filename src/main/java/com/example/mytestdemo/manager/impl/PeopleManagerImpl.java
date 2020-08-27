package com.example.mytestdemo.manager.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mytestdemo.dao.PeopleDao;
import com.example.mytestdemo.domain.PeopleDO;
import com.example.mytestdemo.manager.PeopleManager;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author angtai
 * @since 2020-08-27
 */
@Service
public class PeopleManagerImpl extends ServiceImpl<PeopleDao, PeopleDO> implements PeopleManager {

}
