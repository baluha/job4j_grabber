package ru.job4j.lsp;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Shop implements Store {

    private final List<Food> foodList = new ArrayList<>();

    @Override
    public boolean add(Food food) throws ParseException {
        boolean rsl = false;
        float spoilage = getPercent(food);
        if (accept(food)) {
            if (spoilage > Percent.MAX75 && spoilage <= Percent.SPOILED) {
                food.setPrice(food.getPrice() * food.getDiscount());
            }
            foodList.add(food);
            rsl = true;
        }
        return rsl;
    }

    @Override
    public boolean accept(Food food) throws ParseException {
        float spoilage = getPercent(food);
        return spoilage < Percent.HUNDRED && spoilage >= Percent.QUARTER;
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
