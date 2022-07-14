package ru.job4j.lsp;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Warehouse extends Store {

    private final List<Food> foodList = new ArrayList<>();
    private static final int PERCENT = 25;

    @Override
    public boolean add(Food food) throws ParseException {
        boolean rsl = false;
        if (accept(food)) {
            foodList.add(food);
            rsl = true;
        }
        return rsl;
    }

    @Override
    boolean accept(Food food) throws ParseException {
        float spoilage = Store.getPercent(food);
        return spoilage < PERCENT;
    }

    public List<Food> getFoodList() {
        return new ArrayList<>(foodList);
    }
}
