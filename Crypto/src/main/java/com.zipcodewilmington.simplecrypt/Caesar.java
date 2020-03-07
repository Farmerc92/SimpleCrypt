package com.zipcodewilmington.simplecrypt;

public class Caesar extends ROT13{

    private int caesarShift;

    public Caesar(int caesarShift){
        this.caesarShift = caesarShift;
    }

    public String caesarCipherEncrypt(String text){
        char[] charArray = text.toCharArray();
        int index = 0;
        for (char c : charArray) {
            if (c >= 65 && c <= 90){
                c %= 65;
                c += caesarShift;
                c %= 26;
                c += 65;
            }
            else if (c >= 97 && c <= 122){
                c %= 97;
                c += caesarShift;
                c %= 26;
                c += 97;
            }
            charArray[index++] = c;
        }
        return new String(charArray);
    }

    public String caesarCipherDecrypt(String text){
        int decrypt = 26 - caesarShift;
        char[] charArray = text.toCharArray();
        int index = 0;
        for (char c : charArray) {
            if (c >= 65 && c <= 90){
                c %= 65;
                c += decrypt;
                c %= 26;
                c += 65;
            }
            else if (c >= 97 && c <= 122){
                c %= 97;
                c += decrypt;
                c %= 26;
                c += 97;
            }
            charArray[index++] = c;
        }
        return new String(charArray);
    }
}
