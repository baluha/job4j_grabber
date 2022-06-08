package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        value.sort(comparator);
        return getValue(value);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        value.sort(comparator);
        return getValue(value);
    }

    private  <T> T getValue(List<T> lst) {
        return lst.isEmpty() ? null : lst.get(0);
    }
}