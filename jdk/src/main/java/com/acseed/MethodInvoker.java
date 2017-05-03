package com.acseed;

import com.google.common.collect.Lists;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by caohongchen on 17-3-11.
 */
public class MethodInvoker {
    private List<Method> methods = Lists.newArrayList();
    private List<A> clzz = Lists.newArrayList();

    public void init(Class<A> clazz) throws NoSuchMethodException {
        Method step1 = clazz.getDeclaredMethod("step1");
        Method step2 = clazz.getDeclaredMethod("step2");
        this.registMethod(step1);
        this.registMethod(step2                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                );
    }


    public void registMethod(Method method) {
        this.methods.add(method);
    }

    public void registClazz(A a) {
        this.clzz.add(a);
    }

    public void invok() throws InvocationTargetException, IllegalAccessException {
        for (Method method : methods) {
            method.setAccessible(true);
            for (A a : clzz) {
                method.invoke(a);
            }
        }
    }
}
