package service;

import model.User;
import repository.IUserRepository;
import repository.UserRepository;

import java.util.List;

public class UserService implements IUserService{
    private IUserRepository userRepository = new UserRepository();
    @Override
    public List<User> displayAll() {
        return userRepository.displayAll();
    }

    @Override
    public void create(User user) {
        userRepository.create(user);
    }

    @Override
    public List<User> getByCountry(String country) {
        return userRepository.getByCountry(country);
    }
}
