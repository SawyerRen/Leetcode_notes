package topics.bit_manipulation;

import java.util.ArrayList;
import java.util.List;

public class Q401 {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> res = new ArrayList<>();
        for (int hour = 0; hour < 12; hour++) {
            for (int min = 0; min < 60; min++) {
                if (Integer.bitCount((hour << 6) | min) == turnedOn) {
                    res.add(hour + ":" + (min < 10 ? "0" + min : min));
                }
            }
        }
        return res;
    }
}
