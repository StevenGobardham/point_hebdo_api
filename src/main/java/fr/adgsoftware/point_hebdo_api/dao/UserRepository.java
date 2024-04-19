package fr.adgsoftware.point_hebdo_api.dao;

import fr.adgsoftware.point_hebdo_api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

}
