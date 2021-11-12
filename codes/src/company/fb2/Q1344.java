package company.fb2;

public class Q1344 {
    public double angleClock(int hour, int minutes) {
        double m = minutes * 6;
        double h = hour % 12 * 30 + 0.5 * minutes;
        double angle = Math.abs(m - h);
        if (angle > 180) angle = 360 - angle;
        return angle;
    }
}
