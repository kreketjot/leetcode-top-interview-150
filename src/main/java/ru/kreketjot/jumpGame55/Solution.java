package ru.kreketjot.jumpGame55;

public class Solution {
    public boolean canJump(int[] nums) {
        int i = 0;
        int maxI = 0;
        int lastIndex = nums.length - 1;
        while (maxI < lastIndex) {
            if (i > maxI) return false;
            maxI = Math.max(maxI, i + nums[i]);
            i++;
        }
        return true;
    }
}
