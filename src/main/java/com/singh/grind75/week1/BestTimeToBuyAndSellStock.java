package com.singh.grind75.week1;

public class BestTimeToBuyAndSellStock {

    /*
        7 1 5 3 6 4


     */
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
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        BestTimeToBuyAndSellStock buyAndSellStock = new BestTimeToBuyAndSellStock();
        System.out.println(buyAndSellStock.maxProfit(prices));
    }
}
