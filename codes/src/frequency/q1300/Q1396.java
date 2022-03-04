package frequency.q1300;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q1396 {
}

class UndergroundSystem {
    // start_station+end_station:{id:time}
    Map<String, int[]> timeMap = new HashMap<>();
    Map<Integer, String> idStartMap = new HashMap<>();
    Map<Integer, Integer> idStartTimeMap = new HashMap<>();

    public UndergroundSystem() {

    }

    public void checkIn(int id, String stationName, int t) {
        idStartMap.put(id, stationName);
        idStartTimeMap.put(id, t);
    }

    public void checkOut(int id, String stationName, int t) {
        String startStation = idStartMap.get(id);
        int time = t - idStartTimeMap.get(id);
        String route = startStation + "," + stationName;
        int[] arr = timeMap.getOrDefault(route, new int[]{0, 0});
        arr[0] += time;
        arr[1] += 1;
        timeMap.put(route, arr);
    }

    public double getAverageTime(String startStation, String endStation) {
        String route = startStation + "," + endStation;
        int[] arr = timeMap.get(route);
        return (double) arr[0] / arr[1];
    }
}
