package ru.job4j.lsp;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class ControlQuality {

    private List<Store> lst;

    public ControlQuality(List<Store> lst) {
        this.lst = lst;
    }

    public void add(List<Food> food) throws ParseException {
        for (Store store : lst) {
            for (Food f : food) {
                store.add(f);
            }
        }
        }

    public List<Store> getLst() {
        return new ArrayList<>(lst);
    }
}
