package all_solution.q700;

import java.util.ArrayList;
import java.util.List;

public class Q763 {
    public List<Integer> partitionLabels(String s) {
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0, end = 0;
        while (j < s.length()) {
            int index = lastIndex[s.charAt(j) - 'a'];
            end = Math.max(end, index);
            if (j == end) {
                res.add(j - i + 1);
                i = j + 1;
            }
            j++;
        }
        return res;
    }
}
