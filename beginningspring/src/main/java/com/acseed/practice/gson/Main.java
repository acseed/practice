package com.acseed.practice.gson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

/**
 * Created by caohongchen on 17-4-14.
 */
public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        Person person = new Person();
        person.setName("hello");

        Person p1 = new Person();
        p1.setName("world");

        List<Person> friends = Lists.newArrayList();
        friends.add(p1);
        person.setFriends(friends);
        Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(person));

        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(person));
    }
}
