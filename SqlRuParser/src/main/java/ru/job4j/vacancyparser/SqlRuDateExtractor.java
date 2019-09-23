package ru.job4j.vacancyparser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.job4j.DateExtractor;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class SqlRuDateExtractor implements DateExtractor {
    private static final Logger LOG = LogManager.getLogger(SqlRuDateExtractor.class.getName());
    private static String valueForToday;
    private static String valueForYesterday;
    private static String[] monthsFormat = new String[12];

    public SqlRuDateExtractor(String valueForToday, String valueForYesterday, String[] monthsFormat) {
        this.valueForToday = valueForToday;
        this.valueForYesterday = valueForYesterday;
        this.monthsFormat = monthsFormat;
    }

    /**
     * Converts String date to Date object.
     *
     * @param incomingStringDate date in String format for conversion.
     * @param incomingDateFormat format of incoming date for conversion.
     * @param locale             desirable locale name.
     * @return date object wrapped in origin format.
     */
    @Override
    public Date convertDate(String incomingStringDate, String incomingDateFormat, String locale) {
        Date result = new Date();
        Calendar cal = Calendar.getInstance();
        if (!incomingStringDate.startsWith(valueForToday) && !incomingStringDate.startsWith(valueForYesterday)) {
            final Locale RU_LOCALE = new Locale(locale);
            final DateFormatSymbols RU_SYMBOLS = new DateFormatSymbols(RU_LOCALE);
            final String[] RU_MONTHS = monthsFormat;
            RU_SYMBOLS.setMonths(RU_MONTHS);

            SimpleDateFormat sdf = new SimpleDateFormat(incomingDateFormat, RU_SYMBOLS);
            try {
                result = sdf.parse(incomingStringDate.trim());
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
            }
        } else if (incomingStringDate.startsWith(valueForToday)) {
            int hour = Integer.parseInt(incomingStringDate.split(",")[1].trim().split(":")[0]);
            int minute = Integer.parseInt(incomingStringDate.split(",")[1].trim().split(":")[1]);
            cal.set(Calendar.HOUR, hour);
            cal.set(Calendar.MINUTE, minute);
            result = cal.getTime();
        } else if (incomingStringDate.startsWith(valueForYesterday)) {
            int hour = Integer.parseInt(incomingStringDate.split(",")[1].trim().split(":")[0]);
            int minute = Integer.parseInt(incomingStringDate.split(",")[1].trim().split(":")[1]);
            cal.add(Calendar.DATE, -1);
            cal.set(Calendar.HOUR, hour);
            cal.set(Calendar.MINUTE, minute);
            result = cal.getTime();
        }
        return result;
    }
}
