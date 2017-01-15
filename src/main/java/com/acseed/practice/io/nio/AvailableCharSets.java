package com.acseed.practice.io.nio;

import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.SortedMap;

/**
 * Created by caohongchen on 17/1/15.
 */
public class AvailableCharSets {
    public static void main(String[] args) {
        SortedMap<String, Charset> charsets = Charset.availableCharsets();
        Iterator<String> it = charsets.keySet().iterator();
        while (it.hasNext()) {
            String csName = it.next();
            System.out.print(csName);
            Iterator aliases = charsets.get(csName).aliases().iterator();
            if (aliases.hasNext()) {
                System.out.print(": ");
            }
            while (aliases.hasNext()) {
                System.out.print(aliases.next());
                if (aliases.hasNext()) {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
}
