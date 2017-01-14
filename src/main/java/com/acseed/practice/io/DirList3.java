package com.acseed.practice.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Created by caohongchen on 17/1/14.
 */
public class DirList3 {
    public static void main(final String[] args) {
        final File path = new File(".");
        String[] list;
        if (args.length == 0) {
            list = path.list();
        } else {
            list = path.list(new FilenameFilter() {
                Pattern pattern = Pattern.compile(args[0]);
                public boolean accept(File dir, String name) {
                    return pattern.matcher(name).matches();
                }
        });
        }
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);

        Arrays.stream(list).forEach(System.out::println);
    }
}
