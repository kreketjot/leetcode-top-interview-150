package ru.kreketjot.roman_to_integer_13;

import java.util.Map;

public class Solution {

    private final static Map<Character, Integer> ROMAN_TO_NUMBER = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000
    );

    public int romanToInt(String s) {
        if (s.isEmpty()) return 0;

        char[] chars = s.toCharArray();
        int previous = ROMAN_TO_NUMBER.get(chars[chars.length - 1]);
        int total = previous;

        for (int i = chars.length - 2; i >= 0; i--) {
            int current = ROMAN_TO_NUMBER.get(chars[i]);
            if (current >= previous) {
                total += current;
            } else {
                total -= current;
            }
            previous = current;
        }

        return total;
    }
}
