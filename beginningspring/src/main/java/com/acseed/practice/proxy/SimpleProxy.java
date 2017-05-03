package com.acseed.practice.proxy;

/**
 * Created by caohongchen on 17/3/1.
 */
public class SimpleProxy implements Interface {
    private Interface proxied;

    public SimpleProxy(Interface proxied) {
        this.proxied = proxied;
    }

    public void getMyName() {
        System.out.println("proxy getmyname");
        proxied.getMyName();
    }

    public String getNameById(String id) {
        System.out.println("proxy getnamebyid");
        return proxied.getNameById(id);
    }
}
