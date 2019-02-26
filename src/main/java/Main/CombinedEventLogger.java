package Main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CombinedEventLogger implements EventLogger {

/*    ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
    FileEventLogger fileEventLogger;
    ConsoleEventLogger consoleEventLogger;*/
    List<EventLogger> loggers;

    public CombinedEventLogger(List<EventLogger> loggers) {
        this.loggers = loggers;
    }

    @Override
    public void logEvent(String message) {
        for (EventLogger logger : loggers) {
            logger.logEvent(message);
        }
        /*getInstanceOfLoggers();
        fileEventLogger.logEvent(message);
        consoleEventLogger.logEvent(message);*/
    }

    @Override
    public void logEvent(int id, String name) {
        for (EventLogger logger : loggers) {
            logger.logEvent(id, name);
        }
        /*getInstanceOfLoggers();
        fileEventLogger.logEvent(id, name);
        consoleEventLogger.logEvent(id, name);*/
    }

    @Override
    public void logEvent(Event event) {
        for (EventLogger logger : loggers) {
            logger.logEvent(event);
        }
        /*getInstanceOfLoggers();
        fileEventLogger.logEvent(event);
        consoleEventLogger.logEvent(event);*/
    }

   /* private void getInstanceOfLoggers() {
        fileEventLogger = context.getBean(FileEventLogger.class);
        consoleEventLogger = context.getBean(ConsoleEventLogger.class);
    }*/
}
