package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        BiPredicate<T, T> pred = (t1, t2) -> comparator.compare(t1, t2) > 0;
        return getValue(value, pred);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        BiPredicate<T, T> pred = (t1, t2) -> comparator.compare(t1, t2) < 0;
        return getValue(value, pred);
    }

    private  <T> T getValue(List<T> lst, BiPredicate<T, T> predicate) {
        T value = null;
        if (lst.isEmpty()) {
            return null;
        }
        if (lst.size() >= 2) {
            value = lst.get(0);
            for (int i = 1; i < lst.size(); i++) {
                if (predicate.test(lst.get(i), value)) {
                    value = lst.get(i);
                }
            }
        }
        if (lst.size() == 1) {
            return lst.get(0);
        }
        return value;
    }
}