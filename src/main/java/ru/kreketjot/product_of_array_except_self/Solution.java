package ru.kreketjot.product_of_array_except_self;

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums.length == 0) return new int[0];

        int[] answer = new int[nums.length];

        answer[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            answer[i] = answer[i - 1] * nums[i];
        }

        int accumulator = 1;
        for (int i = nums.length - 1; i > 0; i--) {
            answer[i] = answer[i - 1] * accumulator;
            accumulator *= nums[i];
        }
        answer[0] = accumulator;

        return answer;
    }
}
