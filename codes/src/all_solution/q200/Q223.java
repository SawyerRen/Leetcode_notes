package all_solution.q200;

public class Q223 {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int x1 = Math.max(ax1, bx1);
        int x2 = Math.min(ax2, bx2);
        int y1 = Math.max(ay1, by1);
        int y2 = Math.min(ay2, by2);
        int over = 0;
        if (x2 > x1 && y2 > y1) {
            over = (x2 - x1) * (y2 - y1);
        }
        int area1 = (ax2 - ax1) * (ay2 - ay1);
        int area2 = (bx2 - bx1) * (by2 - by1);
        return area1 + area2 - over;
    }
}
