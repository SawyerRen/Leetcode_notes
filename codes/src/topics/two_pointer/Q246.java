package topics.two_pointer;

import java.util.HashMap;
import java.util.Map;

public class Q246 {
    public boolean isStrobogrammatic(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (!map.containsKey(s.charAt(i)) || !map.containsKey(s.charAt(j))) return false;
            if (map.get(s.charAt(i)) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
