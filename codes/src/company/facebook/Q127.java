package company.facebook;

import java.net.ServerSocket;
import java.util.*;

public class Q127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        HashSet<String> words = new HashSet<>(wordList);
        int steps = 0;
        while (!queue.isEmpty()) {
            steps++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                if (poll.equals(endWord)) return steps;
                List<String> nextList = getNext(poll, words);
                for (String next : nextList) {
                    if (visited.contains(next)) continue;
                    visited.add(next);
                    queue.add(next);
                }
            }
        }
        return 0;
    }

    private List<String> getNext(String poll, HashSet<String> words) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < poll.length(); i++) {
            char[] chars = poll.toCharArray();
            for (char c = 'a'; c <= 'z'; c++) {
                chars[i] = c;
                String s = new String(chars);
                if (words.contains(s)) list.add(s);
            }
        }
        return list;
    }
}
