package com.tw.post;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Lists;
import org.fest.util.VisibleForTesting;

import java.util.ArrayList;
import java.util.List;

public class Postnet {
    public static final String INVALIDATE_POST = "";
    private static final BiMap<Integer, String> digitMap = HashBiMap.create();

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
        if (!checkPostNumber(post)) {
            return INVALIDATE_POST;
        }
        List<Integer> digitList = formatPost(post);
        int vieryCode = caclutateVerifyCode((digitList));
        digitList.add(vieryCode);
        StringBuilder zipResult = new StringBuilder();
        zipResult.append("|");
        for (int digit : digitList) {
            zipResult.append(convertDigit(digit));
        }
        zipResult.append("|");
        return zipResult.toString();
    }

    public List<Integer> formatPost(String postNumber) {
        List<Integer> digitList = new ArrayList<Integer>();
        for (int i = 0, size = postNumber.length(); i < size; i++) {
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
        for (int i : digistList) {
            sum += i;
        }
        int verifyCode = 10 - sum % 10;
        return verifyCode;
    }


    private boolean checkPostNumber(String post) {
        if (post == null || post.length() == 0) {
            return false;
        }
        int numberOfDigit = post.length();
        if (!isNumberOfDigitValid(numberOfDigit)) {
            return false;
        }
        for (int i = 0; i < numberOfDigit; i++) {
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

    private boolean isNumberOfDigitValid(int numberOfDigit) {
        if (numberOfDigit == 5
                || numberOfDigit == 9
                || numberOfDigit == 10) {
            return true;
        }
        return false;
    }

    public String convertZipCodeToPost(String zipCode) {
        if (!checkZipCode(zipCode)) {
            return "";
        }
        return zipCode;
    }

    @VisibleForTesting
    public List<Integer> covertZipcodeToDigitList(String zipCode) {
        List<Integer> result = Lists.newArrayList();
        zipCode = zipCode.substring(1, zipCode.length() - 1);
        for (int i = 0; i + 5 <= zipCode.length(); i += 5) {
            Integer digit = digitMap.inverse().get(zipCode.substring(i, i + 5));
            if (digit != null) {
                result.add(digit);
            }
        }
        return result;
    }

    private boolean checkZipCode(String zipCode) {
        if (zipCode == null) {
            return false;
        }
        int length = zipCode.length();
        if (length <= 2) {
            return false;
        }
        if (!zipCode.startsWith("1") || !zipCode.endsWith("|")) {
            return false;
        }
        if ((length - 2) % 5 != 0) {
            return false;
        }
        int numbers = (length - 2) / 5;
        if (!isNumberOfDigitValid(numbers - 1)) {
            return false;
        }
        return true;
    }

    public boolean verifyPostDigits(List<Integer> digitList) {
        int sum = 0;
        for (int i = 0, size = digitList.size(); i < size; i++) {
            sum += digitList.get(i);
        }
        return sum % 10 == 0;

    }
}
