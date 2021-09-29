package karat.resource;

import java.util.*;

/*
Write a function that takes the logs as input, builds the transition graph and returns it as an adjacency list with probabilities. Add START and END states.

Specifically, for each resource, we want to compute a list of every possible next step taken by any user, together with the corresponding probabilities. The list of resources should include START but not END, since by definition END is a terminal state.

Expected output for logs1:
transition_graph(logs1) # =>
{
'START': {'resource_1': 0.25, 'resource_2': 0.125, 'resource_3': 0.5, 'resource_6': 0.125},
'resource_1': {'resource_6': 0.333, 'END': 0.667},
'resource_2': {'END': 1.0},
'resource_3': {'END': 0.4, 'resource_1': 0.2, 'resource_2': 0.2, 'resource_3': 0.2},
'resource_4': {'END': 1.0},
'resource_5': {'resource_4': 1.0},
'resource_6': {'END': 0.5, 'resource_5': 0.5}
}

For example, of 8 total users, 4 users have resource_3 as a first visit (user_1, user_2, user_3, user_5), 2 users have resource_1 as a first visit (user_6, user_22), 1 user has resource_2 as a first visit (user_7), and 1 user has resource_6 (user_8) so the possible next steps for START are resource_3 with probability 4/8, resource_1 with probability 2/8, and resource_2 and resource_6 with probability 1/8.

These are the resource paths per user for the first logs example, ordered by access time:
{
'user_1': ['resource_3', 'resource_3', 'resource_1'],
'user_2': ['resource_3', 'resource_2'],
'user_3': ['resource_3'],
'user_5': ['resource_3'],
'user_6': ['resource_1', 'resource_6', 'resource_5', 'resource_4'],
'user_7': ['resource_2'],
'user_8': ['resource_6'],
'user_22': ['resource_1'],
}

Expected output for logs2:
transition_graph(logs2) # =>
{
'START': {'resource_3': 1.0},
'resource_3': {'resource_3: 0.857, 'END': 0.143}
}
 */
public class Q3 {
    public static Map<String, HashMap<String, Double>> buildTransitionMapWithProbabilities(String[][] logs) {
        if(logs == null || logs.length == 0)
            return null;

        Arrays.sort(logs, (a, b) -> {
            int time = Integer.parseInt(a[0]);
            int time2 = Integer.parseInt(b[0]);
            return time - time2;
        });

        Map<String, HashMap<String, Double>> adjMap = new HashMap<>();

        //1. build User profile
        Map<String, List<String>> userTransitionMap = new HashMap();
        for(String[] log : logs) {
            userTransitionMap.putIfAbsent(log[1], new ArrayList<String>());
            userTransitionMap.get(log[1]).add(log[2]);
        }

        // 2. Build resource transition Adj Map with start and end
        adjMap.put("START", new HashMap<String, Double>());
        for(String user : userTransitionMap.keySet()) {
            List<String> userResources = userTransitionMap.get(user);
            String firstResrc = userResources.get(0);
            adjMap.get("START").put(firstResrc, adjMap.get("START").getOrDefault(firstResrc, 0.0) + 1.0);
            for(int i = 1; i < userResources.size(); i++) {
                String prevRes = userResources.get(i-1);
                String nextRes =  userResources.get(i);
                adjMap.putIfAbsent(prevRes, new HashMap<String, Double>());
                adjMap.putIfAbsent(nextRes, new HashMap<String, Double>());
                adjMap.get(prevRes).put(nextRes, adjMap.get(prevRes).getOrDefault(nextRes, 0.0) + 1.0);
            }
            String lastRes = userResources.get(userResources.size()-1);
            adjMap.putIfAbsent(lastRes, new HashMap<String, Double>());
            adjMap.get(lastRes).put("END", adjMap.get(lastRes).getOrDefault("END", 0.0) + 1.0);
        }


        for(String res : adjMap.keySet()) {
            double total = 0.0;
            for(String subRes : adjMap.get(res).keySet())
                total += adjMap.get(res).get(subRes);
            for(String subRes : adjMap.get(res).keySet()) {
                double curr = adjMap.get(res).get(subRes);
                adjMap.get(res).put(subRes, roundTo3Decimals(curr / total));
            }
        }
        System.out.println(adjMap);
        return adjMap;
    }

    private static double roundTo3Decimals(double value) {
        return (double) Math.round(value * 1000d) / 1000d;
    }
}
