package all_solution.q200;

import java.util.ArrayList;
import java.util.List;

public class Q293 {
    public List<String> generatePossibleNextMoves(String currentState) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < currentState.length() - 1; i++) {
            if (currentState.charAt(i) == '+' && currentState.charAt(i + 1) == '+') {
                char[] chars = currentState.toCharArray();
                chars[i] = chars[i] == '+' ? '-' : '+';
                chars[i + 1] = chars[i + 1] == '+' ? '-' : '+';
                res.add(new String(chars));
            }
        }
        return res;
    }
}
