package company.fbr4.q1200;

public class Q1275 {
    public String tictactoe(int[][] moves) {
        int[] rows = new int[3];
        int[] cols = new int[3];
        int diagonal = 0, antiDiagonal = 0;
        String player = "A";
        for (int[] move : moves) {
            int val = player.equals("A") ? 1 : -1;
            int row = move[0], col = move[1];
            rows[row] += val;
            cols[col] += val;
            if (row == col) diagonal += val;
            if (row == 2 - col) antiDiagonal += val;
            if (Math.abs(rows[row]) == 3|| Math.abs(cols[col]) == 3 ||
            Math.abs(diagonal) == 3 || Math.abs(antiDiagonal) == 3) return player;
            player = player.equals("A") ? "B" : "A";
        }
        if (moves.length == 9) return "Draw";
        return "Pending";
    }
}
