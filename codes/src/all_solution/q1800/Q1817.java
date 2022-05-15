package all_solution.q1800;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q1817 {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Set<Integer>> userTimeMap = new HashMap<>();
        for (int[] log : logs) {
            userTimeMap.putIfAbsent(log[0], new HashSet<>());
            userTimeMap.get(log[0]).add(log[1]);
        }
        Map<Integer, Integer> timeCountMap = new HashMap<>();
        for (Integer userId : userTimeMap.keySet()) {
            int time = userTimeMap.get(userId).size();
            timeCountMap.put(time, timeCountMap.getOrDefault(time, 0) + 1);
        }
        int[] res = new int[k];
        for (Integer time : timeCountMap.keySet()) {
            int index = time - 1;
            res[index] = timeCountMap.get(time);
        }
        return res;
    }
}
