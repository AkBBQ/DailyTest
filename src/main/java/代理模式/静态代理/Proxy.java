package 代理模式.静态代理;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * All rights Reserved, Designed By www.maihaoche.com
 *
 * @Package 代理模式.静态代理
 * @author: angtai（angtai@maihaoche.com）
 * @date: 2019/11/22 5:43 PM
 * @Copyright: 2017-2020 www.maihaoche.com Inc. All rights reserved.
 */

public class Proxy implements Sell {

    private Producer producer;

    public Proxy(Producer producer) {
        this.producer = producer;
    }

    @Override
    public void Sell() {
        System.out.println("我是代理类,可以做预处理");
        producer.Sell();
        System.out.println("我是代理类,可以做其他处理");

    }

    public static void main(String[] args) {
        Proxy proxy = new Proxy(new Producer());
        proxy.Sell();
    }
}