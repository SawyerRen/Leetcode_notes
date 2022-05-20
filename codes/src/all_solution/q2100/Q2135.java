package all_solution.q2100;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q2135 {
    public int wordCount(String[] startWords, String[] targetWords) {
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for (String startWord : startWords) {
            set.add(toBinary(startWord));
        }
        for (String targetWord : targetWords) {
            int bits = toBinary(targetWord);
            for (int i = 0; i < 26; i++) {
                int mask = 1 << i;
                if ((bits & mask) > 0) {
                    int temp = bits & ~mask;
                    if (set.contains(temp)) {
                        res++;
                        break;
                    }
                }
            }
        }
        return res;
    }

    private Integer toBinary(String word) {
        int bit = 0;
        for (char c : word.toCharArray()) {
            bit += (1 << (c - 'a'));
        }
        return bit;
    }
}
