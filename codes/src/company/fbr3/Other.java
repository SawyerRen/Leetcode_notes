package company.fbr3;

import javax.sound.midi.Soundbank;
import java.util.*;

public class Other {
    /**
     * Count distinct elements in an array
     */
    static int unique(int[] nums) {
        int i = 0;
        int count = 0;
        while (i < nums.length) {
            count++;
            i = getNextIndex(nums, i, nums[i] + 1);
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

    /**
     * Point in max overlapping intervals
     */
    static int maxOverlappingIndex(int[][] intervals, int m) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int index = 0;
        int res = -1, max = 0;
        for (int i = -m; i <= m; i++) {
            if (!pq.isEmpty() && i > pq.peek()) {
                pq.poll();
            }
            while (index < intervals.length && intervals[index][0] == i) {
                pq.add(intervals[index++][1]);
            }
            if (pq.size() > max) {
                res = i;
                max = pq.size();
            }
        }
        return res;
    }

    static int maxOverlappingIndex1(int[][] intervals, int m) {
        int[] count = new int[2 * m + 1];
        for (int[] interval : intervals) {
            count[interval[0] + m]++;
            count[interval[1] + m]--;
        }
        int overlap = 0, res = -1, max = 0;
        for (int i = 0; i < count.length; i++) {
            overlap += count[i];
            if (overlap > max) {
                res = i - m;
                max = overlap;
            }
        }
        return res;
    }

    /**
     * merge 3sorted list
     */
    static List<Integer> merge3List(int[] l1, int[] l2, int[] l3) {
        int i = 0, j = 0, k = 0;
        List<Integer> list = new ArrayList<>();
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
        return list;
    }

    /**
     * change base of number
     */
    static String changeBase(int num, int base) {
        StringBuilder builder = new StringBuilder();
        while (num != 0) {
            builder.append(num % base);
            num /= base;
        }
        return builder.reverse().toString();
    }

    static List<int[]> unionIntervals(int[][] l1, int[][] l2) {
        List<int[]> res = new ArrayList<>();
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
                    res.add(prev);
                    prev = l1[i];
                } else {
                    prev[1] = Math.max(prev[1], l1[i][1]);
                }
                i++;
            } else if (i == l1.length || (j < l2.length && l1[i][0] >= l2[j][0])) {
                if (prev[1] < l2[j][0]) {
                    res.add(prev);
                    prev = l2[j];
                } else {
                    prev[1] = Math.max(prev[1], l2[j][1]);
                }
                j++;
            }
        }
        res.add(prev);
        return res;
    }

    /**
     * split array into 2 equal sum
     */
    static List<int[]> splitEqualSum(int[] nums) {
        List<int[]> res = new ArrayList<>();
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        if (total % 2 != 0) return null;
        int sum = 0, index = -1;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum * 2 == total) {
                index = i;
                break;
            }
        }
        res.add(Arrays.copyOf(nums, index + 1));
        res.add(Arrays.copyOfRange(nums, index + 1, nums.length));
        return res;
    }

    /**
     * sum of float number
     */
    static String sumOfFloat(String s1, String s2) {
        String[] split1 = s1.split("\\.");
        String[] split2 = s2.split("\\.");
        String sub1 = split1.length == 1 ? "0" : split1[1];
        String sub2 = split2.length == 1 ? "0" : split2[1];
        while (sub1.length() != sub2.length()) {
            if (sub1.length() < sub2.length()) {
                sub1 += "0";
            } else {
                sub2 += "0";
            }
        }
        int carry = 0;
        StringBuilder builder = new StringBuilder();
        carry = addHelper(builder, sub1, sub2, carry);
        builder.append(".");
        carry = addHelper(builder, split1[0], split2[0], carry);
        if (carry != 0) {
            builder.append(carry);
        }
        return builder.reverse().toString();
    }

    static private int addHelper(StringBuilder builder, String s1, String s2, int carry) {
        int i = s1.length() - 1, j = s2.length() - 1;
        while (i >= 0 || j >= 0) {
            int n1 = i >= 0 ? s1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? s2.charAt(j) - '0' : 0;
            int sum = n1 + n2 + carry;
            builder.append(sum % 10);
            carry = sum / 10;
            i--;
            j--;
        }
        return carry;
    }

    /**
     * unique substring unique size k
     */
    public static Set<String> uniqueSizeK(String s, int k) {
        Set<String> res = new HashSet<>();
        Set<Character> set = new HashSet<>();
        int i = 0, j = 0;
        while (j < s.length()) {
            char rc = s.charAt(j);
            while (set.contains(rc)) {
                set.remove(s.charAt(i));
                i++;
            }
            set.add(rc);
            if (set.size() == k) {
                res.add(s.substring(i, j + 1));
            }
            j++;
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] nums = {0, 0, 0, 0, 1, 2, 2, 2, 4, 4, 4, 6, 10};
//        System.out.println(unique(nums));
//        int[][] intervals = {{-3, 5}, {0, 2}, {8, 10}, {6, 7}};
//        System.out.println(maxOverlappingIndex(intervals, 10));
//        System.out.println(maxOverlappingIndex1(intervals, 10));
//        int[] l1 = {0, 10, 21, 23, 28};
//        int[] l2 = {10, 12, 24, 28, 50};
//        int[] l3 = {-1, 12, 21, 29};
//        List<Integer> merge = merge3List(l1, l2, l3);
//        System.out.println(merge);
//        int[][] l5 = {{-1, 0}, {1, 3}, {4, 10}};
//        int[][] l4 = {{-2, -1}, {7, 12}};
//        List<int[]> solution = unionIntervals(l5, l4);
//        for (int[] ints : solution) {
//            System.out.println(Arrays.toString(ints));
//        }
        int[] nums = {5, 2, 3};
        List<int[]> res = splitEqualSum(nums);
        for (int[] re : res) {
            System.out.println(Arrays.toString(re));
        }

        String str1 = "123.52";
        String str2 = "11.2";
        String ans = sumOfFloat(str1, str2);
        System.out.println(ans);

        //Example 2:
        str1 = "110.75";
        str2 = "9";
        ans = sumOfFloat(str1, str2);
        System.out.println(ans);

        String s = "abacab";
        int k = 3;
        Set<String> set = uniqueSizeK(s, k);
        for (String s1 : set) {
            System.out.println(s1);
        }
    }
}
