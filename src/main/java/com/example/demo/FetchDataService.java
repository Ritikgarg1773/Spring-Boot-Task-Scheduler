package com.example.demo;

//import java.util.List;
//import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FetchDataService extends JpaRepository<Employee,Integer>{
	
//	@Override
//	List<Employee> findAll();

//	Employee getOne();

//	@Query("SELECT e.salary FROM employee e where e.id=:id") 
//    Integer findBysalId(@Param("id") int id);


}
