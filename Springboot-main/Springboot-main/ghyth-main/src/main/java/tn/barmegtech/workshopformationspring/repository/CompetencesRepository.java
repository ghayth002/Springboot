package tn.barmegtech.workshopformationspring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.barmegtech.workshopformationspring.entites.Competences;
import tn.barmegtech.workshopformationspring.entites.Departement;

public interface CompetencesRepository extends JpaRepository<Competences, Long> {
	 @Query("select u from Competences u where u.titreCopmt LIKE  %:name%")
	    List<Competences> findComptByname(@Param("name") String name);
}
