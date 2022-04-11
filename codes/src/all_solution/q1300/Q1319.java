package all_solution.q1300;

public class Q1319 {
    int size;

    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1;
        size = n;
        int[] parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        for (int[] connection : connections) {
            union(parents, connection[0], connection[1]);
        }
        return size - 1;
    }

    private void union(int[] parents, int i, int j) {
        int p1 = find(parents, i), p2 = find(parents, j);
        if (p1 == p2) return;
        parents[p2] = p1;
        size--;
    }

    private int find(int[] parents, int i) {
        while (parents[i] != i) {
            parents[i] = parents[parents[i]];
            i = parents[i];
        }
        return i;
    }
}
