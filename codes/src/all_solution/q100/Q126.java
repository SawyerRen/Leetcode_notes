package all_solution.q100;

import java.util.*;

public class Q126 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Map<String, Set<String>> map = new HashMap<>();
        Set<String> wordSet = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        boolean found = false;
        while (!queue.isEmpty() && !found) {
            wordSet.removeAll(queue);
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                map.putIfAbsent(poll, new HashSet<>());
                List<String> nextList = getNext(poll, wordSet);
                for (String s : nextList) {
                    if (s.equals(endWord)) found = true;
                    map.get(poll).add(s);
                    queue.add(s);
                }
            }
        }
        List<String> list = new ArrayList<>();
        list.add(beginWord);
        helper(res, list, map, beginWord, endWord);
        return res;
    }

    private void helper(List<List<String>> res, List<String> list, Map<String, Set<String>> map, String beginWord, String endWord) {
        if (endWord.equals(beginWord)) {
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
            for (char c = 'a'; c <= 'z'; c++) {
                chars[i] = c;
                String s = new String(chars);
                if (wordSet.contains(s)) list.add(s);
            }
        }
        return list;
    }
}
