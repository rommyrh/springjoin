package com.example.test.repository;

import com.example.test.model.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<employee, Long> {
  

  

    @Query(value="SELECT max(e.salary) from employee e ",nativeQuery = true)
    int max();
    @Query(value="SELECT min(e.salary) from employee e",nativeQuery = true)
	int min();

    @Query(value="SELECT avg(e.salary) from employee e",nativeQuery = true)
    int avg();

    @Query(value="SELECT sum(e.salary) from employee e",nativeQuery = true)
    int sum();

    @Query(value="SELECT count(e.id) from employee e",nativeQuery = true)
    int cout();

    @Query(value="SELECT distinct * from employee e",nativeQuery = true)
    int distinct();
}

