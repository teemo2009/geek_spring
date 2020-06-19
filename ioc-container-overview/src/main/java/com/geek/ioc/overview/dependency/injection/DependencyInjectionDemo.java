package com.geek.ioc.overview.dependency.injection;

import com.geek.ioc.overview.annotation.Super;
import com.geek.ioc.overview.domain.User;
import com.geek.ioc.overview.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Map;

/***
 * 依赖注入实例
 *
 * @author luqi
 * @date 2020/6/10_21:53
 */
public class DependencyInjectionDemo {
    public static void main(String[] args) {
        //配置xml文件
        //启动应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:META-INF/dependency-injection-context.xml");
        //依赖来源一:自定义bean
        UserRepository userRepository =beanFactory.getBean("userRepository", UserRepository.class);
        //依赖来源二:来自依赖注入  （内建依赖）
       // System.out.println(userRepository.getBeanFactory());
        //来自依赖查找  会抛出异常
        //System.out.println(beanFactory.getBean(BeanFactory.class));
        whoIsIocContainer(userRepository,beanFactory);
        ObjectFactory objectFactory =userRepository.getObjectFactory();
        System.out.println(objectFactory.getObject());
        ObjectFactory applicationContextObjectFactory =userRepository.getApplicationContextObjectFactory();
        System.out.println(applicationContextObjectFactory.getObject()==beanFactory);
        //依赖来源三:容器内建bean
        Environment environment=beanFactory.getBean(Environment.class);
        System.out.println("获取environment的bean======"+environment);
    }

    private static void whoIsIocContainer(UserRepository userRepository,BeanFactory beanFactory){
        //这是一个beanFactory
        System.out.println(userRepository.getBeanFactory());
        //这里实质是一个ApplicationContext
        System.out.println(beanFactory);
        //ApplicationContext是beanFactory的一个超集
        System.out.println(userRepository.getBeanFactory()==beanFactory);
        //ApplicationContext is BeanFactory

        //ConfigurableApplicationContext <-ApplicationContext<-BeanFactory

        //ConfigurableApplicationContext#getBeanFactory()
    }



}
