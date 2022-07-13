package ru.job4j.lsp;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Shop extends Store {

    private List<Food> foodList = new ArrayList<>();

    @Override
    public void add(Food food) throws ParseException {
        float spoilage = ExpDate.percent(food.getExpiryDate(), food.getCreateDate());
        System.out.println(spoilage);
        if (spoilage < 75 && spoilage > 25) {
            foodList.add(food);
        }
        if (spoilage < 25) {
            Food another = new Food(food.getName(), food.getExpiryDate(),
                    food.getCreateDate(), food.getPrice() * food.getDiscount(),
                    food.getDiscount());
            foodList.add(another);
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
