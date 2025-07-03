package ru.kreketjot.hIndex274;

import java.util.Arrays;

public class Solution {
    public int hIndexV1(int[] citations) {
        Arrays.sort(citations);
        for (int h = 1; h <= citations.length; h++) {
            if (citations[citations.length - h] < h) {
                return h - 1;
            }
        }
        return citations.length;
    }

    public int hIndexV2(int[] citations) {
        int[] papers = new int[citations.length];
        for (int c : citations) {
            if (c >= citations.length) {
                papers[citations.length - 1]++;
            } else if (c > 0) {
                papers[c - 1]++;
            }
        }

        int papersWithHAndMore = 0;
        for (int h = papers.length; h > 0; h--) {
            papersWithHAndMore += papers[h - 1];
            if (papersWithHAndMore >= h) {
                return h;
            }
        }

        return 0;
    }
}
