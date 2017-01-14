package com.acseed.practice.io;

import java.io.PrintWriter;

/**
 * Created by caohongchen on 17/1/14.
 */
public class ChangeSysteOut {
    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out, true);
        out.println("hello world");
    }
}
