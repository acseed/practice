package com.acseed.gson;

import java.util.List;

/**
 * Created by caohongchen on 17-4-14.
 */
public class Person extends BaseVO {
    private List<? extends BaseVO> friends;


    public List<? extends BaseVO> getFriends() {
        return friends;
    }

    public void setFriends(List<? extends BaseVO> friends) {
        this.friends = friends;
    }
}
