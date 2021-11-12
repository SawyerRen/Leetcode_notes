package company.fbr4.q1300;

public class Q1334 {
    public double angleClock(int hour, int minutes) {
        double m = 6 * minutes;
        double h = hour % 12 * 30 + 0.5 * minutes;
        double angle = Math.abs(m - h);
        if (angle > 180) angle = 360 - angle;
        return angle;
    }
}
