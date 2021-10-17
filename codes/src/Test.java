import java.util.Arrays;
import java.util.PriorityQueue;

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

    static public int[] visitingCities(int[] red, int[] blue, int blueCost) {
        int n = red.length;
        int[] res = new int[n + 1];
        res[0] = 0;
        int[][] dp = new int[n + 1][2];
        dp[0][0] = 0;
        dp[0][1] = blueCost;
        for (int i = 1; i < n + 1; i++) {
            dp[i][0] = Math.min(dp[i - 1][0] + red[i - 1], dp[i - 1][1] + red[i - 1]);
            dp[i][1] = Math.min(dp[i - 1][1] + blue[i - 1], dp[i - 1][0] + blueCost + blue[i - 1]);
            res[i] = Math.min(dp[i][0], dp[i][1]);
        }
        return res;
    }

    static public int productSales(long[] inventory, int order) {
        Arrays.sort(inventory);
        long ans = 0;
        int n = inventory.length - 1;
        long count = 1;
        while (order > 0) {
            if (n > 0 && inventory[n] - inventory[n - 1] > 0 && order >= count * (inventory[n] - inventory[n - 1])) {
                ans += count * sumFromNtoX(inventory[n], inventory[n - 1]);
                order -= count * (inventory[n] - inventory[n - 1]);
            } else if (n == 0 || inventory[n] - inventory[n - 1] > 0) {
                long a = order / count;
                ans += count * sumFromNtoX(inventory[n], inventory[n] - a);
                long b = order % count;
                ans += b * (inventory[n] - a);
                order = 0;
            }
            ans %= 1000000007;
            n--;
            count++;
        }
        return (int) ans;
    }

    private static long sumFromNtoX(long n, long x) {
        return (n * (n + 1)) / 2 - (x * (x + 1)) / 2;
    }

    public static void main(String[] args) {
        long[] inventory = {6, 4};
        int order = 4;
        System.out.println(productSales(inventory, order));
    }
}
