package all_solution.q500;

import java.util.*;

public class Q582 {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < pid.size(); i++) {
            map.putIfAbsent(ppid.get(i), new HashSet<>());
            map.get(ppid.get(i)).add(pid.get(i));
        }
        List<Integer> res = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(kill);
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            res.add(poll);
            if (map.containsKey(poll)) {
                queue.addAll(map.get(poll));
            }
        }
        return res;
    }
}
