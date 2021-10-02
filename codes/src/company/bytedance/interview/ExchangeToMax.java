package company.bytedance.interview;

public class ExchangeToMax {
    static void exchange(int[] nums, int k) {
        int start = 0;
        while (k > 0) {
            int maxIndex = -1;
            int max = Integer.MIN_VALUE;
            for (int i = start; i <= start + k && i < nums.length; i++) {
                if (nums[i] > max) {
                    max = nums[i];
                    maxIndex = i;
                }
            }
            int step = 0;
            for (int i = maxIndex; i > start; i--) {
                swap(nums, i - 1, i);
                step++;
            }
            start++;
            k -= step;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 8, 9, 3};
        exchange(arr, 4);
        for (int i : arr) {
            System.out.println(i + " ");
        }
    }
}
