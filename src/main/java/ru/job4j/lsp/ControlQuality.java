package ru.job4j.lsp;

import java.text.ParseException;
import java.util.List;

public class ControlQuality {

    private List<Store> lst;

    public ControlQuality(List<Store> lst) {
        this.lst = lst;
    }

    public void add(List<Food> food) throws ParseException {
        lst.forEach(store -> {
            food.forEach(f -> {
                try {
                    store.add(f);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            });
        });
        }

    public List<Store> getLst() {
        return lst;
    }
}
