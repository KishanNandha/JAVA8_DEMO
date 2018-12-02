package date_time_api;

import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class LocalDateTimeDemo {
    public static  void  main(String[] args) {

        //Creating a LocalDate and reading its values
        LocalDate date = LocalDate.of(2014,3,18);
        System.out.println(date.getYear());
        System.out.println(date.getMonth());
        System.out.println(date.getDayOfMonth());
        System.out.println(date.lengthOfMonth());
        System.out.println(date.isLeapYear());

        //current date from the system clock
        LocalDate today = LocalDate.now();
        System.out.println(today);

        //The TemporalField is an interface defining how to access the value of a specific
        //field of a temporal object. The ChronoField enumeration implements this interface, so you can
        //conveniently use an element of that enumeration with the get method

        //Reading LocalDate values using a TemporalField

        int year = date.get(ChronoField.YEAR);
        int month = date.get(ChronoField.MONTH_OF_YEAR);
        int day = date.get(ChronoField.DAY_OF_MONTH);

        //Creating a LocalTime and reading its values

        LocalTime time = LocalTime.of(13,45,20);
        int hour = time.getHour();
        int minute = time.getMinute();
        int seconds = time.getSecond();

        //Both LocalDate and LocalTime can be created by parsing a String representing them.

        LocalDate date2 = LocalDate.parse("2014-03-18");
        LocalTime time2 = LocalTime.parse("13:45:20");

        //LocalDateTime directly or by combining a date
        //and a time

        // 2014-03-18T13:45:20
        LocalDateTime dt1 = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45, 20);
        LocalDateTime dt2 = LocalDateTime.of(date, time);
        LocalDateTime dt3 = date.atTime(13, 45, 20);
        LocalDateTime dt4 = date.atTime(time);
        LocalDateTime dt5 = time.atDate(date);

        //. You can also extract
        //the LocalDate or LocalTime component from a LocalDateTime using the toLocalDate and
        //toLocalTime methods:

        LocalDate date3 = dt1.toLocalDate();
        LocalTime time3 = dt1.toLocalTime();

        //Duration or a Period
        Duration d1 = Duration.between(time, time2);
        Duration d2 = Duration.between(dt1, dt2);
        Duration threeMinutes = Duration.ofMinutes(3);
        Duration threeMinutes2 = Duration.of(3, ChronoUnit.MINUTES);

        Period tenDays = Period.between(LocalDate.of(2014, 3, 8),
                LocalDate.of(2014, 3, 18));
        Period tenDays2 = Period.ofDays(10);
        Period threeWeeks = Period.ofWeeks(3);
        Period twoYearsSixMonthsOneDay = Period.of(2, 6, 1);





    }
}
