package company.fb2;

import java.util.*;

public class Q127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Set<String> wordSet = new HashSet<>(wordList);
        queue.add(beginWord);
        visited.add(beginWord);
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                if (poll.equals(endWord)) return level;
                List<String> nextList = getNext(poll, wordSet);
                for (String s : nextList) {
                    if (visited.contains(s)) continue;
                    queue.add(s);
                    visited.add(s);
                }
            }
            level++;
        }
        return 0;
    }

    private List<String> getNext(String s, Set<String> wordSet) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char[] chars = s.toCharArray();
            for (int j = 0; j < 26; j++) {
                chars[i] = (char) (j + 'a');
                String next = new String(chars);
                if (wordSet.contains(next)) list.add(next);
            }
        }
        return list;
    }
}
