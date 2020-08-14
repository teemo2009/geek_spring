package com.geek.ioc.bean.definition;

import com.geek.ioc.overview.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * BeanDefiniton 如何创建
 */
public class BeanDefinitionCreationDemo {
    public static void main(String[] args) {
        //1.通过BeanDefinitionBuilder创建
        BeanDefinitionBuilder beanDefinitionBuilder= BeanDefinitionBuilder.genericBeanDefinition(User.class);
        //配置属性
        beanDefinitionBuilder.addPropertyValue("age",18);
        beanDefinitionBuilder.addPropertyValue("id",1L);
        //获取实例
        BeanDefinition beanDefinition =beanDefinitionBuilder.getBeanDefinition();
        //BeanDefinition 实例化后并非最终状态，可以操作和修改
        System.out.println(beanDefinition.getBeanClassName());

        //2. 通过AbstractBeanDefinition 或派生类初始化
        GenericBeanDefinition genericBeanDefinition=new GenericBeanDefinition();
        //设置类型
        genericBeanDefinition.setBeanClass(User.class);
        //设置参数
        MutablePropertyValues mutablePropertyValues=new MutablePropertyValues();
        mutablePropertyValues.add("age",18);
        mutablePropertyValues.add("id",1L);
        genericBeanDefinition.setPropertyValues(mutablePropertyValues);
    }
}
