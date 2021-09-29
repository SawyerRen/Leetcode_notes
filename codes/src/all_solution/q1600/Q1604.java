package all_solution.q1600;

import java.util.*;

public class Q1604 {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        List<String> res = new ArrayList<>();
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < keyName.length; i++) {
            map.putIfAbsent(keyName[i], new ArrayList<>());
            map.get(keyName[i]).add(parseMinute(keyTime[i]));
        }
        Set<String> set = map.keySet();
        for (String name : set) {
            List<Integer> list = map.get(name);
            if (list.size() < 3) continue;
            Collections.sort(list);
            int i = 0, j = 0;
            while (j < list.size()) {
                while (i < j && list.get(j) > list.get(i) + 60) {
                    i++;
                }
                if (j - i + 1 >= 3) {
                    res.add(name);
                    break;
                }
                j++;
            }
        }
        Collections.sort(res);
        return res;
    }

    private int parseMinute(String s) {
        String[] split = s.split(":");
        int hour = Integer.parseInt(split[0]);
        int min = Integer.parseInt(split[1]);
        return hour * 60 + min;
    }
}
