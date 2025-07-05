package ru.kreketjot.insert_delete_getrandom_o1_380;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {
    private Map<Integer, Integer> valueToIndex;
    private List<Integer> values;
    private Random random;

    public RandomizedSet() {
        valueToIndex = new HashMap<>();
        values = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        boolean contains = valueToIndex.containsKey(val);
        if (!contains) {
            valueToIndex.put(val, values.size());
            values.add(val);
        }
        return !contains;
    }

    public boolean remove(int val) {
        Integer index = valueToIndex.remove(val);
        if (index == null) {
            return false;
        }

        Integer lastElement = values.removeLast();
        if (index != values.size()) {
            values.set(index, lastElement);
            valueToIndex.put(lastElement, index);
        }
        return true;
    }

    public int getRandom() {
        int index = random.nextInt(values.size());
        return values.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */