package com.acseed.practice.jdk;

import java.math.BigDecimal;

/**
 * Created by caohongchen on 17-3-2.
 */
public class Main {
    public static void main(String[] args) {
        String astr = Double.toString(1.1);
        BigDecimal a = new BigDecimal(astr);
        BigDecimal b = new BigDecimal("1.1");
        System.out.println(a);
        System.out.println(b);
        System.out.println(a.equals(b));
        System.out.println(a.compareTo(b));
        a.doubleValue();

        System.out.println(a.doubleValue());
        System.out.println(b.doubleValue());
        System.out.println(a.doubleValue() == b.doubleValue());
        System.out.println();
    }
}
