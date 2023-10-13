package be_organic_shop.user.repository;

import be_organic_shop.user.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Roles,Long> {
    Roles findByName(String roleName);

}
