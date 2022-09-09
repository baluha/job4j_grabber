package ru.job4j.ood.dip;

import ru.job4j.gc.User;

import java.util.List;
import java.util.Objects;

/*Сервис сохраняет объект User в лист, а если бы в БД?
Снова проблемы с реализацией, нет зависимотси от абстракции.
 */

public class Service {
    List<Users> lst;

    public boolean add(User user) {
        return false;
    }
    public Users findById(int id) {
        return new Users();
    }
}

class Users {
    String name;
    int id;

    public Users() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Users users = (Users) o;
        return id == users.id
                && Objects.equals(name, users.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }
}
