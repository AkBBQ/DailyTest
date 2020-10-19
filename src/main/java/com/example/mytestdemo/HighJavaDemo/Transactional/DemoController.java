package com.example.mytestdemo.HighJavaDemo.Transactional;

import com.example.mytestdemo.domain.ShiwuDO;
import com.example.mytestdemo.manager.ShiwuManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * springboot 回滚机制
 * <p>
 * 事务失效的原因
 * 一:同类中方法调用 例如 Method1调用Method2
 * 二:异常被try catch处理了
 * 三:事务的传播级别配置错误 以非事务、挂起当前事务等执行 导致不会回滚
 * 四:数据库不支持事务
 * 五:注解只能在public修饰的类、方法上生效
 */

@RestController
public class DemoController {

    @Autowired
    ShiwuManager shiwuManager;

    @Autowired
    DaoService daoService;


    @GetMapping(value = "failureCase")
    public void Method1() {
        this.Method2();
    }

    @Transactional(rollbackFor = Exception.class)
    public void Method2() {
        ShiwuDO shiwuDO = new ShiwuDO();
        shiwuDO.setValue("one");
        shiwuManager.save(shiwuDO);

        ShiwuDO shiwuDO2 = new ShiwuDO();
        shiwuDO2.setValue("one");
        shiwuManager.save(shiwuDO2);
    }

    /**
     * 调用其他类中的事务
     */
    @GetMapping(value = "successCase")
    public void Method3() {
        daoService.add();
    }
}