package service;

import model.User;

import java.util.List;

public interface IUserService {
    List<User> displayAll();
    void create(User user);
    void remove(int id);
    List<User> getByCountry(String country);
    List<User> sortByName();

    User getById(int id);
}
