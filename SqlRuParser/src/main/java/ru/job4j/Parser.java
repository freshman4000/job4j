package ru.job4j;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URL;
import java.sql.Timestamp;
import java.util.Map;

public interface Parser {

    Elements getCurrentContent(URL url);

    boolean filteredInElement(Element element);

    Map<String, ParsableInfo> getFreshVacancies();

    Timestamp setParsingDate(int yearsAgo);

    URL setNexUrl();
}
