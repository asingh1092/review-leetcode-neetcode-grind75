package com.singh.random;

public class RepeatedString {

    /*
        return the number of 'a's in the string s if it is printed infinitely up to n
     */
    public static long repeated(String s, long n) {
        long ret = 0;
        // find a's in string
        for (char c : s.toCharArray()) {
            if (c == 'a') {
                ret++;
            }
        }
        // find out how many times s can be in n
        ret = ret * (n / s.length());

        // find any remaining a's in substring
        long remaining = n % s.length();
        for (int i = 0; i < remaining; i++) {
            if (s.charAt(i) == 'a') {
                ret++;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(repeated("ojowrdcpavatfacuunxycyrmpbkvaxyrsgquwehhurnicgicmrpmgegftjszgvsgqavcrvdtsxlkxjpqtlnkjuyraknwxmnthfpt", 685118368975L));
    }
}
