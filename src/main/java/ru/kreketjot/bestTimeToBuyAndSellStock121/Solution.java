package ru.kreketjot.bestTimeToBuyAndSellStock121;

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;

        int maxDiff = 0;
        int boughtPrice = prices[0];

        for (int price : prices) {
            int diff = price - boughtPrice;
            if (diff > maxDiff) {
                maxDiff = diff;
            }
            if (price < boughtPrice) {
                boughtPrice = price;
            }
        }

        return maxDiff;
    }
}
