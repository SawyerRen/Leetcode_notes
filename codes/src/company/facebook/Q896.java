package company.facebook;

public class Q896 {
    public boolean isMonotonic(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return true;
        Boolean increase = null;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] == nums[i]) continue;
            if (nums[i + 1] > nums[i]) {
                if (increase != null && !increase) return false;
                increase = true;
            } else {
                if (increase != null && increase) return false;
                increase = false;
            }
        }
        return true;
    }
}
