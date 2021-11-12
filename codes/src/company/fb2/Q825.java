package company.fb2;

import java.util.Arrays;

public class Q825 {
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int res = 0;
        for (int i = ages.length - 1; i >= 0; i--) {
            if (ages[i] < 15) break;
            int left = leftBound(ages, 0, i, ages[i] / 2 + 8);
            int right = leftBound(ages, i + 1, ages.length, ages[i] + 1) - 1;
            res += Math.max(right - left, 0);
        }
        return res;
    }

    private int leftBound(int[] ages, int left, int right, int target) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (ages[mid] >= target) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}
