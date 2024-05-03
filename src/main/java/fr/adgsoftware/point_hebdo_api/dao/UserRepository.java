package fr.adgsoftware.point_hebdo_api.dao;

import fr.adgsoftware.point_hebdo_api.entity.Test;
import fr.adgsoftware.point_hebdo_api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
    List<User> findByArchiveFalse();

};