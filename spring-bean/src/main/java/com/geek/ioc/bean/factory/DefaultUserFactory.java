package com.geek.ioc.bean.factory;

import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

/**
 *  默认用户工厂
 * */
public class DefaultUserFactory  implements  UserFactory, InitializingBean {

    @PostConstruct
    public void init(){
        System.out.println("@PostConstruct UserFactory 初始化中。。。");
    }

    public void userInitFactory(){
        System.out.println("自定义初始化方法:初始化中。。。");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean afterPropertiesSet:初始化中。。。");
    }
}
