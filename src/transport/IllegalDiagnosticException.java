package transport;

import license.License;

public class IllegalDiagnosticException extends Exception{
    private Driver<? extends License> driver;

    public IllegalDiagnosticException(String message, Driver<? extends License> driver) {
        super(message);
        this.driver = driver;
    }

    public Driver<? extends License> getDriver() {
        return driver;
    }
}
