package transport;

import exceptions.IllegalDiagnosticException;
import fuel.Diesel;
import fuel.Electricity;
import fuel.Fuel;
import fuel.Petrol;
import transport.service.Mechanic;
import transport.types.BodyType;

import java.util.ArrayList;
import java.util.List;


public class Car extends Transport implements Competing, Diagnosable {
    private final BodyType bodyType;
    private final List<Mechanic<? super Car>> mechanics;

    public Car(String brand, String model, double engineVolume, BodyType bodyType) {
        super(brand, model, engineVolume);
        this.bodyType = bodyType;
        this.mechanics = new ArrayList<>();
    }

    public List<Mechanic<? super Car>> getMechanics() {
        return mechanics;
    }

    @Override
    public void getType() {
        if (bodyType == null) {
            System.out.println("Недостаточно данных для определения типа");
        } else {
            System.out.println("Тип кузова машины: " + bodyType.getBodyType());
        }
    }

    public Fuel[] getAllowedFuels() {
        return new Fuel[]{new Petrol(), new Diesel(), new Electricity()};
    }

    @Override
    public boolean runDiagnostics() throws IllegalDiagnosticException {
        if (getDriver() == null || getDriver().getLicense() == null) {
            throw new IllegalDiagnosticException("Необходимо указать тип прав!", getDriver());
        }
        return true;
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    @Override
    public void pitStop() {
        System.out.println("Меняем шины легковушке");
    }

    @Override
    public double getBestTime() {
        return 15.23;
    }

    @Override
    public double getMaxSpeed() {
        return 201;
    }

}
