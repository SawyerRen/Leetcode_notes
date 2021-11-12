package company.fbr5.other;

public class CountUniqueInArray {
    static int countUnique(int[] nums) {
        int index = 0, count = 0;
        while (index < nums.length) {
            count++;
            index = getNext(nums, index, nums[index] + 1);
        }
        return count;
    }

    private static int getNext(int[] nums, int left, int target) {
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}
