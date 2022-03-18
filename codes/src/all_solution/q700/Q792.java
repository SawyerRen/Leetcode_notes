package all_solution.q700;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Q792 {
    public int numMatchingSubseq(String s, String[] words) {
        Map<Character, LinkedList<String>> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            map.put((char) (i + 'a'), new LinkedList<>());
        }
        for (String word : words) {
            map.get(word.charAt(0)).addLast(word);
        }
        int count = 0;
        for (char c : s.toCharArray()) {
            LinkedList<String> list = map.get(c);
            int size = list.size();
            for (int i = 0; i < size; i++) {
                String word = list.removeFirst();
                if (word.length() == 1) {
                    count++;
                } else {
                    map.get(word.charAt(1)).addLast(word.substring(1));
                }
            }
        }
        return count;
    }
}
