package all_solution.q200;

public class Q169 {
    public int majorityElement(int[] nums) {
        int res = nums[0];
        int count = 0;
        for (int num : nums) {
            if (num == res) count++;
            else count--;
            if (count == 0) {
                res = num;
                count++;
            }
        }
        return res;
    }
}
