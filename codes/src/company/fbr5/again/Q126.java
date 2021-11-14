package company.fbr5.again;

import java.util.*;

public class Q126 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
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
                List<String> nextList = getNext(poll, wordSet);
                for (String next : nextList) {
                    if (next.equals(endWord)) found = true;
                    queue.add(next);
                    map.get(poll).add(next);
                }
            }
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
        if (map.containsKey(beginWord)) {
            for (String next : map.get(beginWord)) {
                if (visited.contains(next)) continue;
                list.add(next);
                visited.add(next);
                helper(res, list, next, endWord, map, visited);
                list.remove(list.size() - 1);
                visited.remove(next);
            }
        }
    }

    private List<String> getNext(String poll, Set<String> wordSet) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < poll.length(); i++) {
            char[] chars = poll.toCharArray();
            for (char c = 'a'; c <= 'z'; c++) {
                chars[i] = c;
                String next = new String(chars);
                if (wordSet.contains(next)) list.add(next);
            }
        }
        return list;
    }
}
