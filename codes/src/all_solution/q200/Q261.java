package all_solution.q200;

public class Q261 {
    public boolean validTree(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            int e = edge[0], d = edge[1];
            if (uf.connected(e, d)) return false;
            uf.union(e, d);
        }
        return uf.n == 1;
    }

    class UnionFind {
        int[] parents;
        int n;

        public UnionFind(int n) {
            this.n = n;
            parents = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
        }

        int find(int i) {
            while (i != parents[i]) {
                parents[i] = parents[parents[i]];
                i = parents[i];
            }
            return i;
        }

        void union(int i, int j) {
            int p1 = find(i);
            int p2 = find(j);
            if (p1 == p2) return;
            parents[p2] = p1;
            n--;
        }

        boolean connected(int i, int j) {
            int p1 = find(i);
            int p2 = find(j);
            return p1 == p2;
        }
    }
}
