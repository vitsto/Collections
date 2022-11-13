import license.LicenseB;
import license.LicenseC;
import license.LicenseD;
import sponsors.Contributor;
import sponsors.LegalEntity;
import sponsors.PrivatePerson;
import transport.*;
import transport.service.Mechanic;
import transport.types.BodyType;
import transport.types.Capacity;
import transport.service.Driver;
import transport.types.LoadCapacity;

import java.util.*;

public class Tester {
    public static void main(String[] args) {
        Set<Car> cars = new HashSet<>(List.of(initializeCars()));
        Set<Bus> buses = new HashSet<>(List.of(initializeBuses()));
        Set<Truck> trucks = new HashSet<>(List.of(initializeTrucks()));

        System.out.println(cars);
        System.out.println(buses);
        System.out.println(trucks);

    }

    private static Truck[] initializeTrucks() {
        return new Truck[]{
                new Truck("Грузовик 1", "модель 1", 3.5, LoadCapacity.N1),
                new Truck("Грузовик 2", "модель 2", 4.0, LoadCapacity.N2),
                new Truck("Грузовик 3", "модель 3", 2.2, LoadCapacity.N3),
                new Truck("Грузовик 4", "модель 4", 3.0, LoadCapacity.N1),
        };
    }

    private static Bus[] initializeBuses() {
        return new Bus[]{
                new Bus("Автобус 1", "модель 1", 3.0, Capacity.EXTRA_SMALL),
                new Bus("Автобус 2", "модель 2", 5.0, Capacity.MEDIUM),
                new Bus("Автобус 3", "модель 3", 2.8, Capacity.SMALL),
                new Bus("Автобус 4", "модель 4", 6.2, Capacity.LARGE),
        };
    }

    public static Car[] initializeCars() {
        return new Car[]{
                new Car("Toyota", "Camri", 2.5, BodyType.SEDAN),
                new Car("Mercedes", "Benz", 3.2, BodyType.COUPE),
                new Car("Kia", "Rio", 1.7, BodyType.HATCHBACK),
                new Car("Toyota", "Vitz", 0.7, BodyType.HATCHBACK)
        };
    }
}
