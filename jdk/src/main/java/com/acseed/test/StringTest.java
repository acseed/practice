package com.acseed.test;

import java.math.BigDecimal;

/**
 * Created by caohongchen on 17-3-18.
 */
public class StringTest {
    private static void test() {
//        String a = "a" + "b" + 1;
//        String b = "ab1";

        Double bb = 1.11;
        BigDecimal aa = new BigDecimal(bb.toString());
        System.out.println(aa);
    }

    public static void main(String[] args) {
        StringTest.test();
    }
}
