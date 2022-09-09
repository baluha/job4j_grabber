package ru.job4j.ood.isp.menu;

import java.util.Scanner;

public class TODOApp {
    private final Menu menu = new SimpleMenu();
    private final Scanner sc = new Scanner(System.in);
    private static final ActionDelegate ACTIONDELEGATE = System.out::println;
    private static final int ADD_TASK = 1;
    private static final int SUB_TASK = 2;
    private static final int PRINT = 3;
    private static final int EXIT = 4;
    private static final String TASK_MSG = "Ведите имя задачи";
    private static final String SUBTASK_MSG = "Ведите имя подзадачи";
    private static final String MSG = "1. Добьте задачу.\n"
            + "2.1 Добавить подзадачу.\n"
            + "3. Вывод всех задач на экран.\n"
            + "4. Выход";

    public void run() {
        MenuPrinter printer = new Printer();
        System.out.println(MSG);
        int var = -1;
        while (var != EXIT) {
            var = sc.nextInt();
            if (var == ADD_TASK) {
                System.out.println(TASK_MSG);
                String task = sc.next();
                menu.add(Menu.ROOT, task, ACTIONDELEGATE);
            }
            if (var == SUB_TASK) {
                System.out.println(TASK_MSG);
                String task = sc.next();
                System.out.println(SUBTASK_MSG);
                String subtask = sc.next();
                if (menu.select(task).isEmpty()) {
                    menu.add(Menu.ROOT, task, ACTIONDELEGATE);
                    menu.add(task, subtask, ACTIONDELEGATE);
                } else {
                    menu.add(task, subtask, ACTIONDELEGATE);
                }
            }
            if (var == PRINT) {
                printer.print(menu);
            }
            }
        }
    }


