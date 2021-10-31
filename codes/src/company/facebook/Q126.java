package company.facebook;

import java.util.*;

public class Q126 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> cur = new HashSet<>();
        Set<String> wordSet = new HashSet<>(wordList);
        Map<String, Set<String>> map = new HashMap<>();
        cur.add(beginWord);
        boolean found = false;
        while (!cur.isEmpty() && !found) {
            wordSet.removeAll(cur);
            Set<String> nextCur = new HashSet<>();
            for (String word : cur) {
                map.put(word, new HashSet<>());
                List<String> nextList = getNext(word, wordSet);
                for (String next : nextList) {
                    map.get(word).add(next);
                    nextCur.add(next);
                    if (next.equals(endWord)) found = true;
                }
            }
            cur = nextCur;
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
        if (!map.containsKey(beginWord)) return;
        for (String next : map.get(beginWord)) {
            list.add(next);
            helper(res, list, map, next, endWord);
            list.remove(list.size() - 1);
        }
    }

    private List<String> getNext(String word, Set<String> wordSet) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            char[] chars = word.toCharArray();
            for (int j = 0; j < 26; j++) {
                chars[i] = (char) (j + 'a');
                String next = String.valueOf(chars);
                if (wordSet.contains(next)) list.add(next);
            }
        }
        return list;
    }
}
