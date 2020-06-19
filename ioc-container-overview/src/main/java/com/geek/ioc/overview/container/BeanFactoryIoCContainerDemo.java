package com.geek.ioc.overview.container;

import com.geek.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 *  ioc 容器示例
 *
 * @author luqi
 * @date 2020/6/19_13:53
 */
public class BeanFactoryIoCContainerDemo {
    public static void main(String[] args) {
        //创建beanFactory 容器
        DefaultListableBeanFactory beanFactory=new DefaultListableBeanFactory();
        //加载配置
        XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(beanFactory);
        int number =  reader.loadBeanDefinitions("classpath:/META-INF/dependency-lookup-context.xml");
        //读取到3个bean
        //System.out.println(number);
        lookupCollectByType(beanFactory);
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
