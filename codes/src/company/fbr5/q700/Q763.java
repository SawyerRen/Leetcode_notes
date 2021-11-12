package company.fbr5.q700;

import java.util.ArrayList;
import java.util.List;

public class Q763 {
    public List<Integer> partitionLabels(String s) {
        int[] index = new int[26];
        for (int i = 0; i < s.length(); i++) {
            index[s.charAt(i) - 'a'] = i;
        }
        List<Integer> res = new ArrayList<>();
        int curMax = 0, preLen = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            curMax = Math.max(curMax, index[c - 'a']);
            if (curMax == i) {
                res.add(i - preLen + 1);
                preLen = i + 1;
            }
        }
        return res;
    }
}
