package ru.job4j.vacancyparser;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.job4j.DateExtractor;
import ru.job4j.Field;

import java.sql.Timestamp;

public class SqlRuDate implements Field<Timestamp> {
    private Timestamp date;
    private Element element;
    private String tag = "td";
    private int position = 5;

    public SqlRuDate(Element element) {
        this.element = element;
        setDescription();
    }

    @Override
    public void setDescription() {
        Elements els = element.getElementsByTag(tag);
        String result = els.get(position).text();
        DateExtractor de = new SqlRuDateExtractor("сегодня", "вчера", new String[]{"янв", "фев", "мар", "апр", "май",
                "июн", "июл", "авг", "сен", "окт", "ноя", "дек"});
        date = new Timestamp(de.convertDate(result, "d MMM yy, hh:mm", "ru").getTime());
    }

    @Override
    public Timestamp getDescription() {
        return this.date;
    }
}
