package company.fbr3;

public class Q1344 {
    public double angleClock(int hour, int minutes) {
        double mAngle = 6 * minutes;
        double hAngle = hour % 12 * 30 + 30 * (minutes / 60.0);
        double angle = Math.abs(mAngle - hAngle);
        if (angle > 180) angle = 360 - angle;
        return angle;
    }
}
