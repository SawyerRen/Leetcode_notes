package company.fbr3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class E {
    String changeBase(int num, int base) {
        StringBuilder builder = new StringBuilder();
        while (num != 0) {
            builder.append(num % base);
            num /= base;
        }
        return builder.reverse().toString();
    }

    static int countUniqueInSortedArray(int[] nums) {
        int count = 0;
        int index = 0;
        while (index < nums.length) {
            count++;
            index = getNextIndex(nums, index, nums[index] + 1);
        }
        return count;
    }

    static private int getNextIndex(int[] nums, int left, int target) {
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    static List<int[]> unionIntervals(int[][] l1, int[][] l2) {
        List<int[]> list = new ArrayList<>();
        int i = 0, j = 0;
        int[] prev = null;
        if (l1[0][0] < l2[0][0]) {
            prev = l1[0];
            i++;
        } else {
            prev = l2[0];
            j++;
        }
        while (i < l1.length || j < l2.length) {
            if (j == l2.length || (i < l1.length && l1[i][0] < l2[j][0])) {
                if (prev[1] < l1[i][0]) {
                    list.add(prev);
                    prev = l1[i];
                } else {
                    prev[1] = Math.max(prev[1], l1[i][1]);
                }
                i++;
            } else if (i == l1.length || (j < l2.length && l1[i][0] >= l2[j][0])) {
                if (prev[1] < l2[j][0]) {
                    list.add(prev);
                    prev = l2[j];
                } else {
                    prev[1] = Math.max(prev[1], l2[j][1]);
                }
                j++;
            }
        }
        list.add(prev);
        return list;
    }

    static int[] merge3Lists(int[] l1, int[] l2, int[] l3) {
        List<Integer> list = new ArrayList<>();
        int i = 0, j = 0, k = 0;
        while (i < l1.length || j < l2.length || k < l3.length) {
            int n1 = i < l1.length ? l1[i] : Integer.MAX_VALUE;
            int n2 = j < l2.length ? l2[j] : Integer.MAX_VALUE;
            int n3 = k < l3.length ? l3[k] : Integer.MAX_VALUE;
            int min = Math.min(n1, Math.min(n2, n3));
            list.add(min);
            if (n1 == min) i++;
            if (n2 == min) j++;
            if (n3 == min) k++;
        }
        int[] res = new int[list.size()];
        for (int l = 0; l < list.size(); l++) {
            res[l] = list.get(l);
        }
        return res;
    }

    static int maxOverlappingPoints(int[][] intervals, int m) {
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int index = 0;
        int resIndex = -1, max = 0;
        for (int i = -m; i < m + 1; i++) {
            while (!pq.isEmpty() && i > pq.peek()) {
                pq.poll();
            }
            while (index < intervals.length && intervals[index][0] == i) {
                pq.add(intervals[index][1]);
                index++;
            }
            if (pq.size() > max) {
                max = pq.size();
                resIndex = i;
            }
        }
        return resIndex;
    }

    static int maxOverlappingPoints2(int[][] intervals, int m) {
        int[] count = new int[2 * m + 1];
        for (int[] interval : intervals) {
            count[interval[0] + m]++;
            count[interval[1] + m]--;
        }
        int max = 0, res = -1, overlap = 0;
        for (int i = 0; i < count.length; i++) {
            overlap += count[i];
            if (overlap > max) {
                max = count[i];
                res = i - m;
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 1, 1, 1, 2, 2, 2, 2, 5, 5, 5, 7, 7, 8, 8, 10};
//        System.out.println(countUniqueInSortedArray(nums));
//        int[] l1 = {0, 10, 21, 23, 28};
//        int[] l2 = {10, 12, 24, 28, 50};
//        int[] l3 = {-1, 12, 21, 29};
//        int[] merge = merge3Lists(l1, l2, l3);
//        System.out.println(Arrays.toString(merge));

        int[][] l1 = {{-1, 0}, {1, 3}, {4, 10}};
        int[][] l2 = {{-2, -1}, {7, 12}};
        List<int[]> solution = unionIntervals(l1, l2);
        for (int[] ints : solution) {
            System.out.println(Arrays.toString(ints));
        }

        int[][] intervals = {{-3, 5}, {0, 2}, {0, 1}, {0, 3}, {8, 10}, {6, 7}, {6, 9}};
        System.out.println(maxOverlappingPoints2(intervals, 10));
    }
}
