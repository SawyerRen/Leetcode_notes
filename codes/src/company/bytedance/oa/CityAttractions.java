package company.bytedance.oa;

import java.util.List;

public class CityAttractions {
    private static int max;

    private static int cityAttractions(int n, int m, int max_t, List<Integer> beauty, List<Integer> q, List<Integer> v, List<Integer> t) {
        max = beauty.get(0);

        int[][] graph = new int[n][n];
        for (int i = 0; i < q.size(); i++) {
            graph[q.get(i)][v.get(i)] = t.get(i);
            graph[v.get(i)][q.get(i)] = t.get(i);
        }

        dfs(0, max_t, 0, beauty, graph);
        return max;
    }

    private static void dfs(int location, int time, int points, List<Integer> beauty, int[][] graph) {
        if (time < 0) return;
        if (location == 0) max = Math.max(max, points);

        for (int i = 0; i < graph.length; i++) {
            if (graph[location][i] > 0) {
                int val = beauty.get(location);
                beauty.set(location, 0);
                dfs(i, time - graph[location][i], points + val, beauty, graph);
                beauty.set(location, val);
            }
        }
    }
}
