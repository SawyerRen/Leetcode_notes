package company.bytedance.oa;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
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
            if (valid(s, 0, i)) {
                String substring = s.substring(0, i + 1);
                list.add(substring);
                helper(res, s.substring(i + 1), list);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean valid(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
