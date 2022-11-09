package transport;

import exceptions.IllegalDiagnosticException;

public interface Diagnosable {
    boolean runDiagnostics() throws IllegalDiagnosticException;
}
