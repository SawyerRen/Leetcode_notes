package company.fbr4.again;

import java.util.ArrayList;
import java.util.List;

public class Q763 {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        int[] index = new int[26];
        for (int i = 0; i < s.length(); i++) {
            index[s.charAt(i) - 'a'] = i;
        }
        int curMax = 0, preLen = 0;
        for (int i = 0; i < s.length(); i++) {
            curMax = Math.max(curMax, index[s.charAt(i) - 'a']);
            if (curMax == i) {
                res.add(i - preLen + 1);
                preLen = i + 1;
            }
        }
        return res;
    }
}
