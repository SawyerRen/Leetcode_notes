package company.fbr4.again;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class Q895 {
    class FreqStack {
        Map<Integer, Stack<Integer>> stackMap = new HashMap<>();
        Map<Integer, Integer> freqMap = new HashMap<>();
        int maxFreq = 0;

        public FreqStack() {

        }

        public void push(int val) {
            freqMap.put(val, freqMap.getOrDefault(val, 0) + 1);
            int freq = freqMap.get(val);
            if (freq > maxFreq) maxFreq = freq;
            stackMap.putIfAbsent(freq, new Stack<>());
            stackMap.get(freq).push(val);
        }

        public int pop() {
            Stack<Integer> stack = stackMap.get(maxFreq);
            Integer val = stack.pop();
            if (stack.size() == 0) maxFreq--;
            freqMap.put(val, freqMap.get(val) - 1);
            return val;
        }
    }
}
