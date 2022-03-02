package all_solution.q300;

public class Q323 {
    public int countComponents(int n, int[][] edges) {
        int[] parents = new int[n];
        int size = n;
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        for (int[] edge : edges) {
            if (union(parents, edge[0], edge[1])) {
                size--;
            }
        }
        return size;
    }

    private boolean union(int[] parents, int i, int j) {
        int p1 = find(parents, i);
        int p2 = find(parents, j);
        if (p1 == p2) return false;
        parents[p2] = p1;
        return true;
    }

    private int find(int[] parents, int i) {
        while (i != parents[i]) {
            parents[i] = parents[parents[i]];
            i = parents[i];
        }
        return i;
    }
}
