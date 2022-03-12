package all_solution.q400;

import java.util.ArrayList;
import java.util.List;

public class Q451 {
    public String frequencySort(String s) {
        int[] count = new int[128];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        List<Character>[] lists = new List[s.length() + 1];
        for (int i = 0; i < 128; i++) {
            if (lists[count[i]] == null) lists[count[i]] = new ArrayList<>();
            lists[count[i]].add((char) i);
        }
        StringBuilder builder = new StringBuilder();
        for (int i = lists.length - 1; i >= 0; i--) {
            if (lists[i] != null) {
                for (Character c : lists[i]) {
                    builder.append(String.valueOf(c).repeat(i));
                }
            }
        }
        return builder.toString();
    }
}
