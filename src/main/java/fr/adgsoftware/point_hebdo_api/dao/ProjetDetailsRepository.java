package fr.adgsoftware.point_hebdo_api.dao;

import fr.adgsoftware.point_hebdo_api.entity.ProjetDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetDetailsRepository extends JpaRepository<ProjetDetails, Long>{

}