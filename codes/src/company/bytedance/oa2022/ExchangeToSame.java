package company.bytedance.oa2022;

import java.util.Arrays;

public class ExchangeToSame {
    static int[] solution(String[] list1, String[] list2) {
        int[] res = new int[list1.length];
        for (int i = 0; i < list1.length; i++) {
            if (list1[i].equals(list2[i])) res[i] = 0;
            else if (list1[i].length() != list2[i].length()) res[i] = -1;
            else {
                int c = 0;
                int[] hash1 = new int[26];
                int[] hash2 = new int[26];

                res[i] = c;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] l1 = {"a", "ab", "abb"};
        String[] l2 = {"a", "bb", "fudg"};
        System.out.println(Arrays.toString(solution(l1, l2)));
    }
}
