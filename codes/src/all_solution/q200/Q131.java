package all_solution.q200;

import java.util.ArrayList;
import java.util.List;

public class Q131 {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), s);
        return res;
    }

    private void helper(List<List<String>> res, ArrayList<String> list, String s) {
        if (s.length() == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            String sub = s.substring(0, i + 1);
            if (isPal(sub)) {
                list.add(sub);
                helper(res, list, s.substring(i + 1));
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPal(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
