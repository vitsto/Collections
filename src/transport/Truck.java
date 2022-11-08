package transport;

import fuel.Diesel;
import fuel.Fuel;

public class Truck extends Transport implements Competing{
    private final LoadCapacity loadCapacity;

    public Truck(String brand, String model, double engineVolume, LoadCapacity loadCapacity) {
        super(brand, model, engineVolume);
        this.loadCapacity = loadCapacity;
    }

    public LoadCapacity getLoadCapacity() {
        return loadCapacity;
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
        return new Fuel[] {new Diesel()};
    }

    @Override
    public boolean runDiagnostics() throws IllegalDiagnosticException {
        if (getDriver().getLicense() == null) {
            throw new IllegalDiagnosticException("Необходимо указать тип прав!", getDriver());
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
