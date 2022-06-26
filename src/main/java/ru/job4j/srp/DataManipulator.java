package ru.job4j.srp;

import java.util.List;

public class DataManipulator {

    private static List<Integer> lst;

    public static void getAndSave(List<Integer> list) {
        for (Integer i : list) {
            list.add(i + 1);
        }
    }

    public static void printSomeData() {
        for (Integer i: lst) {
            if (i % 2 != 0) {
                System.out.println(i);
            }
        }
    }
}
