package all_solution.q2300;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Q2342 {
    public int maximumSum(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int num : nums) {
            int digitSum = 0;
            int temp = num;
            while (temp != 0) {
                digitSum += temp % 10;
                temp /= 10;
            }
            map.putIfAbsent(digitSum, new PriorityQueue<>((a, b) -> b - a));
            map.get(digitSum).add(num);
        }
        int res = -1;
        for (PriorityQueue<Integer> pq : map.values()) {
            if (pq.size() < 2) continue;
            res = Math.max(res, pq.poll() + pq.poll());
        }
        return res;
    }
}
