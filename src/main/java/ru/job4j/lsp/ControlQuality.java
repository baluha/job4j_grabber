package ru.job4j.lsp;

import java.text.ParseException;

public class ControlQuality {

    private Store store;
    private Food food;

    public ControlQuality(Store store, Food food) {
        this.store = store;
        this.food = food;
    }

    public static void add(Store store, Food food) throws ParseException {
        store.add(food);
        }
    }
