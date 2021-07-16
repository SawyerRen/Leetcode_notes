package topics.sorting;

import java.util.Arrays;

public class Q324 {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n];
        System.arraycopy(nums, 0, temp, 0, n);
        Arrays.sort(temp);
        int left, right;
        if (n % 2 == 0) {
            left = n / 2 - 1;
        } else {
            left = n / 2;
        }
        right = n - 1;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                nums[i] = temp[left--];
            } else {
                nums[i] = temp[right--];
            }
        }
    }
}
