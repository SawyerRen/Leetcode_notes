package all_solution.q300;

import java.lang.reflect.Array;
import java.util.*;

public class Q317 {
    public int shortestDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Set<int[]> buildingSet = new HashSet<>();
        Map<Integer, Map<Integer, List<Integer>>> dists = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) buildingSet.add(new int[]{i, j});
            }
        }
        if (buildingSet.size() == 0) return -1;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        for (int[] building : buildingSet) {
            Queue<int[]> queue = new LinkedList<>();
            boolean[][] visited = new boolean[m][n];
            queue.add(building);
            visited[building[0]][building[1]] = true;
            int dist = 1;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int[] poll = queue.poll();
                    for (int[] dir : dirs) {
                        int row = poll[0] + dir[0];
                        int col = poll[1] + dir[1];
                        if (row < 0 || row >= m || col < 0 || col >= n || visited[row][col] || grid[row][col] == 1 || grid[row][col] == 2)
                            continue;
                        Map<Integer, List<Integer>> map = dists.getOrDefault(row, new HashMap<>());
                        List<Integer> list = map.getOrDefault(col, new ArrayList<>());
                        list.add(dist);
                        map.put(col, list);
                        dists.put(row, map);
                        queue.add(new int[]{row, col});
                        visited[row][col] = true;
                    }
                }
                dist++;
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dists.containsKey(i) && dists.get(i).containsKey(j) && dists.get(i).get(j) != null) {
                    List<Integer> distList = dists.get(i).get(j);
                    if (distList.size() != buildingSet.size()) continue;
                    int dist = 0;
                    for (Integer d : distList) {
                        dist += d;
                    }
                    res = Math.min(res, dist);
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
