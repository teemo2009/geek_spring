package com.geek.ioc.bean.factory;

import com.geek.ioc.overview.domain.User;
/**
 *  用户 工厂类
 * */
public interface UserFactory {

    default User createUser(){
        return User.createUser();
    }
}
