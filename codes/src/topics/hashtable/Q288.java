package topics.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q288 {
}

class ValidWordAbbr {
    Map<String, Set<String>> map;

    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<>();
        for (String word : dictionary) {
            String abbr = getAbbr(word);
            map.putIfAbsent(abbr, new HashSet<>());
            map.get(abbr).add(word);
        }
    }

    private String getAbbr(String word) {
        if (word.length() <= 2) return word;
        return word.substring(0, 1) + (word.length() - 2) + word.substring(word.length() - 1);
    }

    public boolean isUnique(String word) {
        String abbr = getAbbr(word);
        return !map.containsKey(abbr) || map.get(abbr).contains(word) && map.get(abbr).size() == 1;
    }
}