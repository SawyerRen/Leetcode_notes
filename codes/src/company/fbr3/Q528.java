package company.fbr3;

import java.util.Random;

public class Q528 {

}

class Solution1 {
    int[] preSum;
    Random random;

    public Solution1(int[] w) {
        preSum = new int[w.length];
        preSum[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            preSum[i] = w[i] + preSum[i - 1];
        }
        random = new Random();
    }

    public int pickIndex() {
        int index = random.nextInt(preSum[preSum.length - 1]) + 1;
        int left = 0, right = preSum.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (preSum[mid] >= index) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}