package company.fbr4.q300;

public class Q323 {
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }
        return uf.count;
    }

    class UnionFind {
        int[] parents;
        int[] size;
        int count;

        public UnionFind(int n) {
            count = n;
            parents = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
                size[i] = 1;
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
            int p1 = find(i), p2 = find(j);
            if (p1 == p2) return;
            if (size[p1] > size[p2]) {
                parents[p2] = p1;
                size[p1] += size[p2];
            } else {
                parents[p1] = p2;
                size[p2] += size[p1];
            }
            count--;
        }
    }
}
