package ng2022.oa.citadel;

import java.util.Map;

public class OddStrings {
    private static String solution(String[] strs, int m) {
        boolean[] isEven = new boolean[strs.length];
        for (int i = 0; i < strs.length; i++) {
            boolean even = false;
            for (char c : strs[i].toCharArray()) {
                if ((int) c % 2 == 0) {
                    even = true;
                }
            }
            isEven[i] = even;
        }
        int oddCount = 0;
        for (boolean even : isEven) {
            if (!even) oddCount++;
        }
        return oddCount % 2 == 0 ? "EVEN" : "ODD";
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"abc", "abcd"}, 2));
    }
}
