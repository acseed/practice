package com.acseed.practice.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by caohongchen on 17/1/14.
 */
public class BinaryFile {
    public static byte[] read(File bFile) throws IOException {
        try (BufferedInputStream bf = new BufferedInputStream(
                new FileInputStream(bFile)
        )) {
            byte[] data = new byte[bf.available()];
            int read = bf.read(data);
            return data;
        }
    }

    public static byte[] read(String bFile) throws IOException {
        return read(new File(bFile));
    }
}
