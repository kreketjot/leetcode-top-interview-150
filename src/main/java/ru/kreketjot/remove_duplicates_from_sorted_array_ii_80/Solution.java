package ru.kreketjot.remove_duplicates_from_sorted_array_ii_80;

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        final int AT_MOST_COUNT = 2;
        int lastValue = nums[0];
        int remainCount = AT_MOST_COUNT - 1;
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != lastValue) {
                nums[k++] = nums[i];
                lastValue = nums[i];
                remainCount = AT_MOST_COUNT - 1;
            } else if (remainCount > 0) {
                nums[k++] = nums[i];
                remainCount--;
            }
        }
        return k;
    }
}