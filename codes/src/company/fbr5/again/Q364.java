package company.fbr5.again;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q364 {
    interface NestedInteger {
//    // Constructor initializes an empty nested list.
//    public NestedInteger();
//
//    // Constructor initializes a single integer.
//    public NestedInteger(int value);

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value);

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni);

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    public int depthSumInverse(List<NestedInteger> nestedList) {
        Queue<NestedInteger> queue = new LinkedList<>(nestedList);
        int res = 0, pre = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int level = 0;
            for (int i = 0; i < size; i++) {
                NestedInteger poll = queue.poll();
                if (poll.isInteger()) {
                    level += poll.getInteger();
                } else {
                    queue.addAll(poll.getList());
                }
            }
            pre += level;
            res += pre;
        }
        return res;

    }
}
