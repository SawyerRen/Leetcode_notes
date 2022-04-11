package all_solution.q1300;

public class Q1344 {
    public double angleClock(int hour, int minutes) {
        double m = minutes * 6;
        double h = hour * 30 + minutes * 0.5;
        double angle = Math.abs(m - h);
        if (angle > 180) return 360 - angle;
        return angle;
    }
}
