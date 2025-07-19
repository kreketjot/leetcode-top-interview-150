package ru.kreketjot.integer_to_roman_12;

public class Solution {
    static final int[] ints = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    static final String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman(int num) {
        StringBuilder accumulator = new StringBuilder();
        int i = 0;
        while (num > 0) {
            if (num >= ints[i]) {
                num -= ints[i];
                accumulator.append(romans[i]);
            } else {
                i++;
            }
        }
        return accumulator.toString();
    }
}
