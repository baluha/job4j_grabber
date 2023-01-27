package ru.job4j;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class TestClass {
    private static final String sourceLick = "https://vorkuta.hh.ru/search/" +
            "vacancy?area=1&search_field=name&search_field=" +
            "company_name&search_field=description&text=junior+Java+developer";
    public static int NUM_PAGES;

    public static void main(String[] args) throws IOException {
        Connection connection = Jsoup.connect(sourceLick);
        Document document = connection.get();
        Elements rows = document.select(".serp-item");
        rows.forEach(row -> {
            Element title = row.select(".serp-item__title").first();
            System.out.println(title);
        });
    }
}
