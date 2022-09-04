package ru.job4j.ood.isp;

public interface Device {
    void makePhoto();
    void makeCall();
    void writeMassage();
}

class Phone implements Device {


    @Override
    public void makePhoto() {
        System.out.println("I can make photo");
    }

    @Override
    public void makeCall() {
        System.out.println("I can call somebody");
    }

    @Override
    public void writeMassage() {
        System.out.println("I can send massage");
    }
}


class Camera implements Device {

    @Override
    public void makePhoto() {
        System.out.println("I need for making photo");
    }

    @Override
    public void makeCall() {
        System.out.println("I cann not do that!");
    }

    @Override
    public void writeMassage() {
        System.out.println("I cann not do that!");
    }
}


