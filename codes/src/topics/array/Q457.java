package topics.array;

import java.util.HashSet;
import java.util.Set;

public class Q457 {
    public boolean circularArrayLoop(int[] nums) {
        if (nums.length == 1) return false;
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) continue;
            if (visited.contains(i)) continue;
            // 快慢指针
            int slow = i, fast = i;
            while (nums[i] * nums[fast] > 0 && nums[i] * nums[getNext(nums, fast)] > 0) {
                visited.add(slow);
                visited.add(fast);
                slow = getNext(nums, slow);
                fast = getNext(nums, getNext(nums, fast));
                if (slow == fast) {
                    if (slow == getNext(nums, slow)) break;
                    return true;
                }
            }
        }
        return false;
    }

    private int getNext(int[] nums, int i) {
        int n = nums.length;
        if (nums[i] + i >= 0) return (nums[i] + i) % n;
        else return n + (nums[i] + i) % n;
    }
}
