package ru.job4j.lsp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Store {

    private final List<Food> foodList = new ArrayList<>();

    abstract boolean add(Food food) throws ParseException;

    abstract boolean accept(Food food) throws ParseException;

    public static float getPercent(Food food) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date dateC = format.parse(food.getCreateDate().toString());
        Date dateE = format.parse(food.getExpiryDate().toString());
        Date current = format.parse("2022-07-12");
        long diff = dateE.getTime() - dateC.getTime();
        long now = dateE.getTime() - current.getTime();
        float nowF = (float) now / 84600000;
        float difF = (float) diff / 84600000;
        return 100 - ((nowF / difF) * 100);
    }

    public List<Food> getFoodList() {
        return new ArrayList<>(foodList);
    }
}
