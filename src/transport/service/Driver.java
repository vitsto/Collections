package transport.service;

import license.License;
import transport.Transport;

public class Driver<T extends License> {
    private final String fullName;
    private T license;
    private int experience;
    private Transport transport;


    public Driver(String fullName, T license, int experience) {
        this.fullName = fullName;
        this.license = license;
        this.experience = experience;
        this.transport = license.getTransport();
        this.transport.setDriver(this);
    }

    public String getFullName() {
        return fullName;
    }

    public T getLicense() {
        return license;
    }

    public int getExperience() {
        return experience;
    }

    public void setLicense(T license) {
        this.license = license;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void start() {
        transport.start();
    }

    public void stop() {
        transport.stop();
    }

    public void refill() {
        transport.refill();
    }

    @Override
    public String toString() {
        return "Водитель " + getFullName() + " управляет транспортом " + transport;
    }
}
