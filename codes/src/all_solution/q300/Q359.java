package all_solution.q300;

import java.util.HashMap;
import java.util.Map;

public class Q359 {
}

class Logger {
    Map<String, Integer> map = new HashMap<>();

    public Logger() {

    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (map.containsKey(message)) {
            if (map.get(message) > timestamp - 10) return false;
        }
        map.put(message, timestamp);
        return true;
    }
}