package com.geek.ioc.bean.definition;

import com.geek.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *  别名示例
 * */
public class BeanAliasDemo {
    public static void main(String[] args) {

        BeanFactory beanFactory=new ClassPathXmlApplicationContext("classpath:beandefinition-context.xml");
        User user = beanFactory.getBean("user",User.class);
        //别名获取
        User blueUser = beanFactory.getBean("blue-user",User.class);
        System.out.println(user==blueUser);
    }
}
