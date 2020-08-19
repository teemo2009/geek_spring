package com.geek.ioc.bean.definition;

import com.geek.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * bean 实例化
 *
 * */
public class BeanInstantiationDemo {
    public static void main(String[] args) {
        BeanFactory beanFactory=new ClassPathXmlApplicationContext("classpath:bean-instantiation-context.xml");
        User user =beanFactory.getBean("copy-by-static-method", User.class);
        System.out.println(user);
        User factoryUser=beanFactory.getBean("user-by-instance-method",User.class);
        System.out.println(factoryUser);
        System.out.println(user==factoryUser);

        User userFactoryBean=beanFactory.getBean("user-by-factory-bean",User.class);
        System.out.println(userFactoryBean);
    }
}
