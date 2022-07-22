package ng2022.q300;

public class Q323 {
    int count = 0;

    public int countComponents(int n, int[][] edges) {
        int[] parents = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        for (int[] edge : edges) {
            union(parents, edge[0], edge[1]);
        }
        return count;
    }

    private void union(int[] parents, int i, int j) {
        int p1 = root(parents, i);
        int p2 = root(parents, j);
        if (p1 == p2) return;
        parents[p2] = p1;
        count--;
    }

    private int root(int[] parents, int i) {
        while (i != parents[i]) {
            parents[i] = parents[parents[i]];
            i = parents[i];
        }
        return i;
    }
}
