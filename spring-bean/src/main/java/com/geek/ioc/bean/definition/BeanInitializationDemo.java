package com.geek.ioc.bean.definition;

import com.geek.ioc.bean.factory.DefaultUserFactory;
import com.geek.ioc.bean.factory.UserFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * Bean 初始化
 */
@Configuration
public class BeanInitializationDemo {
    public static void main(String[] args) {
        //创建注解上下文
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(BeanInitializationDemo.class);


        //启动
        applicationContext.refresh();

        //非延迟加载 初始化 会在 启动前完成  (延迟初始化 一定是在启动后)
        System.out.println("Spring 应用上下已经启动。。。。");

        UserFactory userFactory = applicationContext.getBean(UserFactory.class);

        System.out.println(userFactory);

        applicationContext.close();
    }

    @Bean(initMethod = "userInitFactory")
    @Lazy(value = false)
    public UserFactory userFactory() {
        return new DefaultUserFactory();
    }
}
