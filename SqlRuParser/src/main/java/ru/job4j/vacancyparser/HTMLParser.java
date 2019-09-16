package ru.job4j.vacancyparser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.sql.Timestamp;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.*;

public class HTMLParser {
    private static final Logger LOG = LogManager.getLogger(HTMLParser.class.getName());
    private Map<String, Vacancy> parsedVacs = new LinkedHashMap<>();
    /**
     * URL for parsing.
     */
    private String url;
    /**
     * The oldest date for parsing. Specify @param ago in constructor in years back from today (f.e. -1 or -2).
     */
    private Date parseTime;

    /**
     * Parse constructor.
     *
     * @param url for parsing.
     * @param ago number of years back from current time.
     */
    public HTMLParser(String url, int ago) {
        this.url = url;
        this.parseTime = setParseTime(ago);

    }

    public Map<String, Vacancy> getParsedVacs() {
        return parsedVacs;
    }

    public Date getParseTime() {
        return parseTime;
    }

    public void setParseTime(Date parseTime) {
        this.parseTime = parseTime;
    }

    /**
     * Utility method that sets up oldest parsable date.
     *
     * @param inYears years +- from current date.
     * @return oldest date for parsing.
     */
    private Date setParseTime(int inYears) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.YEAR, -inYears);
        return cal.getTime();
    }

    /**
     * Gets the first message date on current page.
     *
     * @param pageNumber number of current page.
     * @return first message date on current page.
     */
    private Date getTheDateOfThePage(int pageNumber) {
        String result = "";
        Elements vacs = getElByUrlAndTag(url + "/" + pageNumber, "tr");
        for (Element classAndName : vacs) {
            Elements dateContaining = classAndName.getElementsByClass("altCol");
            for (Element vacs1 : dateContaining) {
                String dateString = vacs1.wholeText();
                if (dateString.matches(".*\\d\\d$")) {
                    result = dateString;
                }
            }
        }
        return dateConversion(result);
    }

    /**
     * Converts string date from parsing to real Date object.
     *
     * @param dateString date in string format from site.
     * @return conversted date object.
     */
    public static Date dateConversion(String dateString) {
        final Locale RU_LOCALE = new Locale("ru");
        final DateFormatSymbols RU_SYMBOLS = new DateFormatSymbols(RU_LOCALE);
        final String[] RU_MONTHS = {"янв", "фев", "мар", "апр", "май",
                "июн", "июл", "авг", "сен", "окт", "ноя", "дек"};
        RU_SYMBOLS.setMonths(RU_MONTHS);

        SimpleDateFormat sdf = new SimpleDateFormat("d MMM yy, hh:mm", RU_SYMBOLS);
        Date date = null;
        try {
            date = sdf.parse(dateString.trim());
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
        return date;
    }

    /**
     * This method creates objects of vacancies and puts all of them to HashMap.
     */
    public void getWholeContent() {
        int count = 1;
        while (true) {
            getContentFromSinglePage(url + "/" + count);
            count++;
            if (getTheDateOfThePage(count).before(parseTime)) {
                break;
            }
        }
    }

    /**
     * Gets all vacancies from current page. Utility method.
     *
     * @param pageUrl url of the page.
     */
    private void getContentFromSinglePage(String pageUrl) {
        Elements vacs = getElByUrlAndTag(pageUrl, "tr");
        for (Element classAndName : vacs) {
            String vacancy = "";
            String refLink = "";
            for (Element vacs1 : classAndName.getElementsByClass("postslisttopic")) {
                for (Element el : vacs1.children()) {
                    for (Element jj : el.getElementsByAttribute("href")) {
                        String result = jj.wholeText();
                        if (result.toLowerCase().contains("java") && !result.toLowerCase().contains("script")) {
                            vacancy = jj.wholeText();
                            refLink = jj.attr("href");
                        }
                    }
                }
            }
            Timestamp timestamp = null;
            for (Element vacs1 : classAndName.getElementsByClass("altCol")) {
                if (!vacancy.equals("")) {
                    String date = vacs1.wholeText();
                    if (date.matches(".*\\d\\d$")) {
                        Date curDate = dateConversion(date);
                        timestamp = new Timestamp(curDate.getTime());
                    }
                }
            }
            String vacancyText = "";
            if (!refLink.equals("")) {
                Elements context = getElByUrlAndTag(refLink, "td");
                int count = 0;
                for (Element insideContext : context) {
                    if (insideContext.getElementsByClass("msgBOdy").size() > 0) {
                        count++;
                        if (count == 2) {
                            vacancyText = insideContext.getElementsByClass("msgBody").eachText().get(0);
                        }
                    }
                }
            }
            if (timestamp != null && !vacancy.isEmpty() && !vacancyText.isEmpty() && !refLink.isEmpty()) {
                Vacancy currentVacancy = new Vacancy(timestamp, vacancy, vacancyText, refLink);
                parsedVacs.put(vacancy, currentVacancy);
            }
        }
    }

    private Elements getElByUrlAndTag(String url, String tag) {
        Document document = null;
        Elements vacs = null;
        try {
            document = Jsoup.connect(url).get();
            vacs = document.getElementsByTag(tag);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
        return vacs;
    }
}

