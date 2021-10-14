package company.facebook;

public class Q1344 {
    public double angleClock(int hour, int minutes) {
        double minDist = minutes * 6;
        double hourDist = hour % 12 * 30 + 30 * (minutes / 60.0);
        double angle = Math.abs(minDist - hourDist);
        if (angle > 180) angle = 360 - angle;
        return angle;
    }
}
