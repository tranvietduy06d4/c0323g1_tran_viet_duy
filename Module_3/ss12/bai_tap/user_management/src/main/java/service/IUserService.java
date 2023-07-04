package service;

import model.User;

import java.util.List;

public interface IUserService {
    List<User> displayAll();
    void create(User user);
    List<User> getByCountry(String country);
}
