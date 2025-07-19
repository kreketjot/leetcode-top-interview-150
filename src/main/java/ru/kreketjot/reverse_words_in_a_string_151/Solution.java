package ru.kreketjot.reverse_words_in_a_string_151;

import java.util.Arrays;
import java.util.List;

public class Solution {
    public String reverseWords(String s) {
        char[] str = s.toCharArray();

        // move spaces to end
        int length = 0;
        boolean isWord = true;
        int i = 0;
        while (str[i] == ' ') i++;
        while (i < str.length) {
            if (str[i] == ' ') {
                isWord = false;
            } else {
                if (!isWord) {
                    str[length++] = ' ';
                    isWord = true;
                }
                str[length++] = str[i];
            }
            i++;
        }

        // reverse each word
        int start = 0;
        for (int j = 1; j < length; j++) {
            if (str[j] == ' ') {
                reverseInPlace(str, start, j - start);
                start = j + 1;
            }
        }
        reverseInPlace(str, start, length - start); // last word

        // reverse string without spaces at the end
        reverseInPlace(str, 0, length);

        // make string from char array
        StringBuilder result = new StringBuilder();
        for (int j = 0; j < length; j++) {
            result.append(str[j]);
        }
        return result.toString();
    }

    private void reverseInPlace(char[] str, int start, int count) {
        for (int i = 0; i < count / 2; i++) {
            char tmp = str[start + i];
            str[start + i] = str[start + count - 1 - i];
            str[start + count - 1 - i] = tmp;
        }
    }

    public String reverseWords2(String s) {
        List<String> reversedWords = Arrays.stream(s.split("\\s+"))
                .filter(str -> !str.isEmpty())
                .toList()
                .reversed();
        return String.join(" ", reversedWords);
    }
}
