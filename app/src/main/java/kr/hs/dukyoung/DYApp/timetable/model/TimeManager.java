package kr.hs.dukyoung.DYApp.timetable.model;

import java.util.LinkedList;
import java.util.Queue;

public class TimeManager {

    private Queue<Time> list = new LinkedList<>();

    private static TimeManager instance = null;

    private TimeManager() {

    }

    public static TimeManager getInstance() {
        if(instance == null) {
            instance = new TimeManager();
        }
        return instance;
    }

    public Time addInstance(int date, int _class, String title) {
        Time time = new Time(date, _class, title);
        list.offer(time);
        return time;
    }

    public Time getTime() {
        return list.poll();
    }

    public int size() {
        return list.size();
    }

}
