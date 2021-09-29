package karat.meeting;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q3 {
    //输入和输出是两个Map
    //比如：
    //room = {
    //{room1, 4}
    //{room2, 8}
    //}
    //
    //meeting = {
    //{meeting1, {size : 4, start : 1200, end : 1300}}
    //{meeting2, {size : 8, start : 1200, end : 1300}}
    //}
    //
    //输出应该是
    //{meeting1, room1}
    //{meeting2, room2}
    //
    //就是往房间里安排meeting，房间的人数限制要大于等于meeting的人数

    // some rough idea:
    // Mapping: MeetingRoom - Capcity, using for Heap1
    // Mapping: start time - meeting
    // Mapping: start time - numPeople
    // Mapping: start time - endtime
    // Mapping: UsedMeetingRoom - end time, using for Heap2
    // Heap1: all the meeting room, sort base on the capacity
    // Heap2: all the Used meeting room, sort base on the endTime
    // sort the start time
    // sort the end time
    // two pointers: start, end;
    //
    // loop the start: 0 - N:
    // if (start >= end):
    // pop the room in heap2 back
    // end++;
    //
    // loop the Heap1 to find one whose capacity is enough
    // if no such MeetingRoom: return impossible
    // else: pop the room, add to heap2, mapping put(room, end time of this start
    // time), add to result
}
