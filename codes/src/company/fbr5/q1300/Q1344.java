package company.fbr5.q1300;

public class Q1344 {
    public double angleClock(int hour, int minutes) {
        double m = minutes * 6;
        double h = 30 * (hour % 12) + minutes * 0.5;
        double res = Math.abs(m - h);
        if (res > 180) res = 360 - res;
        return res;
    }
}
