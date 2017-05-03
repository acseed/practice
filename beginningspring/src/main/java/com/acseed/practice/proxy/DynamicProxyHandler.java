package com.acseed.practice.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by caohongchen on 17/3/1.
 */
public class DynamicProxyHandler implements InvocationHandler {
    private Object proxied;

    public DynamicProxyHandler(Object proxied) {
        System.out.println("dynamic proxy handler constuctor: " + proxied.getClass());
        this.proxied = proxied;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("dynamic proxy name: " + proxy.getClass());
        System.out.println("method: + " + method.getName());
        System.out.println("args: " + Arrays.toString(args));

        Object invokeObject = method.invoke(proxied, args);
        if (null != invokeObject) {
            System.out.println("invoke object: " + invokeObject.getClass());
        } else {
            System.out.println("invoke object is null");
        }
        return invokeObject;
    }
}
