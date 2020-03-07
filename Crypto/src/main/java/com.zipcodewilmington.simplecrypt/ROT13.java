package com.zipcodewilmington.simplecrypt;

import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;
import static java.lang.Character.toLowerCase;

public class ROT13  {

    private Character cs;
    private Character cf;

    ROT13(Character cs, Character cf) {
        this.cs = cs;
        this.cf = cf;
    }

    ROT13() {
        cs = 'a';
        cf = 'n';
    }


    public String crypt(String text) throws UnsupportedOperationException {
        int difference = cf - cs;
        char[] charArray = text.toCharArray();
        int index = 0;
        for (char c : charArray) {
            if (c >= 65 && c <= 90){
                c %= 65;
                c += difference;
                c %= 26;
                c += 65;
            }
            else if (c >= 97 && c <= 122){
                c %= 97;
                c += difference;
                c %= 26;
                c += 97;
            }
            charArray[index++] = c;
        }
        return new String(charArray);
    }

    public String encrypt(String text) {
        return crypt(text);
    }

    public String decrypt(String text) {
        int difference = 26 - (cf - cs);
        char[] charArray = text.toCharArray();
        int index = 0;
        for (char c : charArray) {
            if (c >= 65 && c <= 90){
                c %= 65;
                c += difference;
                c %= 26;
                c += 65;
            }
            else if (c >= 97 && c <= 122){
                c %= 97;
                c += difference;
                c %= 26;
                c += 97;
            }
            charArray[index++] = c;
        }
        return new String(charArray);
    }

    public static String rotate(String s, Character c) {
        int index = 0;
        char[] holder = new char[s.length()];
        char[] holder1 = new char[s.length()];
        while (s.charAt(index) != c){
            holder[index] = s.charAt(index++);
        }
        int savePoint = index;
        while (index < s.length()){
            holder1[index] = s.charAt(index++);
        }
        char[] merge = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - savePoint)
                merge[i] = holder1[i + savePoint];
            else
                merge[i] = holder[i - savePoint];
        }
        return new String(merge);
    }

}
