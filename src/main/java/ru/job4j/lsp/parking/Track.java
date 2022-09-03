package ru.job4j.lsp.parking;

import java.util.Objects;

public class Track implements Car {

    private int size;
    private String carNumber;
    private static final int NUMLEN = 3;

    public Track(int size, String carNumber) {
        if (size <= Sedan.SIZEOFCAR) {
            throw new IllegalArgumentException("So small for track!");
        }
        if (carNumber.length() < NUMLEN) {
            throw new IllegalArgumentException("Car number not correct");
        }
        this.size = size;
        this.carNumber = carNumber;
    }

    public Track(String carNumber) {
        this.carNumber = carNumber;
    }

    public Track() {
    }

    @Override
    public int getSizeOfCar() {
        return this.size;
    }

    @Override
    public String getNumOfCar() {
        return this.carNumber;
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
        return Objects.equals(carNumber, track.carNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carNumber);
    }
}
