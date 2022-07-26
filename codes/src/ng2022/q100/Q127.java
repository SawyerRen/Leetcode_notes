package ng2022.q100;

import java.util.*;

public class Q127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        Set<String> set = new HashSet<>();
        set.add(beginWord);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            res++;
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                if (poll.equals(endWord)) return res;
                List<String> nextList = getNext(poll, wordSet);
                for (String next : nextList) {
                    if (set.contains(next)) continue;
                    set.add(next);
                    queue.add(next);
                }
            }
        }
        return 0;
    }

    private List<String> getNext(String poll, Set<String> wordSet) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < poll.length(); i++) {
            char[] chars = poll.toCharArray();
            for (char c = 'a'; c <= 'z'; c++) {
                chars[i] = c;
                String s = new String(chars);
                if (wordSet.contains(s)) res.add(s);
            }
        }
        return res;
    }
}
