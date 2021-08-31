package topics.array;

public class Q485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int index = 0;
        int res = 0;
        while (index < nums.length) {
            int curLen = 0;
            while (index < nums.length && nums[index] == 1) {
                index++;
                curLen++;
            }
            res = Math.max(res, curLen);
            index++;
        }
        return res;
    }
}
