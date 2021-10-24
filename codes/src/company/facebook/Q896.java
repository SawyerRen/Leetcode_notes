package company.facebook;

public class Q896 {
    public boolean isMonotonic(int[] nums) {
        Boolean increase = null;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                if (increase != null && !increase) return false;
                increase = true;
            } else if (nums[i] < nums[i - 1]) {
                if (increase != null && increase) return false;
                increase = false;
            }
        }
        return true;
    }
}
