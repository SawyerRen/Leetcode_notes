package all_solution.q1200;

import java.util.*;

public class Q1222 {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> res = new ArrayList<>();
        int n = 8;
        int sRow = king[0], sCol = king[1];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] queen : queens) {
            map.putIfAbsent(queen[0], new HashSet<>());
            map.get(queen[0]).add(queen[1]);
        }
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        for (int[] dir : dirs) {
            int i = sRow, j = sCol;
            while (i >= 0 && i < n && j >= 0 && j < n) {
                if (map.containsKey(i) && map.get(i).contains(j)) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    res.add(list);
                    break;
                }
                i += dir[0];
                j += dir[1];
            }
        }
        return res;
    }
}
