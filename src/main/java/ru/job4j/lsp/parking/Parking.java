package ru.job4j.lsp.parking;
import java.util.HashSet;
import java.util.Set;

public class Parking implements Parck {
    private Set<Car> tracks = new HashSet<>();
    private Set<Car> sedan = new HashSet<>();
    private int sizeParckTrack;
    private int sizeParckSedan;

    public Parking(int sizeParckTrack, int sizeParckSedan) {
        this.sizeParckTrack = sizeParckTrack;
        this.sizeParckSedan = sizeParckSedan;
    }

    private boolean placeValidator(Car car) {
        boolean rsl = true;
        for (Car cars : tracks) {
            if(cars.getNumOfCar().equals(car.getNumOfCar())) {
                rsl = false;
            }
        }
        for (Car cars : sedan) {
            if(cars.getNumOfCar().equals(car.getNumOfCar())) {
                rsl = false;
            }
        }
        return rsl;
    }

    private boolean sizeValidator(Car car) {
        if (car.getSizeOfCar() == 1 && sizeParckSedan > 0 && placeValidator(car)) {
            return true;
        } else {
            return (car.getSizeOfCar() > 1
                    && sizeParckTrack >= car.getSizeOfCar()
                    && placeValidator(car))
                    || (car.getSizeOfCar() > 1
                    && sizeParckSedan >= car.getSizeOfCar()
                    && placeValidator(car));
        }
    }

    public boolean add(Car car) {
        boolean rsl = false;
        if (car.getSizeOfCar() == 1
                && sizeParckSedan > 0
                && sizeValidator(car)) {
            sizeParckSedan = sizeParckSedan - car.getSizeOfCar();
            rsl = sedan.add(car);
        } else if (car.getSizeOfCar() > 1
                && sizeParckTrack >= car.getSizeOfCar()
                && sizeValidator(car)) {
            sizeParckTrack = sizeParckTrack - car.getSizeOfCar();
            rsl = tracks.add(car);
        } else if (car.getSizeOfCar() > 1
                && sizeParckTrack < car.getSizeOfCar()
                && getSizeParckSedan() >= car.getSizeOfCar()
                && sizeValidator(car)) {
            sizeParckSedan = sizeParckSedan - car.getSizeOfCar();
            rsl = sedan.add(car);
        }
        return rsl;
    }

    public HashSet<Car> getTracks() {
        return new HashSet<>(tracks);
    }

    public HashSet<Car> getSedans() {
        return new HashSet<>(sedan);
    }

    public int getSizeParckTrack() {
        return sizeParckTrack;
    }

    public int getSizeParckSedan() {
        return sizeParckSedan;
    }
}
