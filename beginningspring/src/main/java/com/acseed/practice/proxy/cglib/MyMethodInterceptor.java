package com.acseed.practice.proxy.cglib;

import java.lang.reflect.Method;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * Created by caohongchen on 17/3/1.
 */
public class MyMethodInterceptor implements MethodInterceptor {
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("Before: " + method);
        Object object = methodProxy.invokeSuper(o, objects);
        System.out.println("After: " + method);
        return object;
    }
}
