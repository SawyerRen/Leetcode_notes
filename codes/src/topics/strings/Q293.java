package topics.strings;

import java.util.ArrayList;
import java.util.List;

public class Q293 {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                StringBuilder builder = new StringBuilder(s);
                builder.replace(i, i + 2, "--");
                res.add(builder.toString());
            }
        }
        return res;
    }
}
