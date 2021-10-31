package company.facebook;

import java.util.*;

public class Q347 {
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
        k = unique.length - k;
        int left = 0, right = unique.length - 1;
        while (left < right) {
            int pivotIndex = helper(map, unique, left, right);
            if (pivotIndex >= k) right = pivotIndex;
            else left = pivotIndex + 1;
        }
        return Arrays.copyOfRange(unique, left, unique.length);
    }

    private int helper(Map<Integer, Integer> map, int[] unique, int left, int right) {
        int randomIndex = new Random().nextInt(right - left + 1) + left;
        swap(unique, left, randomIndex);
        int pivot = map.get(unique[left]);
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

    public int[] topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        ArrayList<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (Integer num : map.keySet()) {
            Integer count = map.get(num);
            if (buckets[count] == null) buckets[count] = new ArrayList<>();
            buckets[count].add(num);
        }
        int[] res = new int[k];
        int index = 0;
        for (int i = nums.length; i >= 0; i--) {
            if (buckets[i] != null) {
                if (k == 0) break;
                for (Integer num : buckets[i]) {
                    res[index++] = num;
                }
                k -= buckets[i].size();
            }
        }
        return res;
    }
}
