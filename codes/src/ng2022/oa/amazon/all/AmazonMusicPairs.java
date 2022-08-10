package ng2022.oa.amazon.all;

import java.util.HashMap;
import java.util.Map;

public class AmazonMusicPairs {
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int t : time) {
            int mod = t % 60;
            int need = mod == 0 ? 0 : 60 - mod;
            res += map.getOrDefault(need, 0);
            map.put(mod, map.getOrDefault(mod, 0) + 1);
        }
        return res;
    }
}
