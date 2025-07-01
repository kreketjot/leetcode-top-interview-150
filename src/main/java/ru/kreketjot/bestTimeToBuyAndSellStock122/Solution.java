package ru.kreketjot.bestTimeToBuyAndSellStock122;

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;

        int boughtPrice = prices[0];
        int sum = 0;

        for (int price : prices) {
            int diff = price - boughtPrice;
            if (diff > 0) {
                sum += diff;
            }
            boughtPrice = price;
        }

        return sum;
    }
}
