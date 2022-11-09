package transport;

import exceptions.IllegalDiagnosticException;
import fuel.Diesel;
import fuel.Fuel;
import transport.service.Mechanic;
import transport.types.LoadCapacity;

import java.util.ArrayList;
import java.util.List;

public class Truck extends Transport implements Competing, Diagnosable {
    private final LoadCapacity loadCapacity;
    private final List<Mechanic<? super Truck>> mechanics;

    public Truck(String brand, String model, double engineVolume, LoadCapacity loadCapacity) {
        super(brand, model, engineVolume);
        this.loadCapacity = loadCapacity;
        this.mechanics = new ArrayList<>();
    }

    public LoadCapacity getLoadCapacity() {
        return loadCapacity;
    }

    public List<Mechanic<? super Truck>> getMechanics() {
        return mechanics;
    }

    @Override
    public void getType() {
        if (loadCapacity == null) {
            System.out.println("Недостаточно данных для определения типа");
        } else {
            System.out.println("Максимальная грузоподъемность грзовика: " + loadCapacity.getLoadCapacity());
        }
    }

    @Override
    public Fuel[] getAllowedFuels() {
        return new Fuel[]{new Diesel()};
    }

    @Override
    public boolean runDiagnostics() throws IllegalDiagnosticException {
        try {
            if (getDriver().getLicense() == null) {
                throw new IllegalDiagnosticException("Необходимо указать тип прав!", getDriver());
            }
        } catch (NullPointerException exception) {
            System.out.println("Водитель не определен для " + this);
            return false;
        }

        return true;
    }

    @Override
    public void pitStop() {
        System.out.println("Меням шины грузовику");
    }

    @Override
    public double getBestTime() {
        return 17.00;
    }

    @Override
    public double getMaxSpeed() {
        return 150;
    }
}
