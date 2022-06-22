package frequency.q100;

import java.util.*;

public class Q127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        visited.add(beginWord);
        int res = 0;
        while (!queue.isEmpty()) {
            res++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                if (poll.equals(endWord)) return res;
                List<String> nextList = getNext(poll, wordSet);
                for (String next : nextList) {
                    if (visited.contains(next)) continue;
                    queue.add(next);
                    visited.add(next);
                }
            }
        }
        return 0;
    }

    private List<String> getNext(String poll, Set<String> wordSet) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < poll.length(); i++) {
            char[] chars = poll.toCharArray();
            for (char c = 0; c <= 'z'; c++) {
                chars[i] = c;
                String s = new String(chars);
                if (wordSet.contains(s)) res.add(s);
            }
        }
        return res;
    }
}
