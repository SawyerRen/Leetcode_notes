package topics.bfs;

import java.util.*;

public class Q433 {
    public int minMutation(String start, String end, String[] bank) {
        if (start.equals(end)) return 0;
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        int res = 0;
        queue.add(start);
        visited.add(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                if (poll.equals(end)) return res;
                List<String> nextList = getNextList(poll, bankSet);
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

    private List<String> getNextList(String s, Set<String> bankSet) {
        char[] genes = {'A', 'G', 'C', 'T'};
        List<String> nextList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char[] chars = s.toCharArray();
            for (char gene : genes) {
                chars[i] = gene;
                String next = new String(chars);
                if (bankSet.remove(next)) nextList.add(next);
            }
        }
        return nextList;
    }
}
