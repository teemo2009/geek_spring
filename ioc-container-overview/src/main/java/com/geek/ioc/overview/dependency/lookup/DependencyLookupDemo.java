package com.geek.ioc.overview.dependency.lookup;

import com.geek.ioc.overview.annotation.Super;
import com.geek.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/***
 * 依赖查找实例
 *
 * @author luqi
 * @date 2020/6/10_21:53
 */
public class DependencyLookupDemo {
    public static void main(String[] args) {
        //配置xml文件
        //启动应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-lookup-context.xml");
        lookupByAnnotation(beanFactory);
        lookupCollectByType(beanFactory);
        lookupByType(beanFactory);
        lookupRealTime(beanFactory);
        lookupInLazy(beanFactory);
    }

    /***
     *
     *  注解的方式查找
     *
     * @author luqi
     * @date 2020/6/10_22:40
     */
    private static void lookupByAnnotation(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, Object> users = listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println("查找到@Super的集合对象:" + users);

        }
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

    /***
     *
     *  按照类型查找
     *
     * @param beanFactory beanFactory
     * @author luqi
     * @date 2020/6/10_22:21
     */
    private static void lookupByType(BeanFactory beanFactory) {
        User user = beanFactory.getBean(User.class);
        System.out.println("实时查找" + user);
    }

    /***
     *
     *  延迟查找
     *
     * @param beanFactory beanFactory
     * @author luqi
     * @date 2020/6/10_22:21
     */
    private static void lookupInLazy(BeanFactory beanFactory) {
        ObjectFactory<User> objectFactory = (ObjectFactory<User>) beanFactory.getBean("objectFactory");
        User user = objectFactory.getObject();
        System.out.println("延迟查找" + user);
    }

    /***
     *
     *  通过实时的去查找bean
     *
     * @param beanFactory beanFactory
     * @author luqi
     * @date 2020/6/10_22:18
     */
    private static void lookupRealTime(BeanFactory beanFactory) {
        User user = (User) beanFactory.getBean("user");
        System.out.println("实时查找" + user);
    }
}
