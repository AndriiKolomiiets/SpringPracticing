package Main;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
@Component
public class CacheFileEventLogger extends FileEventLogger {
    Integer cacheSize;
    List<Event> cache = new ArrayList<Event>();

    public CacheFileEventLogger(Integer cacheSize){
        this.cacheSize = cacheSize;

    }

    public void writeEventsFromCache() {
        super.logEvent(String.valueOf(cache));
     /*   try {
            FileUtils.writeStringToFile(file, String.valueOf(cache), "utf-8", append);
            System.out.println("Log was written successfully");
        } catch (IOException e) {d
            e.printStackTrace();
        }*/
    }

    public void logEvent(Event event) {
        cache.add(event);
        if (cache.size() == cacheSize) {
            writeEventsFromCache();
            System.out.println("Logs were written to file (3 logs)");
            cache.clear();
        }
    }

    private void destroy(){
        if(!cache.isEmpty()){
            writeEventsFromCache();
        }
    }
}
