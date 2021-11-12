package company.fbr4.again;

import java.util.*;

public class Q126 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> curSet = new HashSet<>();
        Map<String, Set<String>> map = new HashMap<>();
        curSet.add(beginWord);
        boolean found = false;
        while (!curSet.isEmpty() && !found) {
            Set<String> nextSet = new HashSet<>();
            wordSet.removeAll(curSet);
            for (String s : curSet) {
                List<String> nextList = getNext(s, wordSet);
                map.putIfAbsent(s, new HashSet<>());
                for (String next : nextList) {
                    if (next.equals(endWord)) found = true;
                    nextSet.add(next);
                    map.get(s).add(next);
                }
            }
            curSet = nextSet;
        }
        List<String> list = new ArrayList<>();
        list.add(beginWord);
        helper(res, list, map, beginWord, endWord);
        return res;
    }

    private void helper(List<List<String>> res, List<String> list, Map<String, Set<String>> map, String beginWord, String endWord) {
        if (beginWord.equals(endWord)) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (map.containsKey(beginWord)) {
            for (String next : map.get(beginWord)) {
                list.add(next);
                helper(res, list, map, next, endWord);
                list.remove(list.size() - 1);
            }
        }
    }

    private List<String> getNext(String s, Set<String> wordSet) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char[] chars = s.toCharArray();
            for (int j = 0; j < 26; j++) {
                chars[i] = (char) (j + 'a');
                String s1 = String.valueOf(chars);
                if (wordSet.contains(s1)) list.add(s1);
            }
        }
        return list;
    }
}
