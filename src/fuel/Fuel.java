package fuel;

import transport.Transport;

public abstract class Fuel {
    public void fill(Transport t) {
        Fuel[] allowedFuels = t.getAllowedFuels();
        for (Fuel fuel : allowedFuels) {
            if (fuel.getClass().equals(this.getClass())) {
                t.setFuel(this);
                return;
            }
        }
        System.out.println("Топливо " + this + " не подходит для " + t.getBrand());
    }
}
