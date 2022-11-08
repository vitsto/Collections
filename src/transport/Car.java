package transport;

import fuel.Diesel;
import fuel.Electricity;
import fuel.Fuel;
import fuel.Petrol;


public class Car extends Transport implements Competing {
    private final BodyType bodyType;

    public Car(String brand, String model, double engineVolume, BodyType bodyType) {
        super(brand, model, engineVolume);
        this.bodyType = bodyType;
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
        if (getDriver().getLicense() == null) {
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
