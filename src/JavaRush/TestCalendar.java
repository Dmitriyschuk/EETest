package JavaRush;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class TestCalendar {
    public static void main(String[] args) {
        GregorianCalendar calendar = new GregorianCalendar(2017, Calendar.JANUARY , 25);
        calendar.set(Calendar.HOUR, 10);
        calendar.set(Calendar.MINUTE, 42);
        calendar.set(Calendar.SECOND, 12);
        System.out.println(calendar.getTime());

        SimpleDateFormat format = new SimpleDateFormat("yyyy, MMMM, dd");
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");

        System.out.println();
        System.out.println(format.format(calendar.getTime()));
        System.out.println();
        System.out.println(format2.format(calendar.getTime()));

    }
}
