package company.fbr5.q700;

import java.lang.reflect.Array;
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
                for (String next : nextList) {
                    if (visited.contains(next)) continue;
                    queue.add(next);
                    visited.add(next);
                }
            }
            res++;
        }
        return -1;
    }

    private List<String> getNext(String s) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            char c = s.charAt(i);
            char c1 = c == '9' ? '0' : (char) (c + 1);
            char c2 = c == '0' ? '9' : (char) (c - 1);
            char[] chars = s.toCharArray();
            chars[i] = c1;
            list.add(new String(chars));
            chars[i] = c2;
            list.add(new String(chars));
        }
        return list;
    }
}
