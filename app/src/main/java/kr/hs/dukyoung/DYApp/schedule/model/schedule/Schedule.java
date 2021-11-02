package kr.hs.dukyoung.DYApp.schedule.model.schedule;

public class Schedule {

    private int month;
    private int day;
    private String schedule;

    protected Schedule(int month, int day, String schedule) {
        this.month = month;
        this.day = day;
        this.schedule = schedule;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public String getSchedule() {
        return schedule;
    }
}
