package repository;

import model.User;

import java.util.List;

public interface IUserRepository {

    public List<User> displayAll();
    public void create(User user);

    public User getByID(int id);
    public void edit(User user);

    public void remove(int id);

    public List<User> getByCountry(String country);

    public List<User> sortByName();


}
