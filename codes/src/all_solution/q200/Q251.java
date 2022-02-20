package all_solution.q200;

public class Q251 {

}

class Vector2D {
    int i, j;
    int[][] vec;

    public Vector2D(int[][] vec) {
        this.i = 0;
        this.j = 0;
        this.vec = vec;
    }

    public int next() {
        if (!hasNext()) return -1;
        return vec[i][j++];
    }

    public boolean hasNext() {
        while (i < vec.length && j == vec[i].length) {
            i++;
            j = 0;
        }
        return i < vec.length && j < vec[i].length;
    }
}
