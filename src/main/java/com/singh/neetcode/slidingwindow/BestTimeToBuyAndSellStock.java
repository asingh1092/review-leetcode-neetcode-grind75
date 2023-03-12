package com.singh.neetcode.slidingwindow;

public class BestTimeToBuyAndSellStock {

    /*
      You are given an array prices where prices[i] is the price of the given stock on the ith day.

      You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in
      the future to sell that stock.

      Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0;

       Naive approach - super slow -> O((n)*(n-1)) -> O(n^2) -> naw fam
     */

    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                max = Math.max(max, profit);
            }
        }
        return max;
    }

    // sliding window approach

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock b = new BestTimeToBuyAndSellStock();
        System.out.println(b.maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
