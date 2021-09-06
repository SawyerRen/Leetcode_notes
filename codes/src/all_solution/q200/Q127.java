package all_solution.q200;

import java.util.*;

public class Q127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        int res = 0;
        if (beginWord.equals(endWord)) return res;
        Set<String> visited = new HashSet<>();
        queue.add(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            res++;
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                List<String> nextWords = getNextWords(word, wordSet);
                for (String nextWord : nextWords) {
                    if (nextWord.equals(endWord)) return res;
                    if (visited.contains(nextWord)) continue;
                    queue.add(nextWord);
                    visited.add(nextWord);
                }
            }
        }
        return res;
    }

    private List<String> getNextWords(String word, Set<String> wordSet) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            char[] chars = word.toCharArray();
            for (char c = 'a'; c <= 'z'; c++) {
                chars[i] = c;
                String s = new String(chars);
                if (wordSet.contains(s)) res.add(s);
            }
        }
        return res;
    }
}
