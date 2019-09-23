package ru.job4j;

import java.util.Date;

public interface DateExtractor {
    Date convertDate(String incomingStringDate, String incomingDateFormat, String locale);
}
