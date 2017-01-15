package com.acseed.practice.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

/**
 * Created by caohongchen on 17/1/14.
 */
public class FileOutputShortcut {
    static String file = "FileOutputShortcut.out";

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(
                new StringReader(
                        BufferedInputFile.read("/Users/pintec/project/practice/src/main/java/com/acseed/practice/io/FileOutputShortcut.java")
                )
        );
        PrintWriter out = new PrintWriter(file);

        int lineCount = 1;
        String s;
        while ((s = in.readLine()) != null) {
            out.println(lineCount++ + " " + s);
        }
        out.close();
        System.out.println(BufferedInputFile.read(file));
    }
}