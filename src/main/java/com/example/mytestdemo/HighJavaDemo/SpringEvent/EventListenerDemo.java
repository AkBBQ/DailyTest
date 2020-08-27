package com.example.mytestdemo.HighJavaDemo.SpringEvent;
import com.alibaba.fastjson.JSON;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package SpringEvent
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2019/10/30 11:20 AM
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */

@Component
public class EventListenerDemo {

    @EventListener(condition = "#event.getId().equals(1)")
    public void orderEventLinstener(Event event){
        System.out.println("接收到事件了弟弟!,接收到的内容为:"+JSON.toJSON(event));

    }
}