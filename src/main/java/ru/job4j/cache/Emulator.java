package ru.job4j.cache;

import java.util.Scanner;

public class Emulator {

    private static final int CHOICE1 = 1;
    private static final int CHOICE2 = 2;
    private static final int CHOICE3 = 3;

    public static void showMenu() {
        System.out.println("Для загрузки содержимого в кэш введите 1 \n"
        + "Для получения содержимого введите 2 \n"
                + "Для выхода из программы введите 3");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите кешируемую дерикторию");
        String dir = scanner.nextLine();
        AbstractCache<String, String> cache = new DirFileCache(dir);
        System.out.println("Введите имя файла");
        String filename = scanner.nextLine();
        boolean run = true;
        while (run) {
            showMenu();
            int choice = scanner.nextInt();
            if (choice == CHOICE1) {
                cache.put(filename, cache.load(filename));
            }
            if (choice == CHOICE2) {
                System.out.println(cache.get(filename));
            }
            if (choice == CHOICE3) {
                run = false;
            }
        }
    }
}
