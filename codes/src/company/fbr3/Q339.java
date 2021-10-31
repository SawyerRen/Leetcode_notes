package company.fbr3;

import company.bytedance.oa2022.IsItTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q339 {
    public int depthSum(List<NestedInteger> nestedList) {
        return helper(nestedList, 1);
    }

    private int helper(List<NestedInteger> nestedList, int depth) {
        if (nestedList.size() == 0) return 0;
        int res = 0;
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) res += depth * nestedInteger.getInteger();
            else {
                res += helper(nestedInteger.getList(), depth + 1);
            }
        }
        return res;
    }

    public int depthSum1(List<NestedInteger> nestedList) {
        Queue<NestedInteger> queue = new LinkedList<>();
        queue.addAll(nestedList);
        int res = 0;
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                NestedInteger poll = queue.poll();
                if (poll.isInteger()) res += level * poll.getInteger();
                else queue.addAll(poll.getList());
            }
            level++;
        }
        return res;
    }
}
