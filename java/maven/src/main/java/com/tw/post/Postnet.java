package com.tw.post;

import java.util.HashMap;
import java.util.Map;

public class Postnet {
    private static final Map<Integer, String> digitMap = new HashMap<Integer, String>();
    static{
        digitMap.put(1,":::||");
        digitMap.put(2,"::|:|");
        digitMap.put(3,"::||:");
        digitMap.put(4,":|::|");
        digitMap.put(5,":|:|:");
        digitMap.put(6,":||::");
        digitMap.put(7,"|:::|");
        digitMap.put(8,"|::|:");
        digitMap.put(9,"|:|::");
        digitMap.put(0,"||:::");
    }


    public String convertDigit(int digit) {
        return digitMap.get(digit);
    }
}
