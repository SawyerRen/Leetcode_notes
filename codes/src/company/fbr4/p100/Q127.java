package company.fbr4.p100;

import java.util.*;

public class Q127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        queue.add(beginWord);
        int res = 0;
        while (!queue.isEmpty()) {
            res++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                if (poll.equals(endWord)) return res;
                List<String> next = getNext(poll, wordSet);
                for (String s : next) {
                    if (visited.contains(s)) continue;
                    queue.add(s);
                    visited.add(s);
                }
            }
        }
        return 0;
    }

    private List<String> getNext(String s, Set<String> wordSet) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char[] chars = s.toCharArray();
            for (int j = 0; j < 26; j++) {
                chars[i] = (char) (j + 'a');
                String next = String.valueOf(chars);
                if (wordSet.contains(next)) list.add(next);
            }
        }
        return list;
    }
}
