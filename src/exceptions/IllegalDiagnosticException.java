package exceptions;

import license.License;
import transport.service.Driver;

public class IllegalDiagnosticException extends RuntimeException{
    private Driver<? extends License> driver;

    public IllegalDiagnosticException(String message, Driver<? extends License> driver) {
        super(message);
        this.driver = driver;
    }

    public Driver<? extends License> getDriver() {
        return driver;
    }
}
