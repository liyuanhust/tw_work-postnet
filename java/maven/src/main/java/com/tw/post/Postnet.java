package com.tw.post;

public class Postnet {
    public String convertDigit(int digit) {
        String barcode = "";
        switch (digit) {
            case 1:
                barcode = ":::||";
                break;
            case 2:
                barcode = "::|:|";
                break;
            case 3:
                barcode = ":::||";
                break;
            case 4:
                barcode = ":|::|";
                break;
            case 5:
                barcode = ":|:|:";
                break;
            case 6:
                barcode = ":||::";
                break;
            case 7:
                barcode = "|:::|";
                break;
            case 8:
                barcode = "|::|:";
                break;
            case 9:
                barcode = "|:|::";
                break;
            case 0:
                barcode = "||:::";
                break;
        }
        return barcode;
    }
}
