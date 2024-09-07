package tn.barmegtech.workshopformationspring.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.barmegtech.workshopformationspring.entites.Employee;

public interface EmployeRepository extends JpaRepository<Employee, Long> {
	@Query("select u from Employee u where u.fullname LIKE  %:name%")
	List<Employee> findemployebyname(@Param("name") String name);
	@Query("select u from Employee u where u.departement.responsable LIKE  %:name%")
	List<Employee> findemployebymanager(@Param("name") String name);
	@Query("SELECT u FROM Employee u WHERE u.dateRecrutement BETWEEN :startDate AND :endDate")
	List<Employee> findBydate(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
