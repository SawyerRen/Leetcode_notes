package karat.resource;

import java.util.*;

public class Q1 {
    public Map<String, int[]> findMinAndMax(String[][] logs) {
        Map<String, int[]> map = new HashMap<>();
        for (String[] log : logs) {
            String name = log[1];
            int time = Integer.parseInt(log[0]);
            if (!map.containsKey(name)) {
                map.put(name, new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE});
            }
            if (time < map.get(name)[0]) {
                map.get(name)[0] = time;
            }
            if (time > map.get(name)[1]) {
                map.get(name)[1] = time;
            }
        }
        return map;
    }
}
