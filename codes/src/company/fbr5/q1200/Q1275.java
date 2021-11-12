package company.fbr5.q1200;

public class Q1275 {
    public String tictactoe(int[][] moves) {
        int[] rows = new int[3];
        int[] cols = new int[3];
        int diagonal = 0, antiDiagonal = 0;
        String player = "A";
        for (int[] move : moves) {
            int val = player.equals("A") ? 1 : -1;
            int i = move[0], j = move[1];
            rows[i] += val;
            cols[j] += val;
            if (i == j) diagonal += val;
            if (i == 2 - j) antiDiagonal += val;
            if (Math.abs(rows[i]) == 3 || Math.abs(cols[j]) == 3 || Math.abs(antiDiagonal) == 3
                    || Math.abs(diagonal) == 3) return player;
            player = player.equals("A") ? "B" : "A";
        }
        if (moves.length == 9) return "Draw";
        return "Pending";
    }
}
