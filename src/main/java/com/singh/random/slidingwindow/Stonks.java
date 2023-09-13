package com.singh.random.slidingwindow;

public class Stonks {

    /*
        Given an array prices where prices[i] is the price of a given stock on the ith day.

        You want to maximize profits by choosing a  single day to buy one stock and choosing a different day in the
        future to sell that stock

        Return the maximum profit you can achieve from this transaction. If you cannot, return 0;

        [7, 1, 5, 3, 6, 4]
            b
                        s

     */
    public static int maxProfit(int[] prices) {
        int max = 0;
        int buy = 0;
        int sell = 1;

        if (prices.length == 1) {
            return max;
        }

        if (prices.length == 2) {
            return Math.max(prices[sell] - prices[buy], max);
        }
        while (buy <= sell && sell < prices.length) {
            max = Math.max((prices[sell] - prices[buy]), max);
            if (prices[buy] > prices[sell]) {
                buy++;
            } else {
                sell++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(maxProfit(new int[]{7,6,5,4,3,2}));
    }
}
