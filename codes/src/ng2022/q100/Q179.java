package ng2022.q100;

import java.util.Arrays;

public class Q179 {
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (a, b) -> (b + a).compareTo(a + b));
        StringBuilder builder = new StringBuilder();
        if (strs[0].charAt(0) == '0') return "0";
        for (String str : strs) {
            builder.append(str);
        }
        return builder.toString();
    }
}
