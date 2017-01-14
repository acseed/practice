package com.acseed.practice.io;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 * Created by caohongchen on 17/1/14.
 */
public class Redirecting {
    public static void main(String[] args) throws IOException {
        PrintStream console = System.out;
        BufferedInputStream in = new BufferedInputStream(
                new FileInputStream("/Users/pintec/project/practice/src/main/java/com/acseed/practice/io/Redirecting.java")
        );
        PrintStream out = new PrintStream(
                new FileOutputStream("test.out")
        );
        System.setIn(in);
        System.setOut(out);
        System.setErr(out);

        BufferedReader bf = new BufferedReader(
                new InputStreamReader(System.in)
        );

        String s;
        while ((s = bf.readLine()) != null) {
            System.out.println(s);
        }

        out.close();
        System.setOut(console);
    }
}
