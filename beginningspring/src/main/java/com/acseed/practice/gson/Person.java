package com.acseed.practice.gson;

import java.util.List;

/**
 * Created by caohongchen on 17-4-14.
 */
public class Person extends BaseVO {
    private String name;

    private List<? extends BaseVO> friends;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<? extends BaseVO> getFriends() {
        return friends;
    }

    public void setFriends(List<? extends BaseVO> friends) {
        this.friends = friends;
    }
}
