package company.fb2;

import java.util.*;

public class Q126 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> curSet = new HashSet<>();
        Map<String, Set<String>> map = new HashMap<>();
        curSet.add(beginWord);
        boolean found = false;
        while (!curSet.isEmpty() && !found) {
            wordSet.removeAll(curSet);
            Set<String> nextSet = new HashSet<>();
            for (String s : curSet) {
                List<String> nextList = getNext(s, wordSet);
                for (String s1 : nextList) {
                    if (s1.equals(endWord)) found = true;
                    nextSet.add(s1);
                    map.putIfAbsent(s, new HashSet<>());
                    map.get(s).add(s1);
                }
            }
            curSet = nextSet;
        }
        ArrayList<String> list = new ArrayList<>();
        list.add(beginWord);
        List<List<String>> res = new ArrayList<>();
        if (!found) return res;
        helper(res, list, beginWord, endWord, map);
        return res;
    }

    private void helper(List<List<String>> res, ArrayList<String> list, String beginWord, String endWord, Map<String, Set<String>> map) {
        if (beginWord.equals(endWord)) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (!map.containsKey(beginWord)) return;
        for (String s : map.get(beginWord)) {
            list.add(s);
            helper(res, list, s, endWord, map);
            list.remove(list.size() - 1);
        }
    }

    private List<String> getNext(String s, Set<String> wordSet) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char[] chars = s.toCharArray();
            for (int j = 0; j < 26; j++) {
                chars[i] = (char) (j + 'a');
                String s1 = new String(chars);
                if (wordSet.contains(s1)) list.add(s1);
            }
        }
        return list;
    }
}
