package be_organic_shop.user.repository;

import be_organic_shop.user.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users,Long> {
    Users findByUserName(String userName);
}
