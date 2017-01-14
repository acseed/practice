package com.acseed.practice.utils;

import com.google.common.base.Splitter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;
import java.util.regex.Pattern;

/**
 * Created by caohongchen on 17/1/14.
 */
public class TextFile extends ArrayList<String> {
    public static String read(String fileName) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(
                    new FileReader(
                            new File(fileName).getAbsoluteFile()
                    )
            );
            try {
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s).append("\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static void write(String fileName, String text) {
        try {
            PrintWriter out = new PrintWriter(
                    new File(fileName).getAbsoluteFile()
            );
            try {
                out.print(text);
            } finally {
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public TextFile(String finaName, String splitter) {
        super(Splitter.on(Pattern.compile(splitter)).splitToList(read(finaName)));
    }

    public TextFile(String fileName) {
        this(fileName, "\n");
    }

    public void write(String fileName) {
        try {
            PrintWriter out = new PrintWriter(
                    new File(fileName).getAbsoluteFile()
            );
            try {
                for (String item : this) {
                    out.println(item);
                }
            } finally {
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String file = read("/Users/pintec/project/practice/src/main/java/com/acseed/practice/utils/TextFile.java");
        write("test1.txt", file);
        TextFile textFile = new TextFile("test1.txt");
        textFile.write("test2.txt");
        TreeSet<String> words = new TreeSet<>(new TextFile("test2.txt", "\\W+"));
        System.out.println(words.headSet("a"));
    }
}
