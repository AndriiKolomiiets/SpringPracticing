package Main;

import org.springframework.stereotype.Component;

@Component
public class ConsoleEventLogger implements EventLogger {
    public void logEvent(String message) {
        System.out.println("message: >> " + message);
    }

    public void logEvent(int id, String name) {
        System.out.println("Client: " + name + "\nID in DB: " + id);
    }

    public void logEvent(Event event) {
        System.out.println(event);
    }
}
