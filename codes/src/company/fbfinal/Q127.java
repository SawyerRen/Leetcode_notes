package company.fbfinal;

import java.util.*;

public class Q127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        int res = 0;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            res++;
            if (beginSet.size() > endSet.size()) {
                Set<String> t = beginSet;
                beginSet = endSet;
                endSet = t;
            }
            Set<String> nextSet = new HashSet<>();
            for (String s : beginSet) {
                List<String> nextList = getNext(s, wordSet);
                for (String next : nextList) {
                    if (endSet.contains(next)) return res;
                    if (visited.contains(next)) continue;
                    nextSet.add(next);
                    visited.add(next);
                }
            }
            beginSet = nextSet;
        }
        return 0;
    }

    private List<String> getNext(String poll, Set<String> wordSet) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < poll.length(); i++) {
            char[] chars = poll.toCharArray();
            for (char c = 'a'; c <= 'z'; c++) {
                chars[i] = c;
                String s = new String(chars);
                if (wordSet.contains(s)) list.add(s);
            }
        }
        return list;
    }
}
