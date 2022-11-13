import exceptions.CheckAuthorization;
import exceptions.IllegalDiagnosticException;
import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;
import license.LicenseB;
import license.LicenseC;
import license.LicenseD;
import transport.*;
import transport.types.BodyType;
import transport.types.Capacity;
import transport.service.Driver;
import transport.types.LoadCapacity;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("Toyota", "Camri", 2.5, BodyType.SEDAN);
        Car car2 = new Car("Mercedes", "Benz", 3.2, BodyType.COUPE);
        Car car3 = new Car("Kia", "Rio", 1.7, BodyType.HATCHBACK);
        Car car4 = new Car("Toyota", "Vitz", 0.7, BodyType.HATCHBACK);
        car2.pitStop();
        System.out.println(car1.getBestTime());
        car1.getType();
        car2.getType();
        car3.getType();
        car4.getType();

        Bus bus1 = new Bus("бренд 1", "модель 1", 3.0, Capacity.EXTRA_SMALL);
        Bus bus2 = new Bus("бренд 2", "модель 2", 5.0, Capacity.MEDIUM);
        Bus bus3 = new Bus("бренд 3", "модель 3", 2.8, Capacity.SMALL);
        Bus bus4 = new Bus("бренд 4", "модель 4", 6.2, Capacity.LARGE);
        bus2.pitStop();
        System.out.println(bus1.getBestTime());
        bus1.getType();
        bus2.getType();
        bus3.getType();
        bus4.getType();

        Truck truck1 = new Truck("бренд 1", "модель 1", 3.5, LoadCapacity.N1);
        Truck truck2 = new Truck("бренд 2", "модель 2", 4.0, LoadCapacity.N2);
        Truck truck3 = new Truck("бренд 3", "модель 3", 2.2, LoadCapacity.N3);
        Truck truck4 = new Truck("бренд 4", "модель 4", 3.0, LoadCapacity.N1);
        truck1.getType();
        truck2.getType();
        truck3.getType();
        truck4.getType();
        truck2.pitStop();
        System.out.println(truck1.getBestTime());

        System.out.println("\n\nГОНКА");
        Driver<LicenseB> ivanov = new Driver<>("Иванов Иван Иванович", new LicenseB(car1), 10);
        ivanov.start();
        ivanov.refill();
        ivanov.stop();
        System.out.println(ivanov + "\n");


        Driver<LicenseC> petrov = new Driver<>("Петров Петр Петрович", new LicenseC(truck1), 5);
        petrov.start();
        petrov.refill();
        petrov.stop();
        System.out.println(petrov + "\n");

        Driver<LicenseD> sidorov = new Driver<>("Сидоров Сидор Сидорович", new LicenseD(bus1), 4);
        sidorov.start();
        sidorov.refill();
        sidorov.stop();
        System.out.println(sidorov + "\n");

        petrov.setLicense(null);
        try {
            System.out.println("Диагностика машины " + car1 + ": " + car1.runDiagnostics());
            System.out.println("Диагностика грузовика " + truck4 + ": " + truck1.runDiagnostics());

        } catch (IllegalDiagnosticException e) {
            System.out.println(e.getMessage() + " y " + e.getDriver());
        }


        System.out.println("\nПроверка логина и пароля");
        // Задание 1
        try {
            String login = "logIN";
            String password = "pass";
            String confirmPassword = "pass";
            System.out.println(CheckAuthorization.checkAuthorization(login, password, confirmPassword));
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
        }

    }
}