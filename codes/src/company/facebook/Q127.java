package company.facebook;

import java.net.ServerSocket;
import java.util.*;

public class Q127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(beginWord);
        visited.add(beginWord);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                if (poll.equals(endWord)) return level;
                List<String> nextWords = getNextWords(poll, wordSet);
                for (String nextWord : nextWords) {
                    if (visited.contains(nextWord)) continue;
                    queue.add(nextWord);
                    visited.add(nextWord);
                }
            }
        }
        return 0;
    }

    private List<String> getNextWords(String poll, Set<String> wordSet) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < poll.length(); i++) {
            char[] chars = poll.toCharArray();
            for (char c = 'a'; c <= 'z'; c++) {
                chars[i] = c;
                if (wordSet.contains(new String(chars))) res.add(new String(chars));
            }
        }
        return res;
    }
}
