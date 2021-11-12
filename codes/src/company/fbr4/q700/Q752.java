package company.fbr4.q700;

import java.util.*;

public class Q752 {
    public int openLock(String[] deadends, String target) {
        Set<String> visited = new HashSet<>(Arrays.asList(deadends));
        if (visited.contains("0000")) return -1;
        Queue<String> queue = new LinkedList<>();
        queue.add("0000");
        visited.add("0000");
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                if (poll.equals(target)) return res;
                List<String> nextList = getNext(poll);
                for (String s : nextList) {
                    if (visited.contains(s)) continue;
                    queue.add(s);
                    visited.add(s);
                }
            }
            res++;
        }
        return -1;
    }

    private List<String> getNext(String s) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            int x = s.charAt(i) - '0';
            int y1 = x == 9 ? 0 : x + 1;
            int y2 = x == 0 ? 9 : x - 1;
            list.add(s.substring(0, i) + y1 + s.substring(i + 1));
            list.add(s.substring(0, i) + y2 + s.substring(i + 1));
        }
        return list;
    }
}
