package Main;

import org.springframework.context.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class App {
    private Client client;
    private EventLogger eventLogger;
    private Event event;
    private Map<EventType, EventLogger> loggers;
    private EventLogger defaultLogger;

    public static ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml", "loggers.xml");

    public App() {
        client = context.getBean(Client.class);
//        eventLogger = new ConsoleEventLogger();
//        eventLogger = new FileEventLogger();
        eventLogger = new CacheFileEventLogger(5);
    }

    public App(int id, String name) {
        client = context.getBean(Client.class);
//       eventLogger = context.getBean(ConsoleEventLogger.class);
//       eventLogger = context.getBean(FileEventLogger.class);
        eventLogger = context.getBean(CacheFileEventLogger.class);
    }

    public App(Client client, EventLogger eventLogger, Map<EventType, EventLogger> loggers) {
        super();
        this.client = client;
        this.defaultLogger = eventLogger;
        this.loggers = loggers;
    }

    private void logEvent(String message) {

/*        eventLogger.logEvent(client.getId(), client.getFullName());

        eventLogger.logEvent(message);*/

        eventLogger.logEvent(context.getBean(Event.class));
    }

    private void logEvent(EventType type, String message) {

        EventLogger logger = loggers.get(type);
        /*
        if(type == EventType.ERROR){
            logger = context.getBean(CombinedEventLogger.class);
        }else if (type==EventType.INFO) {
        logger = context.getBean(ConsoleEventLogger.class);
        }
        */
        if (logger == null) {
            logger = defaultLogger;
        }
        logger.logEvent(message);
    }


    public void shutdownContext() {
        ((ConfigurableApplicationContext) context).close();
    }

    public static void main(String[] args) {
        /*App app = new App(12, "Josh");*/
//        App app = new App(0, "this string will be replaced from spring.xml");
/*        app.logEvent("Log was written successfully!\n ");
        app.logEvent("Test log #2\n ");
        app.logEvent("Test log #3\n ");
        app.logEvent("Test log #4\n ");*/
        App app = context.getBean(App.class);
        app.logEvent(EventType.ERROR, "Log#1");
        app.logEvent(EventType.INFO, "Log#2");
        app.logEvent(null, "Log#3");
        app.logEvent(EventType.INFO, "Log#4");
        app.logEvent(EventType.INFO, "Log#5");
        app.logEvent(EventType.ERROR, "Log#6");
        app.logEvent(EventType.INFO, "Log#7");

        app.shutdownContext();
    }
}
