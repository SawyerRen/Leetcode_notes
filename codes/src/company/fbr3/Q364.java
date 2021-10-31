package company.fbr3;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Q364 {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int maxDepth = helper(nestedList, 1);
        Queue<NestedInteger> queue = new LinkedList<>(nestedList);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                NestedInteger poll = queue.poll();
                if (poll.isInteger()) res += maxDepth * poll.getInteger();
                else queue.addAll(poll.getList());
            }
            maxDepth--;
        }
        return res;
    }

    private int helper(List<NestedInteger> nestedList, int depth) {
        if (nestedList.size() == 0) return depth;
        int max = depth;
        for (NestedInteger nestedInteger : nestedList) {
            if (!nestedInteger.isInteger()) {
                max = Math.max(max, helper(nestedInteger.getList(), depth + 1));
            }
        }
        return max;
    }
}
