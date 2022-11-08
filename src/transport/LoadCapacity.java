package transport;

public enum LoadCapacity {
    N1(3.5),
    N2(12),
    N3(25);

    private final double maxLoadCapacity;

    LoadCapacity(double mass) {
        this.maxLoadCapacity = mass;
    }

    public double getLoadCapacity() {
        return maxLoadCapacity;
    }

}
