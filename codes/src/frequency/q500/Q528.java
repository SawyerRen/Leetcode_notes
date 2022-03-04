package frequency.q500;

import java.util.Random;

public class Q528 {

}

class Solution {
    int[] preSum;
    Random random;

    public Solution(int[] w) {
        random = new Random();
        preSum = new int[w.length];
        preSum[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            preSum[i] = w[i] + preSum[i - 1];
        }
    }

    public int pickIndex() {
        int value = random.nextInt(preSum[preSum.length - 1]) + 1;
        int left = 0, right = preSum.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (preSum[mid] >= value) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
