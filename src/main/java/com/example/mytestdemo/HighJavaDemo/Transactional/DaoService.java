package com.example.mytestdemo.HighJavaDemo.Transactional;

import com.example.mytestdemo.domain.ShiwuDO;
import com.example.mytestdemo.manager.ShiwuManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * 操作数据
 */

@Component
public class DaoService {

    @Autowired
    ShiwuManager shiwuManager;

    @Transactional(rollbackFor = Exception.class)
    public void add() {
        ShiwuDO shiwuDO = new ShiwuDO();
        shiwuDO.setValue("two");
        shiwuManager.save(shiwuDO);

        ShiwuDO shiwuDO2 = new ShiwuDO();
        shiwuDO2.setValue("two");
        shiwuManager.save(shiwuDO2);
    }
}