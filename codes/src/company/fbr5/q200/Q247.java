package company.fbr5.q200;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q247 {
    public List<String> findStrobogrammatic(int n) {
        Map<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('9', '6');
        map.put('8', '8');
        List<String> res = new ArrayList<>();
        helper(res, map, new char[n], 0, n - 1);
        return res;
    }

    private void helper(List<String> res, Map<Character, Character> map, char[] chars, int left, int right) {
        if (left > right) {
            res.add(new String(chars));
            return;
        }
        for (Character c1 : map.keySet()) {
            if (left == 0 && left < right && c1 == '0') continue;
            if (left == right && (c1 == '9' || c1 == '6')) continue;
            Character c2 = map.get(c1);
            chars[left] = c1;
            chars[right] = c2;
            helper(res, map, chars, left + 1, right - 1);
        }
    }
}
