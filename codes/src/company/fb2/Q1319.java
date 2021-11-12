package company.fb2;

public class Q1319 {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1;
        int[] parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        int size = n;
        for (int[] connection : connections) {
            int p1 = find(parents, connection[0]);
            int p2 = find(parents, connection[1]);
            if (p1 != p2) size--;
            parents[p2] = p1;
        }
        return size - 1;
    }

    int find(int[] parents, int i) {
        while (i != parents[i]) {
            parents[i] = parents[parents[i]];
            i = parents[i];
        }
        return i;
    }
}
