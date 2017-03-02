package com.acseed.practice.mybatis.model;

/**
 * Created by caohongchen on 17-3-2.
 */
public enum Sex {
    UNKNOWN(0, "未知"),
    MALE(1, "男性"),
    FEMALE(2, "女性")
    ;
    int id;
    String desc;

    Sex(int id, String desc) {
        this.id = id;
        this.desc = desc;
    }
}
