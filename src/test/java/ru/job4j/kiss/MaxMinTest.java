package ru.job4j.kiss;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MaxMinTest {


    @Test
    public void maxValueTest() {
        List<Integer> lst = new ArrayList<>();
        lst.add(1);
        lst.add(5);
        lst.add(8);
        lst.add(4);
        lst.add(2);
        MaxMin mn = new MaxMin();
        Assert.assertThat(8, is(mn.max(lst, Comparator.reverseOrder())));
    }

    @Test
    public void minValueTest() {
        List<Integer> lst = new ArrayList<>();
        lst.add(1);
        lst.add(5);
        lst.add(8);
        lst.add(4);
        lst.add(2);
        MaxMin mn = new MaxMin();
        Assert.assertThat(1, is(mn.max(lst, Comparator.naturalOrder())));
    }

    @Test
    public void minStringValue() {
        List<String> lst = new ArrayList<>();
        lst.add("Petia");
        lst.add("Vasia");
        lst.add("Semen");
        lst.add("Grigori");
        MaxMin mn = new MaxMin();
        Assert.assertThat("Grigori", is(mn.max(lst, Comparator.naturalOrder())));
    }

    @Test
    public void maxStringValue() {
        List<String> lst = new ArrayList<>();
        lst.add("Petia");
        lst.add("Vasia");
        lst.add("Semen");
        lst.add("Grigori");
        MaxMin mn = new MaxMin();
        Assert.assertThat("Vasia", is(mn.max(lst, Comparator.reverseOrder())));
    }
}