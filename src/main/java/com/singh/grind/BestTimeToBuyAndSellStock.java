package com.singh.grind;

public class BestTimeToBuyAndSellStock {

    public int maxProfitBruteForce(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                max = Math.max(prices[j] - prices[i], max);
            }
        }
        return max;
    }

    /*
        [7 1 5 3 6 4]
                   ^
     max           5
     min           1
     */
    public int maxProfit(int[] prices) {
        int size = prices.length;
        // only
        if (size < 2) {
            return 0;
        }
        int max = 0;
        int minStock = prices[0];

        for (int price : prices) {
            max = Math.max(max, price - minStock);
            minStock = Math.min(minStock, price);
        }
        return max;
    }

    public int maxProfitSlidingWindow(int[] prices) {
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
                buy = sell;
            }
            sell++;
        }
        return max;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock b = new BestTimeToBuyAndSellStock();
        System.out.println(b.maxProfitBruteForce(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(b.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
