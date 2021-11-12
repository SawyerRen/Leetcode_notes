package company.fbr4.again;

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

        public UnionFind(int size) {
            this.size = size;
            parents = new int[size];
            for (int i = 0; i < size; i++) {
                parents[i] = i;
            }
        }

        int find(int i) {
            while (parents[i] != i) {
                parents[i] = parents[parents[i]];
                i = parents[i];
            }
            return i;
        }

        boolean union(int i, int j) {
            int p1 = find(i), p2 = find(j);
            if (p1 == p2) return false;
            if (j != p2) return false;
            parents[p2] = p1;
            size--;
            return true;
        }
    }
}
