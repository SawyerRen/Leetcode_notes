package topics.array;

public class Q251 {
}

class Vector2D {
    int[][] vector;
    int i, j;

    public Vector2D(int[][] v) {
        this.vector = v;
    }

    public int next() {
        if (hasNext()) {
            return vector[i][j++];
        }
        return -1;
    }

    public boolean hasNext() {
        while (i < vector.length && j >= vector[i].length) {
            i++;
            j = 0;
        }
        return i < vector.length && j < vector[i].length;
    }
}