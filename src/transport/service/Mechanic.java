package transport.service;

import transport.Transport;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Mechanic<T extends Transport> {
    private final String fullName;
    private String company;

    public Mechanic(String fullName, String company) {
        this.fullName = fullName;
        this.company = company;
    }

    public String getFullName() {
        return fullName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void serve(T transport) {
        System.out.println(getFullName() + "обслуживает транспорт: " + transport.getBrand() + " " + transport.getModel());
    }

    public void repair(T transport) {
        System.out.println(getFullName() + " чинит транспорт: " + transport.getBrand() + " " + transport.getModel());
    }

    @Override
    public String toString() {
        return "Имя: " + getFullName() + ", компания: " + getCompany();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mechanic<?> mechanic = (Mechanic<?>) o;
        return Objects.equals(fullName, mechanic.fullName) && Objects.equals(company, mechanic.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, company);
    }
}
