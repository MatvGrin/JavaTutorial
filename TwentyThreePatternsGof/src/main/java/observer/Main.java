package observer;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Main {
    public static void main(String[] args) {
        LocalDateTime localTime = LocalDateTime.now();
        String data = DateTimeFormatter.BASIC_ISO_DATE.format(localTime);
        System.out.println(data);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MMMM_yyyy");
        System.out.println(localTime.format(dtf));

        String format = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).format(localTime);
        System.out.println(format);

        String timeFormat = "HH:mm:ss";
        LocalTime time = LocalTime.of(14, 30);
        System.out.println(time.format(DateTimeFormatter.ofPattern(timeFormat)));




    }
}
