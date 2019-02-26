package Main;

import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.Random;

@Component
public class Event {
    int id;
    Date date;
    DateFormat dateFormat;
    static LocalTime time = LocalTime.now();

    public Event(Date date, DateFormat dateFormat) {
        Random random = new Random();
        id = random.nextInt(100);
        this.date = date;
        this.dateFormat = dateFormat;
    }

    public static boolean isDay(int start, int end) {
        return time.getHour() > start && time.getHour() < end;
    }

    @Override
    public String toString() {
        return "Event ID: " + this.id + ", Date: " + dateFormat.format(date) + "\n";
    }
}
