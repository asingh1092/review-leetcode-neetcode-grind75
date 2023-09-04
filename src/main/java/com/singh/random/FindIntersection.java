package com.singh.random;

import java.util.ArrayList;
import java.util.List;

public class FindIntersection {

    public static String findIntersection(String[] strArr) {
        List<String> ret = new ArrayList<>();
        String[] str1 = strArr[0].split(", ");
        String[] str2 = strArr[1].split(", ");
        int first = 0;
        int second = 0;
        int num1;
        int num2;
        while (first < str1.length && second < str2.length) {
            num1 = Integer.parseInt(str1[first]);
            num2 = Integer.parseInt(str2[second]);
            if (Integer.parseInt(str1[first]) == Integer.parseInt(str2[second])) {
                ret.add(str1[first]);
                first++;
                second++;
            } else if (num1 > num2) {
                second++;
            } else {
                first++;
            }
        }
        return ret.isEmpty() ? "false" : ret.toString();
    }
}
