package ru.kreketjot.gas_station_134;

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length != cost.length || gas.length < 1) throw new IllegalArgumentException();

        final int START_INDEX = 0;
        final int n = gas.length;

        int left = START_INDEX;
        int right = START_INDEX;
        int accumulator = 0;

        do {
            if (accumulator + gas[right] - cost[right] >= 0) {
                accumulator += gas[right] - cost[right];
                right = (right + 1) % n;
            } else {
                left = (left - 1 + n) % n;
                accumulator += gas[left] - cost[left];
            }
        } while (left != right);

        return accumulator < 0 ? -1 : left;
    }
}
