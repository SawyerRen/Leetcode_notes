import java.util.Arrays;

public class Test {
    static int solution(int[] nums1, int[] nums2) {
        return helper(nums1, nums2, 0, 0);
    }

    private static int helper(int[] nums1, int[] nums2, int start, int index) {
        if (index == nums2.length) return 1;
        int res = 0;
        for (int i = start; i < nums1.length; i++) {
            if (nums1[i] == nums2[index]) {
                res += helper(nums1, nums2, i + 1, index + 1);
            }
        }
        return res;
    }

    static int solution1(int[] nums1, int[] nums2) {
        int[][] memo = new int[nums1.length][nums2.length];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        return helper1(nums1, nums2, 0, 0, memo);
    }

    private static int helper1(int[] nums1, int[] nums2, int start, int index, int[][] memo) {
        if (index == nums2.length) return 1;
        if (start == nums1.length) return 0;
        if (memo[start][index] != -1) return memo[start][index];
        int res = 0;
        for (int i = start; i < nums1.length; i++) {
            if (nums1[i] == nums2[index]) {
                res += helper(nums1, nums2, i + 1, index + 1);
            }
        }
        memo[start][index] = res;
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 1, 2};
        int[] nums2 = {1, 2};
        System.out.println(solution1(nums1, nums2));
        int[] nums3 = {1, 2, 2, 1, 1, 2};
        int[] nums4 = {1, 1, 2};
        System.out.println(solution1(nums3, nums4));
        int[] nums5 = {1, 2, 1, 2, 1, 2};
        int[] nums6 = {1, 1, 2};
        System.out.println(solution1(nums5, nums6));
    }
}
