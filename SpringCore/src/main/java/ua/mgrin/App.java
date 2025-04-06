package ua.mgrin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class App{
    @Autowired
    private Client client;

    private EventLogger eventLogger;
    private Map<EventType, EventLogger> loggers;
    private final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    public App(Client client, EventLogger eventLogger, Map<EventType, EventLogger> loggers) {
        this.client = client;
        this.eventLogger = eventLogger;
        this.loggers = loggers;
    }

    private void logEvent(EventType type, String msg){
//        Event event = new Event(new Date(), df);
//        event.setMsg(msg.replace(client.getId(), client.getFullName()));
//        System.out.println("Logging event with type: " + (type != null ? type : "null"));
//        EventLogger logger = (type != null && loggers.containsKey(type)) ? loggers.get(type) : eventLogger;
//        System.out.println("Using logger: " + (logger != null ? logger.getClass().getSimpleName() : "None"));
//        logger.logEvent(event);
        Event event = new Event(new Date(), df);
        event.setMsg(msg.replace(client.getId(), client.getFullName()));
        EventLogger logger = (type != null && loggers.containsKey(type)) ? loggers.get(type) : eventLogger;

        logger.logEvent(event);
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) ctx.getBean("app");
        System.out.println(app.client.getGreeting());

        app.logEvent(null, "Some event for user null");
        app.logEvent(EventType.INFO,"Some event for user info") ;
        app.logEvent(EventType.ERROR,"Some event for user error");
        app.logEvent(null,"Some event for user null");
        app.logEvent(EventType.INFO,"Some event for user info");
        app.logEvent(EventType.ERROR,"Some event for user error");
        ctx.close();
    }

}
