package company.huawei;

import model.ListNode;

import java.util.*;

public class Q3 {
    public static List<Integer> solution(int[][] depends) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        List<Integer> startList = new ArrayList<>();
        for (int[] depend : depends) {
            map.putIfAbsent(depend[0], new HashSet<>());
            startList.add(depend[0]);
            for (int i = 1; i < depend.length; i++) {
                map.get(depend[0]).add(depend[i]);
            }
        }
        List<Integer> minList = new ArrayList<>();
        int minSize = Integer.MAX_VALUE;
        for (Integer start : startList) {
            List<Integer> list = new ArrayList<>();
            boolean valid = dfs(list, start, new HashSet<Integer>(), map);
            if (valid && list.size() < minSize) {
                minList = new ArrayList<>(list);
                minSize = list.size();
            }
        }

        int startIndex = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < minList.size(); i++) {
            if (minList.get(i) < min) {
                min = minList.get(i);
                startIndex = i;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < minList.size(); i++) {
            res.add(minList.get((startIndex + i) % minList.size()));
        }
        res.add(minList.get(startIndex));
        return res;
    }

    private static boolean dfs(List<Integer> list, Integer start, HashSet<Integer> visited, Map<Integer, Set<Integer>> map) {
        if (visited.contains(start)) return true;
        list.add(start);
        visited.add(start);
        if (!map.containsKey(start)) return false;
        for (Integer next : map.get(start)) {
            if (dfs(list, next, visited, map)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
//        int[][] depends = {{1, 2, 5}, {2, 3, 4}, {3, 1}};
        int[][] depends = {{1, 2, 3, 4, 5, 6}, {2, 3, 4, 5, 6}, {3, 2, 4, 5, 6, 7}};
        System.out.println(solution(depends));
    }
}
