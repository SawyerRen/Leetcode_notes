package topics.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q131 {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        helper(res, new LinkedList<>(), s);
        return res;
    }

    private void helper(List<List<String>> res, LinkedList<String> list, String s) {
        if (s.length() == 0) {
            res.add(new LinkedList<>(list));
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            String sub = s.substring(0, i + 1);
            if (check(sub)) {
                list.addLast(sub);
                helper(res, list, s.substring(i + 1));
                list.removeLast();
            }
        }
    }

    private boolean check(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
