package com.acseed.practice.proxy.cglib;

/**
 * Created by caohongchen on 17/3/1.
 */
public class UserServiceImpl {
    public void add() {
        System.out.println("This is add service");
    }

    public void delete(int id) {
        System.out.println("This is delete service: delete " + id);
    }
}
