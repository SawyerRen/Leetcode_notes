package all_solution.q300;

import java.util.HashMap;
import java.util.Map;

public class Q248 {
    int count = 0;

    public int strobogrammaticInRange(String low, String high) {
        Map<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('9', '6');
        map.put('8', '8');
        for (int len = low.length(); len <= high.length(); len++) {
            helper(map, new char[len], 0, len - 1, low, high);
        }
        return count;
    }

    private void helper(Map<Character, Character> map, char[] chars, int left, int right, String low, String high) {
        if (left > right) {
            String s = new String(chars);
            if (s.compareTo(low) > 0 && s.compareTo(high) < 0) count++;
            return;
        }
        for (Character key : map.keySet()) {
            if (left == 0 && left < right && key == '0') continue;
            if (left == right && (key == '6' || key == '9')) continue;
            chars[left] = key;
            chars[right] = map.get(key);
            helper(map, chars, left + 1, right - 1, low, high);
        }
    }
}
