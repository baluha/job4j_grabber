package ru.job4j.lsp.liskov;

public class FlyVehicle {
    int high;

    public void fly() {
        System.out.println("Im flying on a " + high + " metres");
    }

}

class Helicopter extends FlyVehicle {
    int high;

    public void fly() {
        if (high < 5000) {
            throw  new IllegalArgumentException("Helicopter cannot fly so high!!");
        }
        System.out.println("Im flying on a " + high + " metres");
    }
}


class TestClass {
    public static void main(String[] args) {
        FlyVehicle fl = new Helicopter();
        fl.high = 5001;
        fl.fly();
    }
}
