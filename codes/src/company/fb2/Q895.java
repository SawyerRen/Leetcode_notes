package company.fb2;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Q895 {
    class FreqStack {
        Map<Integer, Integer> freqMap = new HashMap<>();
        Map<Integer, Stack<Integer>> map = new HashMap<>();
        int maxFreq = 0;

        public FreqStack() {

        }

        public void push(int val) {
            int freq = freqMap.getOrDefault(val, 0) + 1;
            maxFreq = Math.max(maxFreq, freq);
            map.putIfAbsent(freq, new Stack<>());
            map.get(freq).push(val);
            freqMap.put(val, freq);
        }

        public int pop() {
            Stack<Integer> stack = map.get(maxFreq);
            Integer pop = stack.pop();
            if (stack.isEmpty()) maxFreq--;
            freqMap.put(pop, freqMap.get(pop) - 1);
            return pop;
        }
    }
}
