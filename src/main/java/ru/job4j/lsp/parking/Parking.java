package ru.job4j.lsp.parking;

import java.util.ArrayList;
import java.util.List;

public class Parking implements Parck {
    private List<Car> cars = new ArrayList<>();
    private int sizeParckTrack;
    private int sizeParckSedan;

    public Parking(int sizeParckTrack, int sizeParckSedan) {
        this.sizeParckTrack = sizeParckTrack;
        this.sizeParckSedan = sizeParckSedan;
    }

    private void sizeValidator(Car car) {
        if ((sizeParckSedan - car.getSizeOfCar()) < 0) {
            throw new NullPointerException();
        }
    }

    public void add(List<Car> lst) {
        lst.forEach(c -> {
            sizeValidator(c);
            if (c.getSizeOfCar() > 1 &&  ((sizeParckTrack - c.getSizeOfCar()) >= 0)) {
               cars.add(c);
               setSizeParckTrack(sizeParckTrack - c.getSizeOfCar());
            } else {
                cars.add(c);
                setSizeParckSedan(sizeParckSedan - c.getSizeOfCar());
            }

        });
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getSizeParckTrack() {
        return sizeParckTrack;
    }

    public void setSizeParckTrack(int sizeParckTrack) {
        this.sizeParckTrack = sizeParckTrack;
    }

    public int getSizeParckSedan() {
        return sizeParckSedan;
    }

    public void setSizeParckSedan(int sizeParckSedan) {
        this.sizeParckSedan = sizeParckSedan;
    }
}
