package company.fbr4.p100;

public class Q169 {
    public int majorityElement(int[] nums) {
        int res = 0, count = 0;
        for (int num : nums) {
            if (count == 0) {
                res = num;
                count = 0;
            }
            if (res == num) {
                count++;
            } else {
                count--;
            }
        }
        return res;
    }
}
