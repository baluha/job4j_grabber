package ru.job4j.srp;

import java.util.List;

public interface SomeService {
    public List<Users> searchUsers(String name);
    public List<Players> searchPlayers(String name);
    public List<Organizator> searchOrganizator(String name);
    public boolean addUser(Users users);
    public boolean addPlayer(Players players);
    public boolean addOrganizator(Organizator organizator);
    public boolean deleteUser(Users users);
    public boolean deletePlayer(Players players);
    public boolean deleteOrganizator(Organizator organizator);
}
