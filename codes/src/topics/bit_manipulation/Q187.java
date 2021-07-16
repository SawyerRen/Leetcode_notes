package topics.bit_manipulation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q187 {
    public List<String> findRepeatedDnaSequences(String s) {
        char[] chars = new char[26];
//        chars['A' - 'A'] = 0;
        chars['C' - 'A'] = 1;
        chars['G' - 'A'] = 2;
        chars['T' - 'A'] = 3;
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        List<String> res = new ArrayList<>();
        for (int i = 0; i < s.length() - 9; i++) {
            int value = 0;
            for (int j = i; j < i + 10; j++) {
                value <<= 2;
                value |= chars[s.charAt(j) - 'A'];
            }
            if (!set1.add(value) && set2.add(value)) {
                res.add(s.substring(i, i + 10));
            }
        }
        return res;
    }
}
