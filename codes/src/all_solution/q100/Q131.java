package all_solution.q100;

import java.util.ArrayList;
import java.util.List;

public class Q131 {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        helper(res, s, new ArrayList<String>());
        return res;
    }

    private void helper(List<List<String>> res, String s, ArrayList<String> list) {
        if (s.length() == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            String sub = s.substring(0, i + 1);
            if (isPal(sub)) {
                list.add(sub);
                helper(res, s.substring(i + 1), list);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPal(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
