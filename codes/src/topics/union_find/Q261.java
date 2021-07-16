package topics.union_find;

public class Q261 {
    public boolean validTree(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            // 如果有环
            if (uf.find(edge[0], edge[1])) {
                return false;
            } else {
                uf.union(edge[0], edge[1]);
            }
        }
        return true;
    }
}

class UnionFind {
    int count;
    int[] parents;
    int[] size;

    public UnionFind(int count) {
        parents = new int[count];
        size = new int[count];
        this.count = count;
        for (int i = 0; i < count; i++) {
            parents[i] = i;
            size[i] = 1;
        }
    }

    public int root(int i) {
        while (i != parents[i]) {
            parents[i] = parents[parents[i]];
            i = parents[i];
        }
        return i;
    }

    public void union(int p, int q) {
        int rootP = root(p);
        int rootQ = root(q);
        if (size[rootP] > size[rootQ]) {
            parents[rootQ] = rootP;
            size[rootP] += size[rootQ];
        } else {
            parents[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        count--;
    }

    public boolean find(int p, int q) {
        return root(p) == root(q);
    }
}
