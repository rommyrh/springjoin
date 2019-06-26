package com.example.test.repository;

import java.util.ArrayList;
import java.util.List;

import com.example.test.model.departement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DeptRepository extends JpaRepository<departement, Long> {
    
	@Query(value="SELECT * from departement d  CROSS JOIN employee e", nativeQuery = true)
	ArrayList<departement> fetchCrossJoin();
	
	@Query(value = "SELECT * from employee d INNER JOIN departement e ON e.id = d.id_dept", nativeQuery = true)
    List<departement> fetchInnerJoin();
    
    @Query(value="SELECT * from departement e LEFT JOIN employee d ON e.id = d.id_dept",nativeQuery = true)
	List<departement> fetchLeftJoin();

	@Query(value="SELECT * from departement e RIGHT JOIN employee d ON e.id = d.id_dept",nativeQuery = true)
    List<departement> fetchRightJoin();
    
}


