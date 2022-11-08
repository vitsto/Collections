package license;

import transport.Transport;

public abstract class License {
    private final Transport transport;
    private final char category;

    public License(Transport transport, char category) {
        this.transport = transport;
        this.category = category;
    }

    public Transport getTransport() {
        return transport;
    }

    public char getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Категория: " + category + ", транспорт: " + transport.getClass();
    }
}
