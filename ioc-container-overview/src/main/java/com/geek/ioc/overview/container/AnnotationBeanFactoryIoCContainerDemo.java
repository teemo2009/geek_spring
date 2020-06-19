package com.geek.ioc.overview.container;

import com.geek.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * ioc 容器示例  注解
 *
 * @author luqi
 * @date 2020/6/19_13:53
 */
@Configuration
public class AnnotationBeanFactoryIoCContainerDemo {
    public static void main(String[] args) {
        //创建beanFactory 容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 将当前类作为配置class
        applicationContext.register(AnnotationBeanFactoryIoCContainerDemo.class);
        // 启动应用上下文
        applicationContext.refresh();
        lookupCollectByType(applicationContext);
    }

    @Bean
    public User user() {
        User user = new User();
        user.setId(1L);
        user.setName("hello");
        return user;
    }


    /***
     *
     * 集合类型查找
     *
     * @author luqi
     * @date 2020/6/10_22:25
     */
    private static void lookupCollectByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找到的集合对象:" + users);

        }
    }
}
