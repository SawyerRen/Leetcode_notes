package all_solution.q900;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q981 {
    class TimeMap {
        class TimeNode {
            String value;
            int timestamp;

            public TimeNode(String value, int timestamp) {
                this.value = value;
                this.timestamp = timestamp;
            }
        }

        Map<String, List<TimeNode>> map = new HashMap<>();

        public TimeMap() {

        }

        public void set(String key, String value, int timestamp) {
            TimeNode timeNode = new TimeNode(value, timestamp);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(timeNode);
        }

        public String get(String key, int timestamp) {
            if (!map.containsKey(key)) return "";
            List<TimeNode> list = map.get(key);
            int left = 0, right = list.size();
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (list.get(mid).timestamp > timestamp) right = mid;
                else left = mid + 1;
            }
            left--;
            if (left < 0 || list.get(left).timestamp > timestamp) return "";
            return list.get(left).value;
        }
    }
}


