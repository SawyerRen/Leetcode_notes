package company.facebook;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q364 {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        Queue<NestedInteger> queue = new LinkedList<>(nestedList);
        int totalSum = 0, preSum = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int levelSum = 0;
            for (int i = 0; i < size; i++) {
                NestedInteger poll = queue.poll();
                if (poll.isInteger()) {
                    levelSum += poll.getInteger();
                } else {
                    queue.addAll(poll.getList());
                }
            }
            preSum += levelSum;
            totalSum += preSum;
        }
        return totalSum;
    }
}
