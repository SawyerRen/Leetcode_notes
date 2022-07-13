package ng2022.q900;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q981 {
    class TimeMap {
        class Node {
            String key;
            String value;
            int timestamp;

            public Node(String key, String value, int timestamp) {
                this.key = key;
                this.value = value;
                this.timestamp = timestamp;
            }
        }

        Map<String, List<Node>> map;

        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(new Node(key, value, timestamp));
        }

        public String get(String key, int timestamp) {
            if (!map.containsKey(key)) return "";
            List<Node> list = map.get(key);
            int left = 0, right = list.size();
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (list.get(mid).timestamp > timestamp) right = mid;
                else left = mid + 1;
            }
            if (left == 0 || list.get(left - 1).timestamp > timestamp) return "";
            return list.get(left - 1).value;
        }
    }
}
