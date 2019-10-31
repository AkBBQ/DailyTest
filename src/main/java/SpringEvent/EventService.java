package SpringEvent;

import org.springframework.stereotype.Component;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package SpringEvent
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2019/10/30 11:11 AM
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */

@Component
public class EventService{

    public void test(){
        SpringContextUtil.getApplicationContext().publishEvent(new Event(1,"2"));

    }
}