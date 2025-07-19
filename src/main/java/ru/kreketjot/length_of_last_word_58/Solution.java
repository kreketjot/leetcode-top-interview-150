package ru.kreketjot.length_of_last_word_58;

import java.util.Arrays;

public class Solution {
    public int lengthOfLastWord(String s) {
        char[] charArray = s.toCharArray();
        int count = 0;
        for (int i = charArray.length - 1; i >= 0; i--) {
            if (charArray[i] != ' ') {
                count++;
            } else if (count != 0) {
                break;
            }
        }
        return count;
    }

    public int lengthOfLastWord2(String s) {
        return Arrays.stream(s.split("\\s+"))
                .filter(str -> !str.isEmpty())
                .toList()
                .getLast()
                .length();
    }
}
