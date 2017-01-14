package com.acseed.practice.io;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;

/**
 * Created by caohongchen on 17/1/14.
 */
public class FormattedMemoryInput {
    public static void main(String[] args) throws IOException {
        try {
            DataInputStream in =
                    new DataInputStream(
                            new ByteArrayInputStream(
                                    BufferedInputFile.read("/Users/pintec/project/practice/src/main/java/com/acseed/practice/io/FormattedMemoryInput.java")
                                            .getBytes()));
            while (true) {
                System.out.println((char) in.readByte());
            }

        } catch (EOFException e) {
            System.err.println("End of stream");
        }
    }
}
