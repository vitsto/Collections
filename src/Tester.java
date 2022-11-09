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
        List<Car> cars = new ArrayList<>(List.of(initializeCars()));
        List<Bus> buses = new ArrayList<>(List.of(initializeBuses()));
        List<Truck> trucks = new ArrayList<>(List.of(initializeTrucks()));

        System.out.println("\n\nГОНКА");
        Driver<LicenseB> ivanov = new Driver<>("Иванов Иван Иванович", new LicenseB(cars.get(0)), 10);
        Driver<LicenseC> petrov = new Driver<>("Петров Петр Петрович", new LicenseC(trucks.get(0)), 5);
        Driver<LicenseD> sidorov = new Driver<>("Сидоров Сидор Сидорович", new LicenseD(buses.get(0)), 4);

        Contributor contributor1 = new PrivatePerson("Скрудж Макдак", 1250);
        Contributor contributor2 = new PrivatePerson("Дональд Дак", 2150);
        Contributor contributor3 = new LegalEntity("ООО \"Рога и Копыта\"", 4200);
        Contributor contributor4 = new LegalEntity("ОАО \"Oil Trade\"", 5500);

        cars.get(0).getContributors().addAll(Arrays.asList(contributor1, contributor3));
        cars.get(1).getContributors().add(contributor1);
        cars.get(2).getContributors().add(contributor3);

        trucks.get(0).getContributors().addAll(Arrays.asList(contributor2, contributor4, contributor3));
        trucks.get(1).getContributors().add(contributor1);
        trucks.get(2).getContributors().add(contributor2);

        buses.get(0).getContributors().add(contributor3);
        buses.get(1).getContributors().add(contributor4);

        cars.forEach(car -> {
            System.out.println("СПОНСОРЫ МАШИНЫ: " + car + " :");
            car.getContributors().forEach(System.out::println);
            System.out.println("-------------------------------");
        });

        Mechanic<Transport> mechanic1 = new Mechanic<>("Джон Смит", "Автоленд"); //
        Mechanic<Car> mechanic2 = new Mechanic<>("Фрейд Рурк", "Гараж Экстрим");
        Mechanic<Truck> mechanic3 = new Mechanic<>("Джеймс Картер", "Карбокс");
        Mechanic<Bus> mechanic4 = new Mechanic<>("Филипп Свон", "ТурбоКар");

        //тестируем механизм добавления механиков
        Car car = cars.get(0);
        Bus bus = buses.get(0);
        Truck truck = trucks.get(0);

        car.getMechanics().add(mechanic1);
        car.getMechanics().add(mechanic2);
        System.out.println(car + " имеет механиков: ");
        car.getMechanics().forEach(System.out::println);
        System.out.println();

        bus.getMechanics().add(mechanic1);
        bus.getMechanics().add(mechanic4);
        System.out.println(bus + " имеет механиков: ");
        bus.getMechanics().forEach(System.out::println);
        System.out.println();

        truck.getMechanics().add(mechanic1);
        truck.getMechanics().add(mechanic3);
        System.out.println(truck + " имеет механиков: ");
        truck.getMechanics().forEach(System.out::println);
        System.out.println();

        //тестирем обслуживание и ремонт машины
        mechanic1.serve(car);
        mechanic3.serve(truck);
        mechanic2.repair(car);
        mechanic4.repair(bus);

        //Работа со СТО
        ServiceStation<Diagnosable> station = new ServiceStation<>();
        cars.forEach(station::addTransport);
        station.serve();

        trucks.forEach(station::addTransport);
        station.serve();

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
