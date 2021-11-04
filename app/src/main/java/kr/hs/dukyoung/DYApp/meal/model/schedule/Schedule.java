package kr.hs.dukyoung.DYApp.meal.model.schedule;

public class Schedule {

    private int month;
    private int day;
    private String menus;

    protected Schedule(int month, int day, String menus) {
        this.month = month;
        this.day = day;
        this.menus = menus;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public String getMenus() { return menus;
    }
}
