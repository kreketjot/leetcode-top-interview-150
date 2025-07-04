package ru.kreketjot.best_time_to_buy_and_sell_stock_ii_122;

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
