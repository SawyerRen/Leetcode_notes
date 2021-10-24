package company.facebook;

public class Q1344 {
    public double angleClock(int hour, int minutes) {
        double minuteAngle = 6 * minutes;
        double hourAngle = hour % 12 * 30 + 30 * (minutes / 60.0);
        double res = Math.abs(minuteAngle - hourAngle);
        if (res > 180) return 360 - res;
        return res;
    }
}
