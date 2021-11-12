package company.fbr4.q600;

import java.util.List;
import java.util.Stack;

public class Q636 {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Log> stack = new Stack<>();
        int[] res = new int[n];
        for (String s : logs) {
            Log log = new Log(s);
            if (!stack.isEmpty() && !log.isStart) {
                int duration = log.time - stack.pop().time + 1;
                res[log.id] += duration;
                if (!stack.isEmpty()) {
                    res[stack.peek().id] -= duration;
                }
            } else {
                stack.push(log);
            }
        }
        return res;
    }

    class Log {
        int id;
        int time;
        boolean isStart;

        public Log(String s) {
            String[] split = s.split(":");
            id = Integer.parseInt(split[0]);
            isStart = split[1].equals("start");
            time = Integer.parseInt(split[2]);
        }
    }
}
