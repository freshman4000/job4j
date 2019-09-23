package ru.job4j.vacancyparser;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.job4j.Field;

public class SqlRuRef implements Field<String> {
    private String ref;
    private Element element;
    private String tag = "td";
    private int position = 1;

    public SqlRuRef(Element element) {
        this.element = element;
        setDescription();
    }

    @Override
    public void setDescription() {
        Elements els = element.getElementsByTag(tag);
        ref = els.get(position).select("a[href]").attr("href");
    }

    @Override
    public String getDescription() {
        return this.ref;
    }
}
