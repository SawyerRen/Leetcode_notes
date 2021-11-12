package company.fb2;

public class Q1361 {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < leftChild.length; i++) {
            if (leftChild[i] != -1 && !uf.union(i, leftChild[i])) return false;
            if (rightChild[i] != -1 && !uf.union(i, rightChild[i])) return false;
        }
        return uf.size == 1;
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

        boolean union(int parent, int child) {
            int p1 = find(parent), p2 = find(child);
            if (p1 == p2 || child != p2) return false;
            parents[p2] = p1;
            size--;
            return true;
        }
    }
}
