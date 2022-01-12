package company.ffff;

import java.util.Map;

public class Q1344 {
    public double angleClock(int hour, int minutes) {
        double m = minutes * 6;
        double h = (hour % 12) * 30 + 0.5 * minutes;
        double res = Math.abs(m - h);
        if (res > 180) {
            res = 360 - res;
        }
        return res;
    }
}
