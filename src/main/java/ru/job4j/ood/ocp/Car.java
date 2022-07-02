package ru.job4j.ood.ocp;

class Main {
    public static void main(String[] args) {
    Car car = new SoundCar();
    Car car1 = new NoSoundCar();
    CarSignal carSignal = new CarSignal();
    carSignal.main(car);
    carSignal.main(car1);
    }
}

class CarSignal {
    public void main(Car car) {
        if (car instanceof SoundCar) {
            signalCar();
        } else {
            noSignalCar();
        }
    }

    public void signalCar() {
        System.out.println("Beeep!!");
    }

    public void noSignalCar() {
        System.out.println("**Only silence**");
    }
}

public interface Car {
}

class NoSoundCar implements Car {
}

class SoundCar implements Car {
}
