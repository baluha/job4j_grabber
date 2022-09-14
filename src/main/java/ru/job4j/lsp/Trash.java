package ru.job4j.lsp;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Trash implements Store {

    private final List<Food> foodList = new ArrayList<>();
    private static final int PERCENT = 100;

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
    public boolean accept(Food food) throws ParseException {
        float spoilage = getPercent(food);
        return spoilage >= Percent.HUNDRED;
    }

    @Override
    public List<Food> clear() {
        List<Food> del = new ArrayList<>(foodList);
        this.foodList.clear();
        return del;
    }

    public List<Food> getFoodList() {
        return new ArrayList<>(foodList);
    }
}
