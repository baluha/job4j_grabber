package ru.job4j.ood.isp.menu;

public class Printer implements MenuPrinter {

    private static final String D = "-";

    @Override
    public void print(Menu menu) {
        menu.forEach(i -> {
            if (i.getNumber().length() > 2) {
            System.out.println(D.repeat(i.getNumber().length())
                    + i.getNumber()
                    + i.getName());
        } else {
            System.out.println(i.getNumber()
                    + i.getName());
        }
        });
    }
}
