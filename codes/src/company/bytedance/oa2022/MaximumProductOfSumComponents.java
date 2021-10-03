package company.bytedance.oa2022;

import java.util.Arrays;

public class MaximumProductOfSumComponents {
    static String maxProduct(int n, int k) {
        if (2 * k > n) return "-1";
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                if (i - j >= k) {
                    dp[i] = Math.max(dp[i], dp[j] * (i - j));
                }
            }
        }
        return String.valueOf(dp[n]);
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(8, 2));
        System.out.println(maxProduct(8, 3));
        System.out.println(maxProduct(8, 5));
        System.out.println(maxProduct(32, 5));
        System.out.println(maxProduct(17, 5));
        System.out.println(maxProduct(20, 5));
        System.out.println(maxProduct(2, 1));
    }
}
