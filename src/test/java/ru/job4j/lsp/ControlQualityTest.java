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
        Food milk = new Food("Milk", LocalDate.now().plusDays(18),
                LocalDate.now().minusDays(1),  20.0F, 0.5f);
        Food grachka = new Food("grachka", LocalDate.now().plusDays(3),
                LocalDate.now().minusDays(4),  20.0F, 0.5f);
        Food berry = new Food("berry", LocalDate.now().plusDays(2),
                LocalDate.now().minusDays(7),  20.0F, 0.5f);
        Store shop = new Shop();
        List<Store> store = List.of(shop);
        List<Food> foodList = List.of(milk, grachka, berry);
        ControlQuality cq = new ControlQuality(store);
        cq.add(foodList);
        Food berryShop = new Food("berry", LocalDate.now().plusDays(2),
                LocalDate.now().minusDays(7),  10.0F, 0.5f);
        List<Food> exp = List.of(grachka, berryShop);
        assertThat(shop.getFoodList(), is(exp));
    }

    @Test
    public void whenAddTrash() throws ParseException {
        Food milk = new Food("Milk", LocalDate.now().minusDays(1),
                LocalDate.now().minusDays(6),  20.0F, 0.5f);
        Food grachka = new Food("grachka", LocalDate.now().plusDays(5),
                LocalDate.now().minusDays(2),  20.0F, 0.5f);
        Food berry = new Food("berry", LocalDate.now().plusDays(2),
                LocalDate.now().minusDays(7),  20.0F, 0.5f);
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
        Food milk = new Food("Milk", LocalDate.now().plusDays(18),
                LocalDate.now().minusDays(1),  20.0F, 0.5f);
        Food grachka = new Food("grachka", LocalDate.now().plusDays(5),
                LocalDate.now().minusDays(2),  20.0F, 0.5f);
        Food berry = new Food("berry", LocalDate.now().plusDays(2),
                LocalDate.now().minusDays(7),  20.0F, 0.5f);
        Store warehouse = new Warehouse();
        List<Store> store = List.of(warehouse);
        List<Food> foodList = List.of(milk, grachka, berry);
        ControlQuality cq = new ControlQuality(store);
        cq.add(foodList);
        List<Food> exp = List.of(milk);
        assertThat(warehouse.getFoodList(), is(exp));
    }

    @Test
    public void whenAllShopsTest() throws ParseException {
        Food milk = new Food("Milk", LocalDate.now().minusDays(1),
                LocalDate.now().minusDays(10), 20.0F, 0.5f);
        Food grachka = new Food("grachka", LocalDate.now().minusDays(1),
                LocalDate.now().minusDays(10), 20.0F, 0.5f);
        Food berry = new Food("berry", LocalDate.now().minusDays(1),
                LocalDate.now().minusDays(10), 20.0F, 0.5f);
        Store trash = new Trash();

        Food milk2 = new Food("Milk", LocalDate.now().plusDays(10),
                LocalDate.now().minusDays(10), 20.0F, 0.5f);
        Food grachka2 = new Food("grachka", LocalDate.now().plusDays(10),
                LocalDate.now().minusDays(10), 20.0F, 0.5f);
        Food berry2 = new Food("berry", LocalDate.now().plusDays(10),
                LocalDate.now().minusDays(10), 20.0F, 0.5f);
        Store shop = new Shop();


        Food milk3 = new Food("Milk", LocalDate.now().plusDays(10),
                LocalDate.now().minusDays(3), 20.0F, 0.5f);
        Food grachka3 = new Food("grachka", LocalDate.now().plusDays(10),
                LocalDate.now().minusDays(3), 20.0F, 0.5f);
        Food berry3 = new Food("berry", LocalDate.now().plusDays(10),
                LocalDate.now().minusDays(3), 20.0F, 0.5f);

        Store warehouse = new Warehouse();
        List<Store> store = List.of(trash, shop, warehouse);
        List<Food> foodList = List.of(milk, grachka, berry, milk2,
                grachka2, berry2, milk3, grachka3, berry3);
        ControlQuality cq = new ControlQuality(store);
        cq.add(foodList);
        assertThat(trash.getFoodList(), is(List.of(milk, grachka, berry)));
        assertThat(warehouse.getFoodList(), is(List.of(milk3, grachka3, berry3)));
        assertThat(shop.getFoodList(), is(List.of(milk2, grachka2, berry2)));
    }
}