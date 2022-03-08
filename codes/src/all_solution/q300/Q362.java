package all_solution.q300;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q362 {

}

class HitCounter {
    List<Integer> list = new ArrayList<>();

    public HitCounter() {

    }

    public void hit(int timestamp) {
        list.add(timestamp);
    }

    public int getHits(int timestamp) {
        if (timestamp <= 300) return list.size();
        int left = 0, right = list.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) > timestamp - 300) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (left == list.size() || list.get(left) <= timestamp - 300) return 0;
        return list.size() - left;
    }
}
