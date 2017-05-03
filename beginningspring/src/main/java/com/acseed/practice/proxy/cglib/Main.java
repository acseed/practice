package com.acseed.practice.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;

/**
 * Created by caohongchen on 17/3/1.
 */
public class Main {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer(); //Enhancer是CGLib的字节码增强器
        enhancer.setSuperclass(UserServiceImpl.class);
        enhancer.setCallback(new MyMethodInterceptor());
        UserServiceImpl userService = (UserServiceImpl) enhancer.create();

        userService.add();

        userService.delete(1);
    }
}
