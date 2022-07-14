package ru.job4j.lsp;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Shop extends Store {

    private final List<Food> foodList = new ArrayList<>();
    private static final int MAX = 75;
    private static final int MIN = 25;
    private static final int SPOILED = 99;

    @Override
    public boolean add(Food food) throws ParseException {
        boolean rsl = false;
        float spoilage = Store.getPercent(food);
        if (accept(food)) {
            foodList.add(food);
            rsl = true;
        }
        if (!accept(food) && spoilage > MAX && spoilage <= SPOILED) {
            food.setPrice(food.getPrice() * food.getDiscount());
            foodList.add(food);
            rsl = true;
        }
        return rsl;
    }

    @Override
    boolean accept(Food food) throws ParseException {
        float spoilage = Store.getPercent(food);
        return spoilage < MAX && spoilage > MIN;
    }

    public List<Food> getFoodList() {
        return new ArrayList<>(foodList);
    }
}
