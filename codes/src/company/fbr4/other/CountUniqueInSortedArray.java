package company.fbr4.other;

public class CountUniqueInSortedArray {
    static int countUnique(int[] nums) {
        int count = 0;
        int index = 0;
        while (index < nums.length) {
            count++;
            index = getNextIndex(nums, nums[index] + 1, index);
        }
        return count;
    }

    private static int getNextIndex(int[] nums, int target, int left) {
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 2, 2, 2, 3, 4, 4, 4, 6, 6, 10, 12, 99, 99, 99, 99, 100};
        System.out.println(countUnique(nums));
    }
}
