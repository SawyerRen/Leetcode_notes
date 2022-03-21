package all_solution.q800;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Q895 {
    class FreqStack {
        Map<Integer, Integer> freqMap;
        Map<Integer, Stack<Integer>> valMap;
        int maxFreq;

        public FreqStack() {
            freqMap = new HashMap<>();
            valMap = new HashMap<>();
        }

        public void push(int val) {
            int freq = freqMap.getOrDefault(val, 0) + 1;
            maxFreq = Math.max(maxFreq, freq);
            freqMap.put(val, freq);
            valMap.putIfAbsent(freq, new Stack<>());
            valMap.get(freq).add(val);
        }

        public int pop() {
            Stack<Integer> stack = valMap.get(maxFreq);
            Integer val = stack.pop();
            if (stack.size() == 0) {
                maxFreq--;
            }
            freqMap.put(val, freqMap.get(val) - 1);
            return val;
        }
    }
}
