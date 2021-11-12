package company.fbr4.q700;

public class Q785 {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        for (int i = 0; i < n; i++) {
            if (colors[i] == 0) {
                if (!dfs(graph, i, colors, 1)) return false;
            }
        }
        return true;
    }

    private boolean dfs(int[][] graph, int i, int[] colors, int c) {
        if (colors[i] != 0) return colors[i] == c;
        colors[i] = c;
        for (int next : graph[i]) {
            if (!dfs(graph, next, colors, -c)) return false;
        }
        return true;
    }
}
