package topics.backtracking;

import java.util.ArrayList;

public class Q306 {
    public boolean isAdditiveNumber(String num) {
        if (num.length() < 3) return false;
        return helper(num, 0, new ArrayList<>());
    }

    private boolean helper(String num, int index, ArrayList<String> list) {
        if (num.length() == index) {
            if (list.size() >= 3) return true;
        }
        for (int i = index; i < num.length(); i++) {
            if (i > index && num.charAt(index) == '0') break;
            String sub = num.substring(index, i + 1);
            if (list.size() < 2 || String.valueOf(Long.parseLong(list.get(list.size() - 2)) + Long.parseLong(list.get(list.size() - 1))).equals(sub)) {
                list.add(sub);
                if (helper(num, i + 1, list)) return true;
                list.remove(list.size() - 1);
            }
        }
        return false;
    }
}
