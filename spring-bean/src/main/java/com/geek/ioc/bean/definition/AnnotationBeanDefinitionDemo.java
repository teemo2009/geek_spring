package com.geek.ioc.bean.definition;

import com.geek.ioc.overview.domain.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * 注解 BeanDefinition 方式（三种方式注册 BeanDefinition 到 IOC 容器）
 */
@Import(AnnotationBeanDefinitionDemo.Config.class)
public class AnnotationBeanDefinitionDemo {

    public static void main(String[] args) {
        //创建注解上下文
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        /*注册 Configuration Class 配置类*/
        applicationContext.register(AnnotationBeanDefinitionDemo.class);

        //1.通过Bean方式注册
        registerBeanDefinition(applicationContext, "liz-user");

        //2.非命名方式上
        registerBeanDefinition(applicationContext);

        //启动上下文
        applicationContext.refresh();

        //1.@Bean  2 @Component 3 @Import
        System.out.println("Config Bean all " + applicationContext.getBeansOfType(Config.class));
        System.out.println("User Bean all " + applicationContext.getBeansOfType(User.class));
        applicationContext.close();
    }

    /**
     * 命名Bean的注册方式
     */
    public static void registerBeanDefinition(BeanDefinitionRegistry registry, String beanName) {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        beanDefinitionBuilder.addPropertyValue("id", 1L);
        beanDefinitionBuilder.addPropertyValue("name", "blue");
        //判断如果 beanName 参数是否存在
        if (StringUtils.hasText(beanName)) {
            //注册
            registry.registerBeanDefinition(beanName, beanDefinitionBuilder.getBeanDefinition());
        } else {
            //非命名方式
            BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinitionBuilder.getBeanDefinition(), registry);
        }

    }

    public static void registerBeanDefinition(BeanDefinitionRegistry registry) {
        registerBeanDefinition(registry, null);
    }

    /**
     * 定义当前类作为 Spring Bean组件
     */
    @Component
    public static class Config {
        /**
         * 通过@bean 方式定义
         * <p>
         * 这里定义了名称和别名
         */
        @Bean(name = {"user", "blue-user"})
        public User user() {
            User user = new User();
            user.setId(1L);
            user.setName("blue");
            return user;
        }
    }


}
