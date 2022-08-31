package ru.job4j.lsp.liskov;

public class SomeCar {
    public void ride(int speed) {
        if (speed > 1000) {
            throw new IllegalArgumentException("Car cannot ride so fast!!! " + " Exception from SomeCar");
        }
        System.out.println("Car ride with speed " + speed + " km!!");
    }

    class SuperCar extends SomeCar {
        public void ride(int speed) {
            if (speed > 1002) {
                throw new IllegalArgumentException("Car cannot ride so fast!!!");
            }
            System.out.println("Car ride with speed " + speed + " km!!");
        }
    }
}

class Test {
    public static void main(String[] args) {
        SomeCar someCar = new SomeCar();
        someCar.ride(4);
        SomeCar superCar = new SomeCar();
        superCar.ride(1001);
    }
}
