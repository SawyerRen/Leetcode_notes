package all_solution.q1500;

import java.util.ArrayList;
import java.util.List;

public class Q1570 {
    class Node {
        int index;
        int val;

        public Node(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }

    class SparseVector {
        List<Node> list;

        SparseVector(int[] nums) {
            list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) list.add(new Node(i, nums[i]));
            }
        }

        // Return the dotProduct of two sparse vectors
        public int dotProduct(SparseVector vec) {
            List<Node> list2 = vec.list;
            int res = 0;
            int i = 0, j = 0;
            while (i < list.size() && j < list2.size()) {
                if (list.get(i).index == list2.get(j).index) {
                    res += list2.get(j).val * list.get(i).val;
                    i++;
                    j++;
                } else if (list.get(i).index < list2.get(j).index) {
                    i++;
                } else {
                    j++;
                }
            }
            return res;
        }
    }
}
