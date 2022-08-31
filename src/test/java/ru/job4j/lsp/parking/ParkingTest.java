package ru.job4j.lsp.parking;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ParkingTest {

    @Test(expected = NullPointerException.class)
    public void whenAddTooMuchSedans() {
        Parking parking = new Parking(3, 4);
        Car sedan = new Sedan();
        Car sedan1 = new Sedan();
        Car sedan2 = new Sedan();
        Car sedan3 = new Sedan();
        Car sedan4 = new Sedan();
        List<Car> cars = List.of(sedan, sedan1, sedan2, sedan3, sedan4);
        parking.add(cars);
    }

    @Test(expected = NullPointerException.class)
    public void whenAddTooMuchTracks() {
        Parking parking = new Parking(3, 4);
        Car track = new Track(2);
        Car track1 = new Track(2);
        Car track3 = new Track(3);
        List<Car> cars = List.of(track, track1, track3);
        parking.add(cars);
    }
}