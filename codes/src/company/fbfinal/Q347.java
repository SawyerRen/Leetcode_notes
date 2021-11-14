package company.fbfinal;

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
        int index = 0;
        for (int i = lists.length - 1; i >= 0; i--) {
            if (lists[i] != null) {
                if (k == 0) break;
                for (Integer num : lists[i]) {
                    res[index++] = num;
                }
                k -= lists[i].size();
            }
        }
        return res;
    }

    public int[] topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] unique = new int[map.size()];
        int i = 0;
        for (Integer integer : map.keySet()) {
            unique[i++] = integer;
        }
        k = unique.length - k;
        int left = 0, right = unique.length - 1;
        while (left < right) {
            int pivotIndex = helper(map, unique, left, right);
            if (pivotIndex >= k) right = pivotIndex;
            else left = pivotIndex + 1;
        }
        return Arrays.copyOfRange(unique, left, unique.length);
    }

    private int helper(Map<Integer, Integer> map, int[] nums, int left, int right) {
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

    void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Queue<Integer> heap = new PriorityQueue<>(
                (n1, n2) -> map.get(n1) - map.get(n2));
        for (int num : map.keySet()) {
            heap.add(num);
            if (heap.size() > k) heap.poll();
        }
        int[] res = new int[k];
        for (int j = 0; j < res.length; j++) {
            res[j] = heap.poll();
        }
        return res;
    }
}
