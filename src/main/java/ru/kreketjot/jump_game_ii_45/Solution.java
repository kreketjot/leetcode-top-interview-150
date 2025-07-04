package ru.kreketjot.jump_game_ii_45;

public class Solution {
    public int jump(int[] nums) {
        int jumpsCount = 0;
        int maxI = 0;
        int jumpOnI = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxI = Math.max(maxI, nums[i] + i);
            if (maxI >= nums.length - 1) {
                jumpsCount++;
                break;
            }
            if (i == jumpOnI) {
                jumpsCount++;
                jumpOnI = maxI;
            }
        }
        return jumpsCount;
    }
}
