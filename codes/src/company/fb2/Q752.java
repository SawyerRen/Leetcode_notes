package company.fb2;

import java.util.*;

public class Q752 {
    public int openLock(String[] deadends, String target) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>(Arrays.asList(deadends));
        if (visited.contains("0000")) return -1;
        queue.add("0000");
        visited.add("0000");
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                if (poll.equals(target)) return res;
                List<String> list = getNext(poll);
                for (String next : list) {
                    if (visited.contains(next)) continue;
                    queue.add(next);
                    visited.add(next);
                }
            }
            res++;
        }
        return -1;
    }

    List<String> getNext(String s) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int x = s.charAt(i) - '0';
            int y1 = (x + 1 + 10) % 10;
            int y2 = (x - 1 + 10) % 10;
            list.add(s.substring(0, i) + y1 + s.substring(i + 1));
            list.add(s.substring(0, i) + y2 + s.substring(i + 1));
        }
        return list;
    }
}
