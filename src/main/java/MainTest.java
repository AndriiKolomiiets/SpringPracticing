import Main.Event;
import Main.EventLogger;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainTest {
    int cacheSize = 3;
    Date date;
    DateFormat dateFormat;
    Event event = new Event(date,dateFormat);
    static List<Integer>  cache;

   static File file = new File("D:\\ipLogFile.txt");
    static boolean fileCreated = file.canWrite();
public static void test(){
    System.out.println(fileCreated);
}

    public static void main(String[] args) {
    test();

        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        boolean fileCreated = file.canWrite();
        System.out.println(fileCreated);
        MainTest.cache= new ArrayList<Integer>();


       /* Date date = new Date();
        DateFormat dateFormat = new DateFormat() {
            @Override
            public StringBuffer format(Date date, StringBuffer toAppendTo, FieldPosition fieldPosition) {
                return null;
            }

            @Override
            public Date parse(String source, ParsePosition pos) {
                return null;
            }
        };*/
        int cacheSize = 3;

//        Event event = new Event(date,dateFormat);
        cache.add(12);
        cache.add(12);
        cache.add(12);
        TestMethod();
        cache.add(12);
        TestMethod();
        cache.add(12);
        TestMethod();


    }

    public static void TestMethod (){
        if (cache.size() == 3) {
            writeEventsFromCache(cache);
            System.out.println("Logs were written to file (3 logs)");
            cache.clear();
        }
    }
    public static void writeEventsFromCache(List cache) {
        try {
            FileUtils.writeStringToFile(file, String.valueOf(cache), "utf-8", true);
            System.out.println("Log was written successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }
