package com.acseed.practice.designpattern.strategypattern;

/**
 * Created by caohongchen on 17/1/15.
 */
public class FlyRocketPowered implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I'm flying with a rocket!");
    }
}
