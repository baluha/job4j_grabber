package ru.job4j.ood.dip;

import java.io.FileWriter;
import java.io.IOException;
/* Сервис что то сохраняет на диск,
а если мы хотим сохранить что то в БД или перелать другому программисту/пользователю?
Неверная реализация. Нужно делать зависимоть от аобстракции
*/
public class SavingService {
    public void save(String path, String massage) throws IOException {
        try (FileWriter fileWriter = new FileWriter(path)) {
            fileWriter.write(massage);
        }
    }
}
