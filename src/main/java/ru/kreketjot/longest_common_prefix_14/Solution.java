package ru.kreketjot.longest_common_prefix_14;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        char[] commonPrefix = strs[0].toCharArray();
        int commonLength = commonPrefix.length;
        for (int i = 1; i < strs.length; i++) {
            char[] strCharArray = strs[i].toCharArray();
            int lenght = 0;
            while (lenght < commonLength && lenght < strCharArray.length) {
                if (commonPrefix[lenght] != strCharArray[lenght]) break;
                lenght++;
            }
            commonLength = lenght;
            if (commonLength == 0) break;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < commonLength; i++) {
            result.append(commonPrefix[i]);
        }
        return result.toString();
    }
}
