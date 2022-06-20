package ru.job4j.srp;

class AreaCalc {

    public static double triangleArea(int a, int b, int c) {
        double p = trianglePerimeter(a, b, c);
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public static double trianglePerimeter(int a, int b, int c) {
        return (double) (a + b + c) / 2;
    }

    public static double squareArea(int a, int b) {
        return (a + b) * 2;
    }

    public static double squarePerimeter(int a, int b, int c, int d) {
        return a + b + c + d;
    }
}