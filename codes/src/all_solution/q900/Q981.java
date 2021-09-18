package all_solution.q900;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q981 {
}

class TimeMap {
    class TimeNode {
        String val;
        int timestamp;

        public TimeNode(String val, int timestamp) {
            this.val = val;
            this.timestamp = timestamp;
        }
    }

    Map<String, List<TimeNode>> map = new HashMap<>();

    /**
     * Initialize your data structure here.
     */
    public TimeMap() {

    }

    public void set(String key, String value, int timestamp) {
        TimeNode node = new TimeNode(value, timestamp);
        if (!map.containsKey(key)) map.put(key, new ArrayList<>());
        map.get(key).add(node);
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        return search(map.get(key), timestamp);
    }

    private String search(List<TimeNode> list, int timestamp) {
        int left = 0, right = list.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid).timestamp > timestamp) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        left--;
        if (left < 0) return "";
        if (list.get(left).timestamp > timestamp) return "";
        return list.get(left).val;
    }
}