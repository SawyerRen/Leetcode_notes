package all_solution.q2100;

import java.util.*;

public class Q2115 {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, Set<String>> graph = new HashMap<>();
        Map<String, Integer> preCount = new HashMap<>();
        for (int i = 0; i < recipes.length; i++) {
            for (String s : ingredients.get(i)) {
                graph.putIfAbsent(s, new HashSet<>());
                graph.get(s).add(recipes[i]);
            }
            preCount.put(recipes[i], ingredients.get(i).size());
        }
        Queue<String> queue = new LinkedList<>(Arrays.asList(supplies));
        List<String> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            String poll = queue.poll();
            if (graph.containsKey(poll)) {
                for (String recipe : graph.get(poll)) {
                    preCount.put(recipe, preCount.get(recipe) - 1);
                    if (preCount.get(recipe) == 0) {
                        res.add(recipe);
                        queue.add(recipe);
                    }
                }
            }
        }
        return res;
    }
}
