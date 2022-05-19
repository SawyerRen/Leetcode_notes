package all_solution.q1900;

public class Q1971 {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        int[] parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        for (int[] edge : edges) {
            union(parents, edge[0], edge[1]);
        }
        int p1 = find(parents, source);
        int p2 = find(parents, destination);
        return p1 == p2;
    }

    private void union(int[] parents, int i, int j) {
        int p1 = find(parents, i);
        int p2 = find(parents, j);
        parents[p2] = p1;
    }

    private int find(int[] parents, int i) {
        while (i != parents[i]) {
            parents[i] = parents[parents[i]];
            i = parents[i];
        }
        return i;
    }
}
