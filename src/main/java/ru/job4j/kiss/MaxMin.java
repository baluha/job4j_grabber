package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        return value.stream().max(comparator).orElse(null);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return value.stream().max(comparator).orElse(null);
    }

}