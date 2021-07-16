package topics.two_pointer;

import java.util.HashMap;
import java.util.Map;

public class Q248 {
    int res = 0;

    public int strobogrammaticInRange(String low, String high) {
        Map<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');
        for (int len = low.length(); len <= high.length(); len++) {
            helper(map, new char[len], 0, len - 1, low, high);
        }
        return res;
    }

    private void helper(Map<Character, Character> map, char[] chars, int left, int right, String low, String high) {
        if (left > right) {
            String s = new String(chars);
            if (low.compareTo(s) < 0 && high.compareTo(s) > 0) res++;
            return;
        }
        for (Character key : map.keySet()) {
            if (left == 0 && key == '0') continue;
            if (left == right && (key == '6' || key == '9')) continue;
            chars[left] = key;
            chars[right] = map.get(key);
            helper(map, chars, left + 1, right - 1, low, high);
        }
    }
}
