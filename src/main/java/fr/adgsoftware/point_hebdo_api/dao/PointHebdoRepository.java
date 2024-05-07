package fr.adgsoftware.point_hebdo_api.dao;

import fr.adgsoftware.point_hebdo_api.entity.PointHebdo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PointHebdoRepository extends JpaRepository<PointHebdo, Long> {

    List<PointHebdo> findByUserId(Long id);

}
