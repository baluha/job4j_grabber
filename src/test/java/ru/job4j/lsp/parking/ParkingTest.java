package ru.job4j.lsp.parking;

import org.junit.Test;
import static org.junit.Assert.*;

public class ParkingTest {

    @Test
    public void whenTrackParkingEmptyAndFull() {
        Parck parck = new Parking(5, 0);
        Car track = new Track(2, "aaa");
        Car track1 = new Track(2, "bbb");
        Car track2 = new Track(2, "ccc");
        assertTrue(parck.add(track1));
        parck.add(track);
        assertFalse(parck.add(track2));
    }

    @Test
    public void whenTrackInSedanPlace() {
        Parck parck = new Parking(0, 4);
        Car track = new Track(2, "aaa");
        Car track1 = new Track(2, "bbb");
        assertTrue(parck.add(track));
        assertTrue(parck.add(track1));
    }

    @Test
    public void whenCarsHaveSameNumbers() {
        Parck parck = new Parking(0, 4);
        Car track = new Track(2, "aaa");
        Car track1 = new Sedan("aaa");
        assertTrue(parck.add(track));
        assertFalse(parck.add(track1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenNumberNotCorrect() {
        Car track = new Track(2, "aa");
    }
}