package com.acseed.practice.io;

import java.io.IOException;
import java.io.StringReader;

/**
 * Created by caohongchen on 17/1/14.
 */
public class MemoryInput {
    public static void main(String[] args) throws IOException {
        StringReader in = new StringReader(BufferedInputFile.read("/Users/pintec/project/practice/src/main/java/com/acseed/practice/io/MemoryInput.java"));
        int c;
        while ((c = in.read()) != -1) {
            System.out.println((char)c);
        }
    }
}
