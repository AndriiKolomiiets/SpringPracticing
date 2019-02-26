import Main.Event;
import Main.EventLogger;
import javafx.scene.input.DataFormat;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.text.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainTest {
    static int time3 = DateFormat.HOUR_OF_DAY1_FIELD;
    static int time2 = DateFormat.HOUR_OF_DAY1_FIELD;
    static int time1 = DateFormat.HOUR_OF_DAY0_FIELD;
    static LocalTime time = LocalTime.now();

    public static void main(String[] args) {
        System.out.println(time1);
        System.out.println(time2);
        isDay(5,17);
    }
    public static boolean isDay(int start, int end) {
        int currentTime = time.getHour();

        return time.getHour() > start && time.getHour() < end;
    }
    }
