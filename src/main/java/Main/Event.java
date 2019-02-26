package Main;

import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.util.Date;
import java.util.Random;

@Component
public class Event {
    int id;
    Date date;
    DateFormat dateFormat;


    public Event(Date date, DateFormat dateFormat) {
        Random random = new Random();
        id = random.nextInt(100);
        this.date = date;
        this.dateFormat = dateFormat;

    }

    @Override
    public String toString() {
        return "Event ID: " + this.id + ", Date: " + dateFormat.format(date) + "\n";
    }
}
