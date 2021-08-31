package topics.math;

public class Q492 {
    public int[] constructRectangle(int area) {
        double sqrt = Math.sqrt(area);
        for (int i = (int) sqrt; i > 0; i--) {
            if (area % i == 0) return new int[]{area / i, i};
        }
        return new int[]{area, 1};
    }
}
