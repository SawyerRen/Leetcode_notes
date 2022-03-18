package all_solution.q700;

public class Q785 {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        for (int i = 0; i < n; i++) {
            if (colors[i] != 0) continue;
            if (!helper(graph, colors, i, 1)) return false;
        }
        return true;
    }

    private boolean helper(int[][] graph, int[] colors, int i, int color) {
        if (colors[i] != 0) return colors[i] == color;
        colors[i] = color;
        for (int next : graph[i]) {
            if (!helper(graph, colors, next, -color)) return false;
        }
        return true;
    }
}
