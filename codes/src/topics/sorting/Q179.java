package topics.sorting;

import java.util.Arrays;
import java.util.Comparator;

public class Q179 {
    public String largestNumber(int[] nums) {
        if (nums.length == 0) return "0";
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strings, (a, b) -> (b + a).compareTo(a + b));
        if (strings[0].charAt(0) == '0') return "0";
        StringBuilder builder = new StringBuilder();
        for (String string : strings) {
            builder.append(string);
        }
        return builder.toString();
    }
}
