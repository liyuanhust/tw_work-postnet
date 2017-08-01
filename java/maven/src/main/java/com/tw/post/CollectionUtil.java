package com.tw.post;

import com.sun.istack.internal.Nullable;

import java.util.List;

public class CollectionUtil {
    public static String converIntListToString(@Nullable List<Integer> integerList){
        if (integerList == null) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        for (Integer i: integerList) {
            result.append(i);
        }
        return result.toString();
    }
}
