package com.acseed.practice.io;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by caohongchen on 17/1/14.
 */
public class TestEOF {
    public static void main(String[] args) throws IOException {
        DataInputStream in;
        in = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream("/Users/pintec/project/practice/src/main/java/com/acseed/practice/io/TestEOF.java")
                )
        );
        while (in.available() != 0) {
            System.out.println((char)in.readByte());
        }
    }
}
