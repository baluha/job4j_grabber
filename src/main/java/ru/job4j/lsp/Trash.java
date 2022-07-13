package ru.job4j.lsp;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Trash extends Store {

    private final List<Food> foodList = new ArrayList<>();

    @Override
    public void add(Food food) throws ParseException {
        float spoilage = ExpDate.percent(food.getExpiryDate(), food.getCreateDate());
        if (spoilage < 0) {
            foodList.add(food);
        }
    }

    @Override
    public void delete(Food food) {
        foodList.remove(food);
    }

    public List<Food> getFoodList() {
        return foodList;
    }
}
