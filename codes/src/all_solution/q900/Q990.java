package all_solution.q900;

public class Q990 {
    public boolean equationsPossible(String[] equations) {
        int[] parents = new int[26];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                union(parents, equation.charAt(0), equation.charAt(3));
            }
        }
        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                if (find(parents, equation.charAt(0) - 'a') == find(parents, equation.charAt(3) - 'a'))
                    return false;
            }
        }
        return true;
    }

    int find(int[] parents, int i) {
        while (i != parents[i]) {
            parents[i] = parents[parents[i]];
            i = parents[i];
        }
        return i;
    }

    private void union(int[] parents, char c1, char c2) {
        int p1 = find(parents, c1 - 'a');
        int p2 = find(parents, c2 - 'a');
        if (p1 == p2) return;
        parents[p2] = p1;
    }
}
