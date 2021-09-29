package karat.resource;

import java.util.*;

public class Q2 {
    public String getMostRequestedResourceIn5Mins(String[][] logs) {
        Map<String, List<Integer>> map = new HashMap<>();
        for (String[] log : logs) {
            String resource = log[2];
            int time = Integer.parseInt(log[0]);
            List<Integer> list = map.getOrDefault(resource, new ArrayList<>());
            list.add(time);
            map.put(resource, list);
        }
        String res = "";
        int max = 0;
        for (String resource : map.keySet()) {
            List<Integer> list = map.get(resource);
            Collections.sort(list);
            for (int i = 0; i < list.size(); i++) {
                int curTime = list.get(i);
                int bound = upperBound(list, curTime + 300, i);
                if (bound - i + 1 > max) {
                    max = bound - i + 1;
                    res = resource;
                }
            }
        }
        return res;
    }

    private int upperBound(List<Integer> list, int target, int i) {
        int left = i, right = list.size();
        int res = i;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) == target) return mid;
            if (list.get(mid) < target) {
                left = mid + 1;
                res = mid;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}
