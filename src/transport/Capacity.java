package transport;

public enum Capacity {
    EXTRA_SMALL(10),
    SMALL(25),
    MEDIUM(50),
    LARGE(80),
    EXTRA_LARGE(120);

    private final int maxCapacity;

    Capacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }
}