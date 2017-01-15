package com.acseed.practice.designpattern.strategypattern;

/**
 * Created by caohongchen on 17/1/15.
 */
public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Quack");
    }
}
