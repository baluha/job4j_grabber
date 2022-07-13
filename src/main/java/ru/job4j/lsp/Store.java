package ru.job4j.lsp;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public abstract class Store {

    private List<Food> foodList = new ArrayList<>();

    void add(Food food) throws ParseException {
    }

    void delete(Food food) {
    }

    public List<Food> getFoodList() {
        return foodList;
    }
}
