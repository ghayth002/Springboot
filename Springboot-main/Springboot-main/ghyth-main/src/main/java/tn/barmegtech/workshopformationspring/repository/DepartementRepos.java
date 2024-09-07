package tn.barmegtech.workshopformationspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.barmegtech.workshopformationspring.entites.Departement;


import java.util.List;

public interface DepartementRepos extends JpaRepository<Departement ,Long> {
    @Query("select u from Departement u where u.nom LIKE  %:name%")
    List<Departement> findDepartementByname(@Param("name") String name);
}
