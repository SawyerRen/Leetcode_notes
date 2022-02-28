package all_solution.q300;

import java.util.ArrayList;
import java.util.List;

public class Q311 {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        List<Node> list1 = new ArrayList<>();
        List<Node> list2 = new ArrayList<>();
        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < mat1[0].length; j++) {
                if (mat1[i][j] != 0) list1.add(new Node(i, j, mat1[i][j]));
            }
        }
        for (int i = 0; i < mat2.length; i++) {
            for (int j = 0; j < mat2[0].length; j++) {
                if (mat2[i][j] != 0) list2.add(new Node(i, j, mat2[i][j]));
            }
        }
        int[][] res = new int[mat1.length][mat2[0].length];
        for (Node node1 : list1) {
            for (Node node2 : list2) {
                if (node1.col == node2.row) res[node1.row][node2.col] += node1.val * node2.val;
            }
        }
        return res;
    }

    class Node {
        int row;
        int col;
        int val;

        public Node(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }
}
