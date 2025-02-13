package com.singh.old.google.foundations;

public class Factorial {
    public static int firstFactorial(int num) {
        // code goes here
        int ret = 1;
        int factorialMax = num;
        for (int i = 1; i <= num; i++) {
            ret *= factorialMax;
            factorialMax--;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(firstFactorial(5));
        System.out.println(firstFactorial(4));
        System.out.println(firstFactorial(8));
        System.out.println(firstFactorial(25));
    }
}
