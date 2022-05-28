package ru.job4j.gc;

public class Test {
    public static void main(String[] args) throws Throwable {
        Runtime runtime = Runtime.getRuntime();
        System.out.println(runtime.freeMemory());
        System.out.println(runtime.totalMemory());
        for (int i = 0; i < 7500; i++) {
            new User(i, i + " Name");
        }
        System.gc();
        System.out.println(runtime.freeMemory());
        System.out.println(runtime.totalMemory());

    }

}
