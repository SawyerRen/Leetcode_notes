package all_solution.q200;

import java.util.HashMap;
import java.util.Map;

public class Q299 {
    public String getHint(String secret, String guess) {
        int bulls = 0, cows = 0;
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < secret.length(); i++) {
            char c1 = secret.charAt(i);
            char c2 = guess.charAt(i);
            if (c1 == c2) {
                bulls++;
            } else {
                map1.put(c1, map1.getOrDefault(c1, 0) + 1);
                map2.put(c2, map2.getOrDefault(c2, 0) + 1);
            }
        }
        for (Character c1 : map1.keySet()) {
            cows += Math.min(map1.get(c1), map2.getOrDefault(c1, 0));
        }
        return bulls + "A" + cows + "B";
    }
}
