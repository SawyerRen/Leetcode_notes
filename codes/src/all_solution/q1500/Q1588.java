package all_solution.q1500;

public class Q1588 {
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length, res = 0;
        int[] preSum = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            preSum[i] = preSum[i - 1] + arr[i - 1];
            int index = i - 1;
            while (index >= 0) {
                res += preSum[i] - preSum[index];
                index -= 2;
            }
        }
        return res;
    }
}
