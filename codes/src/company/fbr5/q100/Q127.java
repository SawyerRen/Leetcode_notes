package company.fbr5.q100;

import java.util.*;

public class Q127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int res = 0;
        while (!queue.isEmpty()) {
            res++;
            wordSet.removeAll(queue);
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                if (poll.equals(endWord)) return res;
                List<String> nextList = getNext(poll, wordSet);
                queue.addAll(nextList);
            }
        }
        return 0;
    }

    private List<String> getNext(String s, Set<String> wordSet) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char[] chars = s.toCharArray();
            for (char c = 'a'; c <= 'z'; c++) {
                chars[i] = c;
                String s1 = new String(chars);
                if (wordSet.contains(s1)) list.add(s1);
            }
        }
        return list;
    }
}
