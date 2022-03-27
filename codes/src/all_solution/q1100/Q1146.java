package all_solution.q1100;

import java.util.*;

public class Q1146 {
    class SnapshotArray {
        List<TreeMap<Integer, Integer>> mapList = new ArrayList<>();
        int snapId = 0;

        public SnapshotArray(int length) {
            for (int i = 0; i < length; i++) {
                mapList.add(new TreeMap<>());
                mapList.get(i).put(0, 0);
            }
        }

        public void set(int index, int val) {
            mapList.get(index).put(snapId, val);
        }

        public int snap() {
            return snapId++;
        }

        public int get(int index, int snap_id) {
            return mapList.get(index).floorEntry(snap_id).getValue();
        }
    }
}
