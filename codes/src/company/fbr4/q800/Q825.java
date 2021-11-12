package company.fbr4.q800;

import java.util.Arrays;

public class Q825 {
    public int numFriendRequests(int[] ages) {
        int[] ageCount = new int[121];
        for (int age : ages) {
            ageCount[age]++;
        }
        int[] ageSum = new int[121];
        int sum = 0, res = 0;
        for (int i = 15; i < 121; i++) {
            sum += ageCount[i];
            ageSum[i] = sum;
            if (ageCount[i] == 0) continue;
            int count = ageSum[i] - ageSum[i / 2 + 7];
            res += count * ageCount[i] - ageCount[i];
        }
        return res;
    }

    public int numFriendRequests1(int[] ages) {
        Arrays.sort(ages);
        int res = 0;
        for (int i = 0; i < ages.length; i++) {
            if (ages[i] < 15) continue;
            int left = leftBound(ages, ages[i] / 2 + 8, 0, i);
            int right = leftBound(ages, ages[i] + 1, i + 1, ages.length) - 1;
            if (right >= left) res += (right - left);
        }
        return res;
    }

    private int leftBound(int[] ages, int target, int left, int right) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (ages[mid] >= target) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}
