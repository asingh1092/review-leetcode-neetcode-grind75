package com.singh.random;

public class SubtractProductAndSum {

    public static int subtractProductAndSum(int n) {
//        int product = 1;
//        int sum = 0;
//        int place = 10*10*10*10*10;
//        int left = n;
//        for (int i = 0; i <= 5; i++) {
//            int value = left / place;
//            if (value == 0) {
//                product *= 1;
//            } else {
//                product *= value;
//            }
//            sum += value;
//            left %= place;
//            place /= 10;
//        }
//        return product  - sum;
        int sum = 0;
        int product = 1;
        while (n > 0) {
            int value = n % 10;
            sum += value;
            product *= value;
            n /= 10;
        }
        return product - sum;
    }

    public static void main(String[] args) {
        System.out.println(subtractProductAndSum(234));
    }
}
