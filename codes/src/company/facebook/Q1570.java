package company.facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q1570 {
}

class SparseVector {
    class Node {
        int index;
        int val;

        public Node(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }

    List<Node> nodes;

    SparseVector(int[] nums) {
        nodes = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) nodes.add(new Node(i, nums[i]));
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int i = 0, j = 0;
        int res = 0;
        while (i < nodes.size() && j < vec.nodes.size()) {
            Node n1 = nodes.get(i);
            Node n2 = vec.nodes.get(j);
            if (n1.index == n2.index) {
                res += n1.val * n2.val;
                i++;
                j++;
            }
            else if (n1.index < n2.index) i++;
            else j++;
        }
        return res;
    }
}