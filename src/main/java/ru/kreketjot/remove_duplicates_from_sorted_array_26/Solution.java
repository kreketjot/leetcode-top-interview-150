package ru.kreketjot.remove_duplicates_from_sorted_array_26;

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int lastValue = nums[0];
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == lastValue) continue;
            nums[k++] = nums[i];
            lastValue = nums[i];
        }
        return k;
    }
}