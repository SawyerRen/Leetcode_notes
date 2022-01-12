package company.ffff;

import java.util.*;

public class Q347 {
    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] lists = new List[nums.length + 1];
        for (Integer num : map.keySet()) {
            int count = map.get(num);
            if (lists[count] == null) lists[count] = new ArrayList<>();
            lists[count].add(num);
        }
        int[] res = new int[k];
        for (int i = lists.length - 1; i >= 0; i--) {
            if (lists[i] != null) {
                if (k == 0) break;
                for (Integer num : lists[i]) {
                    res[--k] = num;
                }
            }
        }
        return res;
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] unique = new int[map.size()];
        int i = 0;
        for (Integer num : map.keySet()) {
            unique[i++] = num;
        }
        int[] res = new int[k];
        int left = 0, right = unique.length - 1;
        k = unique.length - k;
        while (left < right) {
            int pivotIndex = helper(unique, left, right, map);
            if (pivotIndex >= k) right = pivotIndex;
            else left = pivotIndex + 1;
        }
        for (int j = 0; j < res.length; j++) {
            res[j] = unique[j + k];
        }
        return res;
    }

    private int helper(int[] nums, int left, int right, Map<Integer, Integer> map) {
        int randomIndex = new Random().nextInt(right - left + 1) + left;
        swap(nums, left, randomIndex);
        int pivot = map.get(nums[left]);
        int i = left, j = right;
        while (i < j) {
            while (i < j && map.get(nums[j]) >= pivot) j--;
            while (i < j && map.get(nums[i]) <= pivot) i++;
            if (i < j) swap(nums, i, j);
        }
        swap(nums, left, i);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public int[] topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        for (Integer num : map.keySet()) {
            pq.add(num);
            if (pq.size() > k) pq.poll();
        }
        int[] res = new int[pq.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = pq.poll();
        }
        return res;
    }
}
