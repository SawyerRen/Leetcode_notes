package all_solution.q1400;

public class Q1423 {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        k = n - k;
        int totalSum = 0;
        for (int cardPoint : cardPoints) {
            totalSum += cardPoint;
        }
        if (k >= n) return totalSum;
        int i = 0, j = k - 1;
        int curSum = 0;
        for (int l = i; l <= j; l++) {
            curSum += cardPoints[l];
        }
        int res = totalSum - curSum;
        while (j < n - 1) {
            j++;
            curSum += cardPoints[j];
            curSum -= cardPoints[i];
            i++;
            res = Math.max(res, totalSum - curSum);
        }
        return res;
    }
}
