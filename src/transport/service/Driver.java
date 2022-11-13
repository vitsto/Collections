package transport.service;

import license.License;
import transport.Transport;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver<?> driver = (Driver<?>) o;
        return experience == driver.experience && Objects.equals(fullName, driver.fullName) && Objects.equals(license, driver.license) && Objects.equals(transport, driver.transport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, license, experience, transport);
    }
}
