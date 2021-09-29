package karat.domain;

import java.util.*;

public class Q1 {
    public static List<String> countDomain(String[] domains) {
        Map<String, Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        for (String domain : domains) {
            String[] split = domain.split(" ");
            int count = Integer.parseInt(split[0]);
            String[] subDomains = split[1].split("\\.");
            StringBuilder builder = new StringBuilder();
            for (int i = subDomains.length - 1; i >= 0; i--) {
                if (builder.length() == 0) builder.append(subDomains[i]);
                else builder.insert(0, subDomains[i] + ".");
                map.put(builder.toString(), map.getOrDefault(builder.toString(), 0) + count);
            }
        }
        for (String domain : map.keySet()) {
            res.add(domain + " " + map.get(domain));
        }
        return res;
    }
}
