package observer;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class ChangingDatasAndTimes {
    public static void main(String[] args) {
        LocalDateTime ldt1 = LocalDateTime.now();
//        LocalDateTime ld2 = ldt1.plusDays(7);
        LocalDateTime ld2 = ldt1.plusMinutes(8);
        System.out.println(ld2);

        LocalDateTime ldt2a = ldt1.plus(Period.ofWeeks(1));
        System.out.println(ldt2a + "----------");

        LocalDateTime ldt2b = ldt1.minus(Duration.ofHours(12));
        System.out.println(ldt2b + " +++");

        LocalDateTime ld3 = ldt1.withMonth(9);
        System.out.println(ld3);


        DateTimeFormatter parser = new DateTimeFormatterBuilder()
                .appendPattern("yyyyMMdd")
                .toFormatter();
        System.out.println(parser.parse("20230115", LocalDate::from));
    }
}
