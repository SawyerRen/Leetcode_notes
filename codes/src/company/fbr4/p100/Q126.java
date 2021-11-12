package company.fbr4.p100;

import java.util.*;

public class Q126 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> curSet = new HashSet<>();
        List<List<String>> res = new ArrayList<>();
        Map<String, Set<String>> map = new HashMap<>();
        boolean found = false;
        curSet.add(beginWord);
        while (!curSet.isEmpty() && !found) {
            Set<String> nextSet = new HashSet<>();
            wordSet.removeAll(curSet);
            for (String s : curSet) {
                List<String> nextList = getNext(s, wordSet);
                for (String next : nextList) {
                    if (next.equals(endWord)) found = true;
                    map.putIfAbsent(s, new HashSet<>());
                    map.get(s).add(next);
                    nextSet.add(next);
                }
            }
            curSet = nextSet;
        }
        List<String> list = new ArrayList<>();
        list.add(beginWord);
        helper(res, list, beginWord, endWord, map, new HashSet<String>());
        return res;
    }

    private void helper(List<List<String>> res, List<String> list, String beginWord, String endWord, Map<String, Set<String>> map, HashSet<String> visited) {
        if (beginWord.equals(endWord)) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (!map.containsKey(beginWord)) return;
        for (String next : map.get(beginWord)) {
            if (visited.contains(next)) continue;
            list.add(next);
            visited.add(next);
            helper(res, list, next, endWord, map, visited);
            list.remove(list.size() - 1);
            visited.remove(next);
        }
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
