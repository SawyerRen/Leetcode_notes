package company.fbr4.q1300;

public class Q1319 {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1;
        UnionFind uf = new UnionFind(n);
        for (int[] connection : connections) {
            uf.union(connection[0], connection[1]);
        }
        return uf.size - 1;
    }

    class UnionFind {
        int[] parents;
        int size;

        public UnionFind(int n) {
            parents = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
            size = n;
        }

        int find(int i) {
            while (i != parents[i]) {
                parents[i] = parents[parents[i]];
                i = parents[i];
            }
            return i;
        }

        void union(int i, int j) {
            int p1 = find(i), p2 = find(j);
            if (p1 == p2) return;
            parents[p2] = p1;
            size--;
        }
    }
}
