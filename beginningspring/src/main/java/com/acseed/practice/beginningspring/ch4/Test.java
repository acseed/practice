package com.acseed.practice.beginningspring.ch4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Properties;

/**
 * Created by caohongchen on 17-5-17.
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext c = new ClassPathXmlApplicationContext("classpath:beans.xml");
        Properties p=(Properties)c.getBean("configproperties");
        System.out.println(p.getProperty("a"));
    }
}
