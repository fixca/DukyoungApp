package kr.hs.dukyoung.DYApp.timetable.model;

public class Time {
    private int date;
    private int _class;
    private String title;

    protected Time(int date, int _class, String title) {
        this.date = date;
        this._class = _class;
        this.title = title;
    }

    public int get_class() {
        return _class;
    }

    public int getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Time{" +
                "date=" + date +
                ", _class=" + _class +
                ", title='" + title + '\'' +
                '}';
    }
}
