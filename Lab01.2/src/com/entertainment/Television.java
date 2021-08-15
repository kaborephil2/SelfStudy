package com.entertainment;

public class Television {
    private String brand;
    private int volume;
    private Tuner tuner = new Tuner(); //instantiated internally

    public Television(String brand, int volume) {
        setBrand(brand);
        setVolume(volume);
    }

    public Television() {

    }

    //Business methods
    public int getCurrentChannel() {
        return tuner.getChannel(); //delegate to contained Tuner object
    }

    public void changeChannel( int channel) {
        tuner.setChannel(channel); // delegate to contained Tuner object
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "[brand= " + getBrand() +
                ", volume= " + getVolume() + ", currentChannel= " + getCurrentChannel() + "]";
    }
}