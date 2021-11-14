package company.fbfinal;

public class Q896 {
    public boolean isMonotonic(int[] nums) {
        Boolean increase = null;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] > nums[i]) {
                if (increase != null && !increase) return false;
                increase = true;
            } else if (nums[i + 1] < nums[i]) {
                if (increase != null && increase) return false;
                increase = false;
            }
        }
        return true;
    }
}
