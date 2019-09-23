package ru.job4j.vacancyparser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.job4j.Field;

import java.io.IOException;
import java.net.URL;

public class SqlRuText implements Field<String> {
    private String text;
    private Element element;
    private String tag = "td";
    private int position = 1;

    public SqlRuText(Element element) {
        this.element = element;
        setDescription();
    }

    @Override
    public void setDescription() {
        Elements els = element.getElementsByTag(tag);
        String ref = els.get(position).select("a[href]").attr("href");
        Elements els2ndLvl = null;
        try {
            els2ndLvl = Jsoup.parse(new URL(ref), 3000).body().select("table[class=msgTable]").select("tr");
        } catch (IOException e) {
            e.printStackTrace();
        }
        text = els2ndLvl.get(1).children().eachText().get(1);
    }

    @Override
    public String getDescription() {
        return this.text;
    }
}