package ru.job4j.grabber;

import ru.job4j.grabber.utils.HarbCareerDateTimeParser;

import java.io.IOException;

public class TestClass {
    public static void main(String[] args) throws IOException {
        HabrCareerParse parse = new HabrCareerParse(new HarbCareerDateTimeParser());
        parse.list("https://career.habr.com").stream().forEach(s -> System.out.println(s));
    }
}
