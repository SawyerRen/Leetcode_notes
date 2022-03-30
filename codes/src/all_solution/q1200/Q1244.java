package all_solution.q1200;

import model.TreeNode;

import java.util.*;

public class Q1244 {
    class Leaderboard {
        Map<Integer, Integer> map = new HashMap<>();
        TreeMap<Integer, Integer> treeMap = new TreeMap<>(Comparator.reverseOrder());

        public Leaderboard() {

        }

        public void addScore(int playerId, int score) {
            if (!map.containsKey(playerId)) {
                map.put(playerId, score);
                treeMap.put(score, treeMap.getOrDefault(score, 0) + 1);
            } else {
                int preScore = map.get(playerId);
                treeMap.put(preScore, treeMap.get(preScore) - 1);
                if (treeMap.get(preScore) == 0) treeMap.remove(preScore);
                score = map.get(playerId) + score;
                map.put(playerId, score);
                treeMap.put(score, treeMap.getOrDefault(score, 0) + 1);
            }
        }

        public int top(int K) {
            int sum = 0;
            for (Integer score : treeMap.keySet()) {
                if (K == 0) break;
                Integer count = treeMap.get(score);
                while (K > 0 && count > 0) {
                    sum += score;
                    K--;
                    count--;
                }
            }
            return sum;
        }

        public void reset(int playerId) {
            Integer preScore = map.get(playerId);
            treeMap.put(preScore, treeMap.get(preScore) - 1);
            if (treeMap.get(preScore) == 0) treeMap.remove(preScore);
            treeMap.put(0, treeMap.getOrDefault(0, 0) + 1);
            map.put(playerId, 0);
        }
    }
}
