package Main;

import org.springframework.stereotype.Component;

@Component
public interface EventLogger {
    void logEvent(String message);
    void logEvent(int id, String name);
    void logEvent(Event event);

}
