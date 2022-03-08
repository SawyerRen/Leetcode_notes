package all_solution.q300;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q364 {
    interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    public int depthSumInverse(List<NestedInteger> nestedList) {
        Queue<NestedInteger> queue = new LinkedList<>(nestedList);
        int res = 0, preSum = 0;
        while (!queue.isEmpty()) {
            int levelSum = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                NestedInteger poll = queue.poll();
                if (poll.isInteger()) {
                    levelSum += poll.getInteger();
                } else {
                    queue.addAll(poll.getList());
                }
            }
            res += preSum + levelSum;
            preSum += levelSum;
        }
        return res;
    }
}
