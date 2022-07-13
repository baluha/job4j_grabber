package ru.job4j.lsp;

import org.junit.Test;

import java.text.ParseException;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ControlQualityTest {

    @Test
    public void whenAddShop() throws ParseException {
        Food milk = new Food("Milk", "2022-07-30", "2022-07-12",  20.0F, 0.5f);
        Food grachka = new Food("grachka", "2022-07-20", "2022-07-10",  20.0F, 0.5f);
        Food berry = new Food("berry", "2022-07-14", "2022-07-05",  20.0F, 0.5f);
        Store store = new Shop();
        ControlQuality.add(store, milk);
        ControlQuality.add(store, grachka);
        ControlQuality.add(store, berry);
        Food berryShop = new Food("berry", "2022-07-14", "2022-07-05",  10.0F, 0.5f);
        List<Food> exp = List.of(grachka, berryShop);
        assertThat(store.getFoodList(), is(exp));
    }

    @Test
    public void whenAddTrash() throws ParseException {
        Food milk = new Food("Milk", "2022-07-12", "2022-07-10",  20.0F, 0.5f);
        Food grachka = new Food("grachka", "2022-07-12", "2022-07-10",  20.0F, 0.5f);
        Food berry = new Food("berry", "2022-07-14", "2022-07-12",  20.0F, 0.5f);
        Store store = new Trash();
        ControlQuality.add(store, milk);
        ControlQuality.add(store, grachka);
        ControlQuality.add(store, berry);
        List<Food> exp = List.of(milk, grachka);
        assertThat(store.getFoodList(), is(exp));
    }

    @Test
    public void whenAddWarehouse() throws ParseException {
        Food milk = new Food("Milk", "2022-07-25", "2022-07-10",  20.0F, 0.5f);
        Food grachka = new Food("grachka", "2022-07-30", "2022-07-10",  20.0F, 0.5f);
        Food berry = new Food("berry", "2022-07-29", "2022-07-12",  20.0F, 0.5f);
        Store store = new Warehouse();
        ControlQuality.add(store, milk);
        ControlQuality.add(store, grachka);
        ControlQuality.add(store, berry);
        List<Food> exp = List.of(milk, grachka, berry);
        assertThat(store.getFoodList(), is(exp));
    }
}