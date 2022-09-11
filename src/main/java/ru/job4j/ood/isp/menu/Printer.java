package ru.job4j.ood.isp.menu;

public class Printer implements MenuPrinter {

    private static final String INDENT = "-";

    @Override
    public void print(Menu menu) {
        menu.forEach(i -> {
            int j = i.getNumber().split("\\.").length;
            if (j > 1) {
                System.out.println(INDENT.repeat(j)
                        + i.getNumber()
                        + i.getName());
            } else {
                System.out.println(i.getNumber()
                        + i.getName());
            }
        });
    }
}
