package company.fbr5.q100;

public class Q169 {
    public int majorityElement(int[] nums) {
        int res = nums[0], count = 0;
        for (int num : nums) {
            if (count == 0) {
                res = num;
                count = 1;
            } else if (res == num) {
                count++;
            } else {
                count--;
            }
        }
        return res;
    }
}
