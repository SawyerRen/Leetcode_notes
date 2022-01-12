package company.ffff;

import java.util.ArrayList;
import java.util.List;

public class Q1570 {
    class SparseVector {
        List<Node> list = new ArrayList<>();

        SparseVector(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    list.add(new Node(i, nums[i]));
                }
            }
        }

        // Return the dotProduct of two sparse vectors
        public int dotProduct(SparseVector vec) {
            int i = 0, j = 0;
            int res = 0;
            while (i < list.size() && j < vec.list.size()) {
                Node node1 = list.get(i);
                Node node2 = vec.list.get(j);
                if (node1.index == node2.index) {
                    res += node1.value * node2.value;
                    i++;
                    j++;
                } else if (node1.index < node2.index) {
                    i++;
                } else {
                    j++;
                }
            }
            return res;
        }
    }

    class Node {
        int index;
        int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
