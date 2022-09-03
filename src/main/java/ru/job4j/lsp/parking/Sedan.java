package ru.job4j.lsp.parking;

import java.util.Objects;

public class Sedan implements Car {

    public static final int SIZEOFCAR = 1;
    private String carNumber;
    private static final int NUMLEN = 3;

    public Sedan(String carNumber) {
        if (carNumber.length() < NUMLEN) {
            throw new IllegalArgumentException("Car number not correct");
        }
        this.carNumber = carNumber;
    }

    public Sedan() {
    }

    @Override
    public int getSizeOfCar() {
        return SIZEOFCAR;
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
        Sedan sedan = (Sedan) o;
        return Objects.equals(carNumber, sedan.carNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carNumber);
    }
}
