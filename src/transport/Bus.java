package transport;

import fuel.Diesel;
import fuel.Fuel;
import fuel.Petrol;

public class Bus extends Transport implements Competing {
    private final Capacity capacity;

    public Bus(String brand, String model, double engineVolume, Capacity capacity) {
        super(brand, model, engineVolume);
        this.capacity = capacity;
    }

    public Capacity getCapacity() {
        return capacity;
    }

    @Override
    public void getType() {
        if (capacity == null) {
            System.out.println("Недостаточно данных для определения типа");
        } else {
            System.out.println("Максимальная вместимость автобуса: " + capacity.getMaxCapacity());
        }
    }

    public Fuel[] getAllowedFuels() {
        return new Fuel[]{new Petrol(), new Diesel()};
    }

    @Override
    public boolean runDiagnostics(){
        System.out.println("Автобус " + this + " в диагностике не требуется");
        return true;
    }

    @Override
    public void pitStop() {
        System.out.println("Меняем шины автобусу");
    }

    @Override
    public double getBestTime() {
        return 12.11;
    }

    @Override
    public double getMaxSpeed() {
        return 123;
    }
}
