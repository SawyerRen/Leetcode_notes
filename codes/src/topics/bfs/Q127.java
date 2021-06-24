package topics.bfs;

import java.util.*;

public class Q127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        int res = 1;
        queue.add(beginWord);
        visited.add(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            res++;
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                List<String> neighbors = getNeighbors(poll, words);
                for (String neighbor : neighbors) {
                    if (neighbor.equals(endWord)) return res;
                    if (visited.contains(neighbor)) continue;
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
        return -1;
    }

    private List<String> getNeighbors(String word, Set<String> words) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            char[] chars = word.toCharArray();
            for (char c = 'a'; c <= 'z'; c++) {
                chars[i] = c;
                String s = new String(chars);
                if (words.contains(s)) list.add(s);
            }
        }
        return list;
    }
}
