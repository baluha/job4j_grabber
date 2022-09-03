package ru.job4j.lsp.parking;

import java.util.Objects;

public class Track implements Car {

    private int size;
    private String numOfCar;
    private static final int NUMLEN = 3;

    public Track(int size, String carNumber) {
        if (size <= Sedan.SIZEOFCAR) {
            throw new IllegalArgumentException("So small for track!");
        }
        if (carNumber.length() < NUMLEN) {
            throw new IllegalArgumentException("Car number not correct");
        }
        this.size = size;
        this.numOfCar = carNumber;
    }

    public Track(String carNumber) {
        this.numOfCar = carNumber;
    }

    public Track() {
    }

    @Override
    public int getSizeOfCar() {
        return this.size;
    }

    @Override
    public String getNumOfCar() {
        return this.numOfCar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Track track = (Track) o;
        return Objects.equals(numOfCar, track.numOfCar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numOfCar);
    }
}
