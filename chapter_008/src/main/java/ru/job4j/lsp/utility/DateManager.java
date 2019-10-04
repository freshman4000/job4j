package ru.job4j.lsp.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
/**
 * Class, that does handy data conversions.
 */
public class DateManager {
    /**
     * Converts date from string to Date.
     * @param date passed date in string format.
     * @return date in string format.
     */
    public static Date convertDate(String date) {
        Date result = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        try {
            result = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Converts date in string format to Date format.
     * @param date passed date in Date format.
     * @return date in Date format.
     */
    public static String convertDate(Date date) {
        String result = "";
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
            result = sdf.format(date);
        return result;
    }

    /**
     * This method converts passed date in date format to String date format subtracted or increased by
     * specified number of days.
     * @param date passed date in date format.
     * @param days that are needed to be subtracted subtract or to be added to passed date.
     * @return date in string format.
     */
    public static String convertDate(Date date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);
        Date newDate = cal.getTime();
        String result = "";
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        result = sdf.format(newDate);
        return result;
    }
}
