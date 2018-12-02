import java.util.*;

public class test {
    public static void main(String[] args) throws Exception {
        /* Your code here! */

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        Date startDate = getFirstDateOfPrevMonth();
        Date endDate = getLastDateOfPrevMonth();

        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "dd-MMM-yyyy");
        System.out.println(dateFormat.format(startDate));
        System.out.println(dateFormat.format(endDate));
    }

    public static Date getFirstDateOfPrevMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DATE, calendar.getActualMinimum(Calendar.DATE));
        calendar.add(Calendar.MONTH, -1);

        return calendar.getTime();
    }

    public static Date getLastDateOfPrevMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
        return calendar.getTime();
    }
}
