package topics.bit_manipulation;

public class Q260 {
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        int[] res = new int[2];
        // 找到diff最右边的1，用这个1来区分两个数
        diff = diff & (-diff);
        for (int num : nums) {
            if ((num & diff) == 0) res[0] ^= num;
            else res[1] ^= num;
        }
        return res;
    }
}
