package ru.kreketjot.candy_135;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    private static class Child {
        int index;
        int count;

        Child(int index, int count) {
            this.index = index;
            this.count = count;
        }
    }

    public int candy(int[] ratings) {
        final int n = ratings.length;

        Deque<Child> children = new ArrayDeque<>();

        int candies = 0;
        for (int i = 1, count = 0; i < n; i++) {
            int maxCurrentCount;

            if (ratings[i - 1] < ratings[i]) {
                maxCurrentCount = Integer.MAX_VALUE;
                count++;
            } else if (ratings[i - 1] == ratings[i]) {
                maxCurrentCount = Integer.MAX_VALUE;
                count = 0;
            } else if (count > 0) { // prevRating > curRating && prevCount > 0
                maxCurrentCount = count - 1;
                count = 0;
            } else { // prevRating > curRating && prevCount == 0
                maxCurrentCount = 0;
                count = 0;
                candies += giveCandiesToPreviousChildren(children, i);
            }

            candies += count;

            int diff = maxCurrentCount - count;
            if (diff > 0) {
                children.push(new Child(i, diff));
            }
        }

        return candies + n;
    }

    private int giveCandiesToPreviousChildren(Deque<Child> children, int index) {
        Child child = children.peek();
        if (child == null) {
            return index;
        }
        int count = index - child.index;
        if (--child.count <= 0) {
            children.pop();
        }
        return count;
    }
}
