package Main;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Random;

@Component
public class FileEventLogger implements EventLogger {

    /*java.io.File file = new File("D:\\ip.txt");*/
    java.io.File file;
    String path;
    String data;
    boolean append = true;

    public void init() {
        Random random = new Random();
        int id = random.nextInt(100);
        this.file = new File("D:\\ipLogFile" + id + ".txt");
        boolean fileCreated = file.canWrite();
        if (fileCreated != true) {
            System.out.println("File was created successfully!");
        } else {
            System.out.println("Something went wrong...\nFile wasn't created.");
        }
    }

    public FileEventLogger(String path) {
        this.path = path;
    }

    public FileEventLogger() {
        this.path = "D:\\ipLogFile.txt";
    }


    public void logEvent(String message) {
 /*       Random random = new Random();
        int id = random.nextInt(100);
        this.fileName = "LogFile# "+ id;*/
        try {
            FileUtils.writeStringToFile(file, message, "utf-8", append);
            System.out.println("Log was written successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void logEvent(int id, String name) {

        String message = "Client: " + name + "\nID in DB: " + id + "\n.";
        try {
            FileUtils.writeStringToFile(file, message, "utf-8", append);
            System.out.println("Log was written successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void logEvent(Event event) {

        try {
            FileUtils.writeStringToFile(file, String.valueOf(event), "utf-8", append);
            System.out.println("Log was written successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void logEvent(List eventList) {

            try {
                FileUtils.writeStringToFile(file, String.valueOf(eventList),  "utf-8");
                System.out.println("Log was written successfully");
            } catch (IOException e) {
                e.printStackTrace();

        }
    }
}
