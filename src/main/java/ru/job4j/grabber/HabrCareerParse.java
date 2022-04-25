package ru.job4j.grabber;


import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

public class HabrCareerParse {

        private static Connection cn;

        private static final String SOURCE_LINK = "https://career.habr.com";

        private static final String PAGE_LINK = String.format("%s/vacancies/java_developer", SOURCE_LINK);

        public static void main(String[] args) throws IOException {
            for (int i = 1; i < 5; i++) {
                cn = Jsoup.connect(PAGE_LINK + "?page=" + i);
                Document document = cn.get();
                Elements rows = document.select(".vacancy-card__inner");
                rows.forEach(row -> {
                    Element titleElement = row.select(".vacancy-card__title").first();
                    Element dateElement = row.select(".vacancy-card__date").first();
                    Element linkElement = titleElement.child(0);
                    String vacancyName = titleElement.text();
                    String datetime = dateElement.child(0).attr("datetime");
                    String link = String.format("%s%s", SOURCE_LINK, linkElement.attr("href"));
                    System.out.printf("%s %s %s%n", vacancyName, link, datetime);
                    HabrCareerParse parser = new HabrCareerParse();
                    try {
                        System.out.println(parser.retrieveDescription(link));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }
        }

    private String retrieveDescription(String link) throws IOException {
            cn = Jsoup.connect(link);
            Document document = cn.get();
            return document.select(".job_show_description__body").first().text();
    }
    }

