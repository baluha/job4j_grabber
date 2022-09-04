package ru.job4j.ood.isp;

interface Bird {
    void fly() throws Penguin.PenguinCantFlyException;
    void walk();
}

class Sparrow implements Bird {

    @Override
    public void fly() {
        System.out.println("I can fly");
    }

    @Override
    public void walk() {
        System.out.println("And i can walk");
    }
}

class Penguin implements Bird {

    @Override
    public void fly() throws PenguinCantFlyException {
        throw new PenguinCantFlyException("Hey, im bird, bud i can not fly!!");
    }

    @Override
    public void walk() {
        System.out.println("I can walk");
    }

    class PenguinCantFlyException extends Exception {
        public PenguinCantFlyException(String message) {
            super(message);
        }
    }
}
