package transport;

import exceptions.IllegalDiagnosticException;

import java.util.LinkedList;
import java.util.Queue;

public class ServiceStation<T extends Diagnosable> {
    private final Queue<T> queue = new LinkedList<>();

    public void addTransport(T transport) {
        queue.offer(transport);
    }

    public void serve() {
        T transport = queue.poll();
        if (transport != null) {
            System.out.println("Запсуаем диагностику для " + transport + "..." + transport.runDiagnostics());
            serve();
        } else {
            System.out.println("Станция пуста");
        }
    }
}
