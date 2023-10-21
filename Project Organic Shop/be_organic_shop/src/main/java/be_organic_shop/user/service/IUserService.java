package be_organic_shop.user.service;

import be_organic_shop.user.model.Users;

public interface IUserService {
    Users findByUserName(String userName);

    boolean existsById(Long userId);
}
