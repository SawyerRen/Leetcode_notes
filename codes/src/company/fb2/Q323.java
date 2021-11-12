package company.fb2;

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
            parents = new int[n];
            size = new int[n];
            count = n;
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

        void union(int a, int b) {
            int pa = find(a), pb = find(b);
            if (pa == pb) return;
            if (size[pa] > size[pb]) {
                parents[pb] = pa;
                size[pa] += size[pb];
            } else {
                parents[pa] = pb;
                size[pb] += size[pa];
            }
            count--;
        }
    }
}
