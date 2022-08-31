package ru.job4j.lsp.parking;

import java.util.List;

public class TestClass {
    public static void main(String[] args) {
        Car track = new Track(2);
        Car track2 = new Track(2);
        Car track3 = new Track(2);
        Car track4 = new Track(3);
        Car sedan = new Sedan();

        List<Car> carList = List.of(track, track2, track4, track3, sedan);
        System.out.println(track.getSizeOfCar());
        System.out.println(sedan.getSizeOfCar());
        Parking parking = new Parking(10, 3);
        parking.add(carList);
        System.out.println(parking.getSizeParckTrack());
        System.out.println(parking.getSizeParckSedan());
    }
}
