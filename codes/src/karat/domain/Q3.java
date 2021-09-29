package karat.domain;

import java.util.*;

public class Q3 {
    public static String[] AdsConversion(String[] completedUserId, String[] adClicks, String[] allUserIp) {
        Set<String> userIdSet = new HashSet<>(Arrays.asList(completedUserId));
        Map<String, List<String>> adIpMap = new HashMap<>();
        Map<String, String> ipUserMap = new HashMap<>();
        for (String adClick : adClicks) {
            String[] split = adClick.split(",");
            String ip = split[0];
            String ad = split[2];
            List<String> list = adIpMap.getOrDefault(ad, new ArrayList<>());
            list.add(ip);
            adIpMap.put(ad, list);
        }
        for (String s : allUserIp) {
            String[] split = s.split(",");
            ipUserMap.put(split[1], split[0]);
        }
        String[] res = new String[adIpMap.keySet().size()];
        int i = 0;
        for (String ad : adIpMap.keySet()) {
            int count = 0;
            List<String> ipSet = adIpMap.get(ad);
            for (String ip : ipSet) {
                if (userIdSet.contains(ipUserMap.get(ip))) count++;
            }
            res[i++] = count + " of " + ipSet.size() + " " + ad;
        }
        return res;
    }
}
