package ng2022.oa.amazon;

/**
 * Parameters:
 * scores : List of int
 * cutOffRank : int
 * num: int (denoting amount of scores)
 * <p>
 * You are given a list of integers representing scores of players in a video game. Players can 'level-up' if by the end of the game they have a rank that is at most the cutOffRank. A player's rank is solely determined by their score relative to the other players' scores. For example:
 * <p>
 * Score : 10 | Rank 1
 * Score : 5 | Rank 2
 * Score : 3 | Rank 3
 * etc.
 * <p>
 * If multiple players happen to have the same score, then they will all receive the same rank. However, the next player with a score lower than theirs will receive a rank that is offset by this. For example:
 * <p>
 * Score: 10 | Rank 1
 * Score: 10 | Rank 1
 * Score: 10 | Rank 1
 * Score : 5 | Rank 4
 * <p>
 * Finally, any player with a score of 0 is automatically ineligible for leveling-up, regardless of their rank.
 * <p>
 * Return the number of players who are eligible for leveling-up
 */
public class CutOffRank {
    public static int solution(int cutOffRank, int num, int[] scores) {
        if (cutOffRank == 0) return 0;
        int[] count = new int[101];
        for (int score : scores) {
            count[score]++;
        }
        int res = 0;
        for (int i = 100; i > 0; i--) {
            if (cutOffRank <= 0) break;
            res += count[i];
            cutOffRank -= count[i];
        }
        return res;
    }
}
