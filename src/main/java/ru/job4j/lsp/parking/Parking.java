package ru.job4j.lsp.parking;
import java.util.HashSet;
import java.util.Set;

public class Parking implements Parck {
    private Set<Car> tracks;
    private Set<Car> sedan;
    private int sizeParckTrack;
    private int sizeParckSedan;

    public Parking(int sizeParckSedan, int sizeParckTrack) {
        this.sizeParckSedan = sizeParckSedan;
        this.sizeParckTrack = sizeParckTrack;
        tracks = new HashSet<>();
        sedan = new HashSet<>();
    }

    private boolean placeValidator(Car car) {
        for (Car cars : tracks) {
            if (cars.getNumOfCar().equals(car.getNumOfCar())) {
                return false;
            }
        }
        for (Car cars : sedan) {
            if (cars.getNumOfCar().equals(car.getNumOfCar())) {
                return false;
            }
        }
        return true;
    }

    private boolean sizeValidator(Car car) {
        if (placeValidator(car)) {
            if (car.getSizeOfCar() == Sedan.SIZEOFCAR && sizeParckSedan > 0) {
                return true;
            } else {
                return (car.getSizeOfCar() > Sedan.SIZEOFCAR
                        && sizeParckTrack >= car.getSizeOfCar())
                        || (car.getSizeOfCar() > Sedan.SIZEOFCAR
                        && sizeParckSedan >= car.getSizeOfCar());
            }
       }
        return false;
    }


    public boolean add(Car car) {
        boolean rsl = false;
        if (sizeValidator(car)) {
            if (car.getSizeOfCar() == Sedan.SIZEOFCAR
                    && sizeParckSedan > 0) {
                sizeParckSedan--;
                rsl = sedan.add(car);
            } else if (car.getSizeOfCar() > Sedan.SIZEOFCAR
                    && sizeParckTrack >= car.getSizeOfCar()) {
                sizeParckTrack = sizeParckTrack - car.getSizeOfCar();
                rsl = tracks.add(car);
            } else if (car.getSizeOfCar() > Sedan.SIZEOFCAR
                    && sizeParckTrack < car.getSizeOfCar()
                    && getSizeParckSedan() >= car.getSizeOfCar()) {
                sizeParckSedan = sizeParckSedan - car.getSizeOfCar();
                rsl = sedan.add(car);
            }
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
