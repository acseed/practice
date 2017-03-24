package com.acseed.practice.proxy;

/**
 * Created by caohongchen on 17/3/1.
 */
public class RealObject implements Interface {
    public void getMyName() {
        System.out.println("my name acseed");
    }

    public String getNameById(String id) {
        System.out.println("argument id: " + id);
        return "acseed";
    }
}
