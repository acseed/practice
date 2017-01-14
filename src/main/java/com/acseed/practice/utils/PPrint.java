package com.acseed.practice.utils;

import com.google.common.collect.Lists;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by caohongchen on 17/1/14.
 */
public class PPrint {
    public static String pformat(Collection<?> collection) {
        if (collection.size() == 0) {
            return "[]";
        }

        StringBuilder result = new StringBuilder("[");
        for (Object elem : collection) {
            if (1 != collection.size()) {
                result.append("\n ");
            }
            result.append(elem);
        }
        if (1 != collection.size()) {
            result.append("\n");
        }
        result.append("]");
        return result.toString();
    }

    public static void pprint(Collection<?> collection) {
        System.out.println(pformat(collection));
    }

    public static void pprint(Object[] objects) {
        System.out.println(pformat(Lists.newArrayList(objects)));
    }
}
