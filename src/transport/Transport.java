package transport;

import fuel.Fuel;
import license.License;
import utilits.Util;

import java.util.Random;

public abstract class Transport {
    private final String brand;
    private final String model;
    private Fuel fuel;
    private double engineVolume;
    private Driver<? extends License> driver;

    public Transport(String brand, String model, double engineVolume) {
        this.brand = Util.isDefine(brand) ? brand : "undefined";
        this.model = Util.isDefine(model) ? model : "undefined";
        this.engineVolume = engineVolume == 0 ? 1.5 : engineVolume;
    }

    public void setEngineVolume(double engineVolume) {
        this.engineVolume = engineVolume;
    }

    public void setDriver(Driver<? extends License> driver) {
        this.driver = driver;
    }

    public void setFuel(Fuel fuel) {
        this.fuel = fuel;
    }
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public Fuel getFuel() {
        return fuel;
    }

    public Driver<? extends License> getDriver() {
        return driver;
    }

    public void start() {
        System.out.println(getBrand() + " " + getModel() + " начал движение");
    }

    public void stop() {
        System.out.println(getBrand() + " " + getModel() + " закончил движение");
    }

    public abstract void getType();

    public final void refill() {
        setFuel(getAllowedFuels()[new Random().nextInt(getAllowedFuels().length)]);
        System.out.println("Машина заправлена " + getFuel());
    }

    public abstract Fuel[] getAllowedFuels();

    public abstract boolean runDiagnostics() throws IllegalDiagnosticException;

    @Override
    public String toString() {
        return "Марка: " + getBrand() + ", модель: " + getModel() + ", обеъм двигателя: " + getEngineVolume();
    }
}
