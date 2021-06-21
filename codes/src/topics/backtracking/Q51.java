package topics.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q51 {
    public List<List<String>> solveNQueens(int n) {
        char[][] map = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(map[i], '.');
        }
        List<List<String>> res = new ArrayList<>();
        helper(res, map, 0);
        return res;
    }

    private void helper(List<List<String>> res, char[][] map, int row) {
        if (row >= map.length) {
            res.add(covertMap2List(map));
            return;
        }
        for (int col = 0; col < map.length; col++) {
            if (valid(map, row, col)) {
                map[row][col] = 'Q';
                helper(res, map, row + 1);
                map[row][col] = '.';
            }
        }
    }

    private boolean valid(char[][] map, int row, int col) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (map[i][j] == 'Q' && (row == i || col == j || Math.abs(row - i) == Math.abs(col - j))) {
                    return false;
                }
            }
        }
        return true;
    }

    private List<String> covertMap2List(char[][] map) {
        List<String> list = new ArrayList<>();
        for (char[] chars : map) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < map.length; j++) {
                builder.append(chars[j]);
            }
            list.add(builder.toString());
        }
        return list;
    }
}
