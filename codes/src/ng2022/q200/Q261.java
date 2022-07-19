package ng2022.q200;

public class Q261 {
    public boolean validTree(int n, int[][] edges) {
        int[] parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        int count = n;
        for (int[] edge : edges) {
            if (!union(parents, edge[0], edge[1])) return false;
            count--;
        }
        return count == 1;
    }

    private boolean union(int[] parents, int i, int j) {
        int p1 = root(parents, i);
        int p2 = root(parents, j);
        if (p1 == p2) return false;
        parents[p2] = p1;
        return true;
    }

    private int root(int[] parents, int i) {
        while (i != parents[i]) {
            parents[i] = parents[parents[i]];
            i = parents[i];
        }
        return i;
    }
}
