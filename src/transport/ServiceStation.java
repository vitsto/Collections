package transport;

import exceptions.IllegalDiagnosticException;

import java.util.LinkedList;
import java.util.Queue;

public class ServiceStation<T extends Diagnosable> {
    Queue<T> queue = new LinkedList<>();

    public void addTransport(T transport) {
        queue.offer(transport);
    }

    public void serve() {
        T transport = queue.poll();
        if (transport != null) {
            try {
                System.out.println("Запсуаем диагностику для " +  transport + "..." + transport.runDiagnostics());
            } catch (IllegalDiagnosticException exception) {
                System.out.println(exception.getMessage());
            }
            serve();
        }  else {
            System.out.println("Станция пуста");
        }
    }
}
