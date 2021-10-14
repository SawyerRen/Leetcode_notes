package company.facebook;

import java.util.*;

public class Q347 {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Integer key : map.keySet()) {
            Integer freq = map.get(key);
            if (bucket[freq] == null) bucket[freq] = new ArrayList<>();
            bucket[freq].add(key);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] != null) {
                list.addAll(bucket[i]);
            }
            if (list.size() >= k) break;
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        for (Integer key : map.keySet()) {
            pq.add(new int[]{key, map.get(key)});
            if (pq.size() > k) pq.poll();
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll()[0];
        }
        return res;
    }

    public int[] topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] unique = new int[map.size()];
        int index = 0;
        for (Integer key : map.keySet()) {
            unique[index++] = key;
        }
        k = unique.length - k;
        int left = 0, right = unique.length - 1;
        while (left < right) {
            int pivotIndex = helper(unique, left, right, map);
            if (pivotIndex >= k) right = pivotIndex;
            else left = pivotIndex + 1;
        }
        return Arrays.copyOfRange(unique, left, unique.length);
    }

    private int helper(int[] unique, int left, int right, Map<Integer, Integer> map) {
        int randomIndex = new Random().nextInt(right - left) + left;
        int pivot = map.get(unique[randomIndex]);
        swap(unique, left, randomIndex);
        int i = left, j = right;
        while (i < j) {
            while (i < j && map.get(unique[j]) >= pivot) j--;
            while (i < j && map.get(unique[i]) <= pivot) i++;
            if (i < j) {
                swap(unique, i, j);
            }
        }
        swap(unique, left, i);
        return i;
    }

    private void swap(int[] unique, int i, int j) {
        int t = unique[i];
        unique[i] = unique[j];
        unique[j] = t;
    }
}
