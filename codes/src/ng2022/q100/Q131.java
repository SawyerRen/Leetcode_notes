package ng2022.q100;

import java.util.ArrayList;
import java.util.List;

public class Q131 {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        helper(res, new ArrayList<String>(), s, 0);
        return res;
    }

    private void helper(List<List<String>> res, ArrayList<String> list, String s, int index) {
        if (index == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            String sub = s.substring(index, i + 1);
            if (isPal(sub)) {
                list.add(sub);
                helper(res, list, s, i + 1);
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
