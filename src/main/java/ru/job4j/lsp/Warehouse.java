package ru.job4j.lsp;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Store {

    private final List<Food> foodList = new ArrayList<>();

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
        return getPercent(food) < Percent.QUARTER;
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
