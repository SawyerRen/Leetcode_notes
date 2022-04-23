package all_solution.q1300;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q1396 {
    class UndergroundSystem {
        Map<Integer, Map<String, Integer>> startMap;
        Map<String, List<Integer>> timeMap;

        public UndergroundSystem() {
            startMap = new HashMap<>();
            timeMap = new HashMap<>();
        }

        public void checkIn(int id, String stationName, int t) {
            startMap.putIfAbsent(id, new HashMap<>());
            startMap.get(id).put(stationName, t);
        }

        public void checkOut(int id, String stationName, int t) {
            String startStation = "";
            int startTime = 0;
            for (String s : startMap.get(id).keySet()) {
                startStation = s;
                startTime = startMap.get(id).get(s);
            }
            startMap.get(id).clear();
            int time = t - startTime;
            timeMap.putIfAbsent(startStation + "->" + stationName, new ArrayList<>());
            timeMap.get(startStation + "->" + stationName).add(time);
        }

        public double getAverageTime(String startStation, String endStation) {
            List<Integer> list = timeMap.get(startStation + "->" + endStation);
            int sum = 0;
            for (Integer integer : list) {
                sum += integer;
            }
            return (double) sum / list.size();
        }
    }
}
