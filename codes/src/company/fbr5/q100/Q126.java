package company.fbr5.q100;

import java.util.*;

public class Q126 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        Map<String, Set<String>> map = new HashMap<>();
        queue.add(beginWord);
        boolean found = false;
        while (!queue.isEmpty() && !found) {
            wordSet.removeAll(queue);
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                map.putIfAbsent(poll, new HashSet<>());
                List<String> list = getNext(poll, wordSet);
                for (String next : list) {
                    if (next.equals(endWord)) found = true;
                    queue.add(next);
                    map.get(poll).add(next);
                }
            }
        }
        List<List<String>> res = new ArrayList<>();
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
