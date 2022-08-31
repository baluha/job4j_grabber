package ru.job4j.lsp;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

public class TestClass {

    public static void main(String[] args) throws ParseException {
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
        shop.getFoodList().forEach(f -> System.out.println(f.getName() + " " + f.getPrice()));


    }
}
