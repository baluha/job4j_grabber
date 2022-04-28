package ru.job4j.grabber;


import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.job4j.grabber.utils.DateTimeParser;
import ru.job4j.grabber.utils.HarbCareerDateTimeParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HabrCareerParse implements Parse{

        private static final String SOURCE_LINK = "https://career.habr.com";

        private static final String PAGE_LINK = String.format("%s/vacancies/java_developer", SOURCE_LINK);

        private final DateTimeParser dateTimeParser;

        public HabrCareerParse(DateTimeParser dateTimeParser) {
            this.dateTimeParser = dateTimeParser;
    }

        public static void main(String[] args) throws IOException {
            HabrCareerParse hcp = new HabrCareerParse(new HarbCareerDateTimeParser());
            List<Post> lst = hcp.list(PAGE_LINK);
            lst.forEach(s -> System.out.println(s.getTitle()));
        }

    private String retrieveDescription(String link) throws IOException {
            Connection cn = Jsoup.connect(link);
            Document document = cn.get();
            Element description = document.selectFirst(".style-ugc");
            return description.text();
    }

    @Override
    public List<Post> list(String link)  {
            List<Post> lst = new ArrayList<>();
            Connection cn;
                for (int i = 1; i < 2; i++) {
                    cn = Jsoup.connect(link + "?page=" + i);
                    Document document = null;
                    try {
                        document = cn.get();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Elements rows = document.select(".vacancy-card__inner");
                    rows.forEach(row -> {
                        lst.add(getPost(row));
                    });
                }
        return lst;
    }

    public Post getPost(Element row) {
            Post post = null;
        Element titleElement = row.select(".vacancy-card__title").first();
        Element dateElement = row.select(".vacancy-card__date").first();
        Element linkElement = titleElement.child(0);
        String vacancyName = titleElement.text();
        String datetime = dateElement.child(0).attr("datetime");
        String linkTo = String.format("%s%s", SOURCE_LINK, linkElement.attr("href"));
        try {
            post = new Post(vacancyName, linkTo, retrieveDescription(linkTo), dateTimeParser.parse(datetime));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return post;
    }
}

