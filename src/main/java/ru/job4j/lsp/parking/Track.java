package ru.job4j.lsp.parking;

public class Track implements Car {

    private int size;

    public Track(int size) {
        this.size = size;
    }

    @Override
    public int getSizeOfCar() {
        return this.size;
    }
}
