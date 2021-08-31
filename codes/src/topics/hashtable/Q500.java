package topics.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q500 {
    public String[] findWords(String[] words) {
        String[] lines = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < lines.length; i++) {
            for (char c : lines[i].toCharArray()) {
                map.put(c, i);
            }
        }
        List<String> list = new ArrayList<>();
        for (String s : words) {
            if (s.equals("")) continue;
            String word = s.toLowerCase();
            int index = map.get(word.charAt(0));
            boolean valid = true;
            for (char c : word.toCharArray()) {
                if (map.get(c) != index) {
                    valid = false;
                    break;
                }
            }
            if (valid) list.add(s);
        }
        String[] res = new String[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
