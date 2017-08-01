package com.tw.post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Postnet {
    public static final String INVALIDATE_POST = "";
    private static final Map<Integer, String> digitMap = new HashMap<Integer, String>();

    static {
        digitMap.put(1, ":::||");
        digitMap.put(2, "::|:|");
        digitMap.put(3, "::||:");
        digitMap.put(4, ":|::|");
        digitMap.put(5, ":|:|:");
        digitMap.put(6, ":||::");
        digitMap.put(7, "|:::|");
        digitMap.put(8, "|::|:");
        digitMap.put(9, "|:|::");
        digitMap.put(0, "||:::");
    }


    public String convertDigit(int digit) {
        return digitMap.get(digit);
    }

    public String convertPostToZipCode(String post) {
        if (!check(post)){
            return INVALIDATE_POST;
        }
        List<Integer> digitList = formatPost(post);
        int vieryCode = caclutateVerifyCode((digitList));
        digitList.add(vieryCode);
        StringBuilder zipResult = new StringBuilder();
        zipResult.append("|");
        for (int digit:digitList) {
            zipResult.append(convertDigit(digit));
        }
        zipResult.append("|");
        return zipResult.toString();
    }

    public List<Integer> formatPost(String postNumber) {
        List<Integer> digitList = new ArrayList<Integer>();
        for (int i=0, size=postNumber.length();i<size;i++) {
            char digit = postNumber.charAt(i);
            if (digit == '-') {
                continue;
            }
            digitList.add(Character.getNumericValue(digit));
        }
        return digitList;
    }

    public int caclutateVerifyCode(List<Integer> digistList) {
        int sum = 0;
        for (int i: digistList) {
            sum += i;
        }
        int verifyCode = 10 - sum%10;
        return verifyCode;
    }


    private boolean check(String post) {
        if (post == null || post.length() == 0) {
            return false;
        }
        int numberOfDigits = post.length();
        if (numberOfDigits != 5
                && numberOfDigits != 9
                && numberOfDigits != 10) {
            return false;
        }
        for (int i = 0; i < numberOfDigits; i++) {
            char digit = post.charAt(i);
            if (digit >= '0' && digit <= '9') {
                continue;
            }
            if (digit == '-') {
                continue;
            }
            return false;
        }
        return true;
    }
}
