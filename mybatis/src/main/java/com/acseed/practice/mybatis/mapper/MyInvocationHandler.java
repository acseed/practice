package com.acseed.practice.mybatis.mapper;

import com.acseed.practice.mybatis.model.Student;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by caohongchen on 17-8-21.
 */
public class MyInvocationHandler implements InvocationHandler {
    private Object target;

    public MyInvocationHandler(Object o) {
        this.target = o;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("invoke method:" + method.getName());
        return method.invoke(target, args);
    }

    public static void main(String[] args) {
        StudentMapper studentMapper =
                (StudentMapper) Proxy.newProxyInstance(StudentMapper.class.getClassLoader(), new Class[]{StudentMapper.class}, new MyInvocationHandler(new StudentMapperImpl()));
        studentMapper.getStudentById(1);
        studentMapper.insert(new Student());
        MetaObject metaObject = SystemMetaObject.forObject(studentMapper);
        System.out.println(studentMapper);
    }
}
