package transport;

import fuel.Diesel;
import fuel.Fuel;
import fuel.Petrol;
import transport.service.Mechanic;
import transport.types.Capacity;

import java.util.ArrayList;
import java.util.List;

public class Bus extends Transport implements Competing {
    private final Capacity capacity;
    private final List<Mechanic<? super Bus>> mechanics;

    public Bus(String brand, String model, double engineVolume, Capacity capacity) {
        super(brand, model, engineVolume);
        this.capacity = capacity;
        this.mechanics = new ArrayList<>();
    }

    public Capacity getCapacity() {
        return capacity;
    }

    public List<Mechanic<? super Bus>> getMechanics() {
        return mechanics;
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
