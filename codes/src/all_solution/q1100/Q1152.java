package all_solution.q1100;

import java.util.*;

public class Q1152 {
    class Log {
        String username;
        int timestamp;
        String website;

        public Log(String username, int timestamp, String website) {
            this.username = username;
            this.timestamp = timestamp;
            this.website = website;
        }
    }

    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        int n = username.length;
        Log[] logs = new Log[n];
        for (int i = 0; i < n; i++) {
            logs[i] = new Log(username[i], timestamp[i], website[i]);
        }
        Arrays.sort(logs, Comparator.comparingInt(a -> a.timestamp));
        Map<String, List<Log>> map = new HashMap<>();
        for (Log log : logs) {
            map.putIfAbsent(log.username, new ArrayList<>());
            map.get(log.username).add(log);
        }

        Map<String, Integer> freqMap = new HashMap<>();
        int maxFreq = 0;
        String res = "";
        for (List<Log> logList : map.values()) {
            Set<String> visited = new HashSet<>();
            for (int i = 0; i < logList.size(); i++) {
                for (int j = i + 1; j < logList.size(); j++) {
                    for (int k = j + 1; k < logList.size(); k++) {
                        Log log1 = logList.get(i);
                        Log log2 = logList.get(j);
                        Log log3 = logList.get(k);
                        String pattern = log1.website + " " + log2.website + " " + log3.website;
                        if (visited.contains(pattern)) continue;
                        visited.add(pattern);
                        freqMap.put(pattern, freqMap.getOrDefault(pattern, 0) + 1);
                        Integer freq = freqMap.get(pattern);
                        if (freq > maxFreq) {
                            maxFreq = freq;
                            res = pattern;
                        } else if (freq == maxFreq) {
                            if (pattern.compareTo(res) < 0) {
                                res = pattern;
                            }
                        }
                    }
                }
            }
        }
        return new ArrayList<>(Arrays.asList(res.split(" ")));
    }
}
