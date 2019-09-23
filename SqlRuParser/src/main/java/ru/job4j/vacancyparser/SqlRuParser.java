package ru.job4j.vacancyparser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.job4j.ParsableInfo;
import ru.job4j.Parser;

import java.net.URL;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class SqlRuParser implements Parser {
    private static final Logger LOG = LogManager.getLogger(SqlRuParser.class.getName());
    private String url = "https://www.sql.ru/forum/job-offers/";
    private Timestamp oldestParsingDate;
    private int currentPage = 0;

    public SqlRuParser(int yearsFromNow) {
        this.oldestParsingDate = setParsingDate(yearsFromNow);
    }

    public void setOldestParsingDate(Timestamp oldestParsingDate) {
        this.oldestParsingDate = oldestParsingDate;
    }

    public Timestamp getOldestParsingDate() {
        return oldestParsingDate;
    }

    @Override
    public Elements getCurrentContent(URL url) {
        Elements result = null;
        try {
            result = Jsoup.parse(url, 3000).body().select("tr");
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
        return result;
    }

    @Override
    public boolean filteredInElement(Element element) {
        boolean result = false;
        if (element.children().hasClass("postslisttopic")) {
            String name = new SqlRuName(element).getDescription().toLowerCase();
            if (name.contains("java") && !name.contains("script")) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public Map<String, ParsableInfo> getFreshVacancies() {
        Map<String, ParsableInfo> result = new LinkedHashMap<>();
        boolean inTime = true;
        while (inTime) {
            Elements content = getCurrentContent(setNexUrl());
            for (Element cl : content) {
                if (filteredInElement(cl)) {
                    SqlRuDate date = new SqlRuDate(cl);
                    if (date.getDescription().before(oldestParsingDate)) {
                        inTime = false;
                        break;
                    }
                    SqlRuVacancy current = new SqlRuVacancy();
                    current.initFields(new SqlRuDate(cl),
                            new SqlRuName(cl),
                            new SqlRuRef(cl),
                            new SqlRuText(cl));
                    result.put((String) current.getFields().get(1).getDescription(), current);
                }
            }
        }
        return result;
    }

    @Override
    public Timestamp setParsingDate(int yearsAgo) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.YEAR, -yearsAgo);
        return new Timestamp(cal.getTime().getTime());
    }

    @Override
    public URL setNexUrl() {
        ++currentPage;
        URL result = null;
        try {
            result = new URL(url + currentPage);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
        return result;
    }
}