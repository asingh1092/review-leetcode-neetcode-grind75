package com.singh.random;

public class StringSplosion {

    /*
        Given a non-empty string like "Code" return a string like "CCoCodCode"

        "Code" -> CCCoCodCode
        "abc" -> "aababc"
        "ab" -> "aab"

        [C, o, d, e ]
               ^
         CCoCod
     */

    public static String splosion(String str) {
        StringBuilder ret = new StringBuilder();
        char[] cArray = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            if (ret.isEmpty()) {
                ret.append(cArray[i]);
            } else {
                ret.append(str, 0, i);
                ret.append(cArray[i]);
            }
        }

        return ret.toString();
    }

    public static void main(String[] args) {
        System.out.println(splosion("Code"));
        System.out.println(splosion("abc"));
        System.out.println(splosion("ab"));
    }
}
