package ru.kreketjot.trapping_rain_water_42;

public class Solution {
    // time complexity O(n), space complexity O(1)
    public int trap(int[] height) {
        if (height == null || height.length < 3) return 0;

        int leftMax = height[0];
        int rightMax = height[height.length - 1];
        int left = 1;
        int right = height.length - 2;
        int trappedWatter = 0;

        while (left <= right) {
            if (leftMax < rightMax) {
                leftMax = Math.max(leftMax, height[left]);
                trappedWatter += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                trappedWatter += rightMax - height[right];
                right--;
            }
        }

        return trappedWatter;
    }

    // time complexity O(n), space complexity O(n)
    public int trap2(int[] height) {
        if (height == null || height.length < 3) return 0;

        int[] rightMax = new int[height.length];
        for (int i = height.length - 1, max = 0; i >= 0; i--) {
            rightMax[i] = max;
            max = Math.max(max, height[i]);
        }

        int sum = 0;
        for (int i = 0, max = 0; i < height.length; i++) {
            int current = Math.min(max, rightMax[i]) - height[i];
            if (current > 0) {
                sum += current;
            }
            max = Math.max(max, height[i]);
        }

        return sum;
    }
}