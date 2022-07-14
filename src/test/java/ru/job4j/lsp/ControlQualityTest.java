package ru.job4j.lsp;

import org.junit.Test;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ControlQualityTest {

    @Test
    public void whenAddShop() throws ParseException {
        Food milk = new Food("Milk", LocalDate.of(2022, 7, 30),
                LocalDate.of(2022, 7, 11),  20.0F, 0.5f);
        Food grachka = new Food("grachka", LocalDate.of(2022, 7, 17),
                LocalDate.of(2022, 7, 10),  20.0F, 0.5f);
        Food berry = new Food("berry", LocalDate.of(2022, 7, 14),
                LocalDate.of(2022, 7, 5),  20.0F, 0.5f);
        Store shop = new Shop();
        List<Store> store = List.of(shop);
        List<Food> foodList = List.of(milk, grachka, berry);
        ControlQuality cq = new ControlQuality(store);
        cq.add(foodList);
        Food berryShop = new Food("berry", LocalDate.of(2022, 7, 14),
                LocalDate.of(2022, 7, 5),  10.0F, 0.5f);
        List<Food> exp = List.of(grachka, berryShop);
        assertThat(shop.getFoodList(), is(exp));
    }

    @Test
    public void whenAddTrash() throws ParseException {
        Food milk = new Food("Milk", LocalDate.of(2022, 7, 11),
                LocalDate.of(2022, 7, 6),  20.0F, 0.5f);
        Food grachka = new Food("grachka", LocalDate.of(2022, 7, 17),
                LocalDate.of(2022, 7, 10),  20.0F, 0.5f);
        Food berry = new Food("berry", LocalDate.of(2022, 7, 14),
                LocalDate.of(2022, 7, 5),  20.0F, 0.5f);
        Store trash = new Trash();
        List<Store> store = List.of(trash);
        List<Food> foodList = List.of(milk, grachka, berry);
        ControlQuality cq = new ControlQuality(store);
        cq.add(foodList);
        List<Food> exp = List.of(milk);
        assertThat(trash.getFoodList(), is(exp));
    }

    @Test
    public void whenAddWarehouse() throws ParseException {
        Food milk = new Food("Milk", LocalDate.of(2022, 7, 30),
                LocalDate.of(2022, 7, 11),  20.0F, 0.5f);
        Food grachka = new Food("grachka", LocalDate.of(2022, 7, 17),
                LocalDate.of(2022, 7, 10),  20.0F, 0.5f);
        Food berry = new Food("berry", LocalDate.of(2022, 7, 14),
                LocalDate.of(2022, 7, 5),  20.0F, 0.5f);
        Store warehouse = new Warehouse();
        List<Store> store = List.of(warehouse);
        List<Food> foodList = List.of(milk, grachka, berry);
        ControlQuality cq = new ControlQuality(store);
        cq.add(foodList);
        List<Food> exp = List.of(milk);
        assertThat(warehouse.getFoodList(), is(exp));
    }
}