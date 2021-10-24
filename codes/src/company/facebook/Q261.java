package company.facebook;

public class Q261 {
    public boolean validTree(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            if (uf.find(edge[0]) == uf.find(edge[1])) return false;
            uf.union(edge[0], edge[1]);
        }
        return edges.length == n - 1;
    }

    class UnionFind {
        int[] parents;
        int[] size;
        int len;

        public UnionFind(int len) {
            this.len = len;
            parents = new int[len];
            size = new int[len];
            for (int i = 0; i < len; i++) {
                parents[i] = i;
                size[i] = 1;
            }
        }

        public int find(int a) {
            while (a != parents[a]) {
                parents[a] = parents[parents[a]];
                a = parents[a];
            }
            return a;
        }

        public void union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if (pa == pb) return;
            if (size[pa] < size[pb]) {
                parents[pa] = pb;
                size[pb] += size[pa];
            } else {
                parents[pb] = pa;
                size[pa] += size[pb];
            }
        }
    }
}
