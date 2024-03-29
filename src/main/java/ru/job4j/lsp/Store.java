package ru.job4j.lsp;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public interface Store {

    boolean add(Food food) throws ParseException;

    boolean accept(Food food) throws ParseException;

    List<Food> clear();

    default float getPercent(Food food) throws ParseException {
        long a = ChronoUnit.DAYS.between(food.getCreateDate(), LocalDate.now());
        long b = ChronoUnit.DAYS.between(food.getCreateDate(), food.getExpiryDate());
        return  ((float) a / b) * 100;
    }

    List<Food> getFoodList();

}
