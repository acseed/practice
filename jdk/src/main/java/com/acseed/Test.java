package com.acseed;

import java.math.BigDecimal;

/**
 * Created by caohongchen on 17-5-3.
 */
public class Test {
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal("1000.00");
        BigDecimal b = new BigDecimal(0.3);
        double c = 0.3;
        double d = 1000.0;
        System.out.println(c * d);
        System.out.println(b);
        System.out.println(a.multiply(b).setScale(2, BigDecimal.ROUND_DOWN));
    }
}
