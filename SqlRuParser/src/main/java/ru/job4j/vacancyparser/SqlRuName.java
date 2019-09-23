package ru.job4j.vacancyparser;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.job4j.Field;

public class SqlRuName implements Field<String> {
    private String name;
    private Element element;
    private String tag = "td";
    private int position = 1;

    public SqlRuName(Element element) {
        this.element = element;
        setDescription();
    }

    @Override
    public void setDescription() {
        Elements els = element.getElementsByTag(tag);
        name = els.get(position).text();

    }

    @Override
    public String getDescription() {
        return this.name;
    }
}
