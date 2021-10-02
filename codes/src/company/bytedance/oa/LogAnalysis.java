package company.bytedance.oa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LogAnalysis {
    int logAnalysis(String log) {
        String[] batches = log.split("&&");
        List<Integer> list = new ArrayList<>();
        for (String batch : batches) {
            String content = batch.split("\\||")[1];
            String[] records = content.split(";");
            for (String record : records) {
                String pre = record.split(",")[0];
                if (pre.charAt(pre.length() - 1) == 1) {
                    list.add(Integer.parseInt(record.split(":")[1]));
                }
            }
        }
        Collections.sort(list);
        if (list.size() % 2 != 0) {
            return list.get(list.size() / 2);
        } else {
            return (list.get(list.size() / 2) + list.get(list.size() / 2 - 1)) / 2;
        }
    }
}
