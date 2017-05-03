package com.acseed.gson;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

/**
 * Created by caohongchen on 17-4-14.
 */
public class Main {
    public static void main(String[] args) {
        Person person = new Person();

        Person p1 = new Person();

        List<Person> friends = Lists.newArrayList();
        friends.add(p1);
        person.setFriends(friends);
        Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(person));
    }
}
