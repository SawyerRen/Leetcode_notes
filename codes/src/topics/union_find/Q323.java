package topics.union_find;

import java.util.Arrays;

public class Q323 {
    public int countComponents(int n, int[][] edges) {
        if (n < 1) return 0;
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }
        return uf.count;
    }

    static class UnionFind {
        int[] parents;
        int[] size;
        int count;

        public UnionFind(int count) {
            this.count = count;
            parents = new int[count];
            size = new int[count];
            for (int i = 0; i < count; i++) {
                parents[i] = i;
            }
            Arrays.fill(size, 1);
        }

        public int root(int i) {
            while (i != parents[i]) {
                parents[i] = parents[parents[i]];
                i = parents[i];
            }
            return i;
        }

        public void union(int i, int j) {
            int iRoot = root(i);
            int jRoot = root(j);
            if (iRoot == jRoot) return;
            if (size[iRoot] > size[jRoot]) {
                parents[jRoot] = iRoot;
                size[iRoot] += size[jRoot];
            } else {
                parents[iRoot] = jRoot;
                size[jRoot] += size[iRoot];
            }
            count--;
        }
    }
}
