package ua.mgrin;

import lombok.Getter;
import lombok.Setter;

import java.text.DateFormat;
import java.time.LocalTime;
import java.util.Date;
@Getter
@Setter
public class Event {
    private int id;
    private String msg;
    private Date date;
    private DateFormat df;

    public Event(Date date, DateFormat df) {
        this.id = (int) (Math.random() * 1000);
        this.date = date;
        this.df = df;
    }

    String getMsg() {
        return msg;
    }

    int getID() {
        return id;
    }

    void setMsg(String msg) {
        this.msg = msg;
    }

    Date getDate() {
        return date;
    }

    void setDate(Date date) {
        this.date = date;
    }

    static boolean isDay(){
        LocalTime now = LocalTime.now();
        LocalTime startDay = LocalTime.of(8, 0);
        LocalTime endDay = LocalTime.of(17, 0);
        return now.isAfter(startDay) && now.isBefore(endDay);
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", date=" + df.format(date) +
                "}";
    }
}
