package company.facebook;

import java.util.Random;

public class Q528 {
    class Solution {
        int[] preSum;
        Random random;

        public Solution(int[] w) {
            int n = w.length;
            preSum = new int[n];
            preSum[0] = w[0];
            for (int i = 1; i < n; i++) {
                preSum[i] = preSum[i - 1] + w[i];
            }
            random = new Random();
        }

        public int pickIndex() {
            int target = random.nextInt(preSum[preSum.length - 1]) + 1;
            int left = 0, right = preSum.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (preSum[mid] >= target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }
    }
}


