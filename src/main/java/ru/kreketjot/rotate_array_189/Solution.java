package ru.kreketjot.rotate_array_189;

public class Solution {
    public void rotateV1(int[] nums, int k) {
        if (nums.length == 0) return;
        int fixedK = k % nums.length;
        if (fixedK == 0) return;

        int[] kNums = new int[fixedK];
        System.arraycopy(nums, nums.length - fixedK, kNums, 0, fixedK);
        System.arraycopy(nums, 0, nums, fixedK, nums.length - fixedK);
        System.arraycopy(kNums, 0, nums, 0, fixedK);
    }

    public void rotateV2(int[] nums, int k) {
        if (nums.length == 0) return;
        int fixedK = k % nums.length;
        if (fixedK == 0) return;

        reverseInPlace(nums, 0, nums.length - fixedK);
        reverseInPlace(nums, nums.length - fixedK, fixedK);
        reverseInPlace(nums, 0, nums.length);
    }

    private void reverseInPlace(int[] src, int srcPos, int length) {
        if (length < 2) return;

        for (int i = 0; i < length / 2; i++) {
            swapInPlace(src, srcPos + i, srcPos + length - i - 1);
        }
    }

    private void swapInPlace(int[] src, int aPos, int bPos) {
        int tmp = src[aPos];
        src[aPos] = src[bPos];
        src[bPos] = tmp;
    }
}
