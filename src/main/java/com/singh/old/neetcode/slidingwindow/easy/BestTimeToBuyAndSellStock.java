package com.singh.old.neetcode.slidingwindow.easy;

public class BestTimeToBuyAndSellStock {

    /*
      You are given an array prices where prices[i] is the price of the given stock on the ith day.

      You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in
      the future to sell that stock.

      Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0;

      Naive approach - super slow -> O((n)*(n-1)) -> O(n^2) -> naw fam

      [7, 1, 5, 3, 6, 4]
          ^
       0 -6 -2 -4 -1 -3
          0  4  2  5  3
             0
      [1, 2, 3, 4, 5, 6]
       ^--------------^
      [7, 1, 5, 3, 6, 8]

     */

    public int maxProfitSlow(int[] prices) {
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
    public int maxProfit(int[] prices) {
        int max = 0;
        int profit;
        int left = 0;
        int right = 1;
        while (right < prices.length) {
            if (prices[left] < prices[right]) {
                profit = prices[right] - prices[left];
                if (profit > max) {
                    max = profit;
                }
            } else {
                left = right;
            }
            right++;
        }
        return max;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock b = new BestTimeToBuyAndSellStock();
        System.out.println(b.maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
