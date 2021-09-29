package karat.meeting;

import java.util.*;

public class Q2 {
    public static List<int[]> spareTime(int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> (a[0] - b[0]));
        List<int[]> res = new ArrayList<>();
        List<int[]> meetingList = mergeMeetings(meetings);
        if (meetingList.get(0)[0] > 0) {
            res.add(new int[]{0, meetingList.get(0)[0]});
        }
        for (int i = 1; i < meetingList.size(); i++) {
            res.add(new int[]{meetingList.get(i - 1)[1], meetingList.get(i)[0]});
        }
        return res;
    }

    private static List<int[]> mergeMeetings(int[][] meetings) {
        List<int[]> list = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < meetings.length; i++) {
            start = meetings[i][0];
            end = meetings[i][1];
            while (i < meetings.length - 1 && end >= meetings[i + 1][0]) {
                end = Math.max(end, meetings[i + 1][1]);
                i++;
            }
            list.add(new int[]{start, end});
        }
        return list;
    }
}
