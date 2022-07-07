package frequency.q300;

import java.util.HashMap;
import java.util.Map;

public class Q359 {
    class Logger {
        Map<String, Integer> map;

        public Logger() {
            map = new HashMap<>();
        }

        public boolean shouldPrintMessage(int timestamp, String message) {
            if (map.containsKey(message) && timestamp - map.get(message) < 10) {
                return false;
            }
            map.put(message, timestamp);
            return true;
        }
    }
}
