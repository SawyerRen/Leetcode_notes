package karat.access;

import java.util.*;

public class Q2 {
    Map<String, List<String>> frequentAccess(String[][] records) {
        Map<String, List<String>> res = new HashMap<>();
        Map<String, List<Integer>> timeMap = new HashMap<>();
        Map<Integer, String> timeStringMap = new HashMap<>();
        for (String[] record : records) {
            timeMap.putIfAbsent(record[0], new ArrayList<>());
            timeMap.get(record[0]).add(parseTime(record[1]));
            timeStringMap.put(parseTime(record[1]), record[1]);
        }
        for (String name : timeMap.keySet()) {
            List<Integer> timeList = timeMap.get(name);
            Collections.sort(timeList);
            int i = 0, j = 0;
            LinkedList<String> list = new LinkedList<>();
            while (j < timeList.size()) {
                while (i < j && timeList.get(i) + 60 < timeList.get(j)) {
                    list.removeFirst();
                    i++;
                }
                if (i - j + 1 > 3) {
                    break;
                }
                list.addLast(timeStringMap.get(timeList.get(j)));
                j++;
            }
            if (list.size() > 3) {
                res.put(name, list);
            }
        }
        return res;
    }

    private Integer parseTime(String s) {
        int time = Integer.parseInt(s);
        int hour = time / 100;
        int min = time % 100;
        return hour * 60 + min;
    }
}
